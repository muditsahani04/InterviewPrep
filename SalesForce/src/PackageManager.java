/**
 * PackageManager class is responsible for:
 * 1) Store all the available packages
 * 2) Update package dependencies
 * 3) Install a given package and all the packages required by the given package
 * 4) UnInstall a given package and also the packages that are required only this given package
 * @author Mudit Sahni
 *
 */
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PackageManager {
	// Map to store all the available packages whether currently installed or not
	static Map<String, Package> packages = new HashMap<String,Package>();

	/**
	 * Method to keep track of all the packages
	 * @param depPackages array of package names
	 */
	public static void addPackages(String[] depPackages)
	{
		
		for (String depPackageName : depPackages)
		{
			if (!packages.containsKey(depPackageName))
			{
				packages.put(depPackageName, new Package(depPackageName));
			}
		}
	}
	
	/**
	 * Method of update the relative dependencies of the packages
	 * as the "DEPEND" command is executed 
	 * @param pkgs array of package name such that pkgs[0] depends on pkgs[1] (and pkgs[2] and so on)
	 */
	public static void updatePackageDependencies(String[] pkgs)
	{
		Package parent = packages.get(pkgs[0]);
		Set<Package> required = new HashSet<Package>();
		for (int i =1; i<pkgs.length; i++)
		{
			required.add(packages.get(pkgs[i]));
		}
		updatePackageDependencies(parent,required);
	}
	
	/*
	 * Helper method to update dependencies
	 */
	private static void updatePackageDependencies(Package parentPackage, Set<Package> requiredPackes) {
		
		// Update dependency relationship of packages such that
		// if package1 is required by package2, then package2 is dependent on package1
		for (Package reqPkg : requiredPackes)
		{
			parentPackage.requiredPackages.add(reqPkg);
			reqPkg.dependentPackages.add(parentPackage);
		}
	}

	/**
	 * Method to install a package, given its name
	 * in the "INSTALL" 
	 * @param pkg name of the package to be installed
	 */
	public static void installPackage(String pkg)
	{
		if (!packages.containsKey(pkg))
			packages.put(pkg, new Package(pkg));
		installPackage(packages.get(pkg));
	}

	/**
	 * Helper method to install a given package
	 * @param p Package to be installed
	 */
	private static void installPackage(Package p)
	{
		if (MySystem.installedPackages.contains(p))
		{
			MySystem.explicitlyInstalledPackages.add(p.name);
			System.out.println("\t"+p.name+" is already installed");
		}
				
		else
		{
			installRequiredPackages(p, true);
		}
	}
	
	/**
	 * Recursive helper method to install all the given package and all the required packages
	 * @param p Package to be install
	 * @param isExplicit true if package is being install explicitly, false if the packaged in being 
	 * installed as a requirement for any other package ie installed implicitly
	 */
	private static void installRequiredPackages(Package p, boolean isExplicit)
	{
	
		for (Package req: p.requiredPackages)
		{
			installRequiredPackages(req, false);
		}
		if (!MySystem.installedPackages.contains(p))
			MySystem.install(p, isExplicit);
	}

	/**
	 * Method to uninstall a package, given its name in the "REMOVE" command
	 * @param pkg name of the package
	 */
	public static void uninstallPackage(String pkg)
	{
		uninstallPackage(packages.get(pkg), true);
	}

	/**
	 * Helper method to unInstall a given package
	 * @param pkg Package to be unInstalled
	 * @param isExplicit true if package is being unInstalled explicitly
	 */
	public static void uninstallPackage(Package pkg, boolean isExplicit)
	{
		if (!MySystem.installedPackages.contains(pkg) && isExplicit)
			System.out.println("\t"+pkg.name+" is not installed.");
		else
		{
			boolean isSafe = true;
			for (Package dep : pkg.dependentPackages)
			{
			  isSafe = isDependentInstalled(dep);
			  if (!isSafe)
				  break;
			}
			if (isSafe)
			{
				MySystem.uninstall(pkg);
				uninstalledAnyRequiredPackegs(pkg);
			}
				
			else
			{
				if (isExplicit)
					System.out.println("\t"+pkg.name+" is still needed.");
			}
		}
	}
	
	/**
	 * Helper method to check if there any other installed package that are dependent on the given package
	 * @param p Package to be unInstalled
	 * @return boolean true if any dependent package installed
	 */
	private static boolean isDependentInstalled(Package p)
	{
		if (MySystem.installedPackages.contains(p))
			return false;
		else
		{
			for(Package dep : p.dependentPackages)
			{
			 boolean isDepInstalled = isDependentInstalled(dep);
			 	if (!isDepInstalled)
				 return false;
			}		
		}
		return true;
	}

	/**
	 * Recursive helper method to unInstall any packages that are no more required
	 * @param pkg Package to be unInstalled
	 */
	private static void uninstalledAnyRequiredPackegs(Package pkg) {
		Set<Package> req = pkg.requiredPackages;
		for (Package p : req)
		{
			boolean isDepSafe = checkIfDepSafeToRemove(pkg,p);
			if (isDepSafe && !MySystem.explicitlyInstalledPackages.contains(p.name))
			{
				MySystem.uninstall(p);
			}	
		}
	}

	/**
	 * Helper method to check if it is safe to remove a required package of a given parent package
	 * such that no other package in system is dependent on this required package 
	 * @param parent Parent Package to be unInstalled 
	 * @param p required package of the parent package
	 */
	private static boolean checkIfDepSafeToRemove(Package parent, Package p) {
		for (Package pkg : packages.values())
		{
			if (!pkg.equals(parent))
			{
				if (pkg.requiredPackages.contains(p) && MySystem.installedPackages.contains(pkg))
					return false;
			}
		}
		return true;
	}

}
