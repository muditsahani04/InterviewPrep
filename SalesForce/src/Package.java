import java.util.HashSet;
import java.util.Set;

/**
 * This class holds details of a given package
 * @author Mudit Sahni
 *
 */
public class Package {

String name = null;

// set of all the packages required by this package
Set<Package> requiredPackages = null;

// set of all the packages that are dependent on this package 
Set<Package> dependentPackages = null;

	public Package(String Name)
	{
		name = Name;
		requiredPackages = new HashSet<Package>();
		dependentPackages = new HashSet<Package>();
	}
}
