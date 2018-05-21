import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * 
 * This class holds the system information ie all the packages that currently installed
 * in addition it also holds a set of all the packages that were installed explicitly by the user
 * @author Mudit Sahni
 *
 */
public class MySystem {

static List<Package> installedPackages = new ArrayList<Package>() ;
static Set<String> explicitlyInstalledPackages = new HashSet<String>();

public static void install(Package p, boolean isExplicitlyInstalled)
{
	System.out.println("\tInstalling "+p.name);
	installedPackages.add(p);
	if(isExplicitlyInstalled)
		explicitlyInstalledPackages.add(p.name);
}

public static void uninstall(Package p)
{
	System.out.println("\tRemoving "+p.name);
	installedPackages.remove(p);
	explicitlyInstalledPackages.remove(p.name);
}
}
