
/**
 * This class is responsible to execute commands and invoke the PackageManager
 * to process the request
 * @author Mudit Sahni
 *
 */
public class CommandManager {

	public static void executeCommand(String command)
	{
		System.out.println(command);
		if (command.startsWith("DEPEND"))
		{
			String[] packageNames = command.substring("DEPEND".length()+1).split(" ");
			executeDependCommand(packageNames);
		}
		else if (command.startsWith("INSTALL"))
		{
			String packageName = command.substring("INSTALL".length()+1);
			executeInstallCommand(packageName);
		}
		else if (command.startsWith("REMOVE"))
		{
			String packageName = command.substring("REMOVE".length()+1);
			executeRemoveCommand(packageName);
		}
		else if (command.startsWith("LIST"))
		{
			executeListCommand();
		}
	}

	private static void executeListCommand() {
	
		for (Package installedPackage: MySystem.installedPackages)
		{
			System.out.println("\t"+installedPackage.name);
		}
		
	}

	private static void executeDependCommand(String[] packageNames)
	{
		
		PackageManager.addPackages(packageNames);
		PackageManager.updatePackageDependencies(packageNames);
	}
	
	private static void executeInstallCommand(String packageName)
	{
		PackageManager.installPackage(packageName);
	}
	
	private static void executeRemoveCommand(String packageName)
	{
		PackageManager.uninstallPackage(packageName);
	}
}
