import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 
 * Entry point of the application.
 * Main() method reads the file "Commands.txt" and performs the operations
 * @author Mudit Sahni
 *
 */

public class SalesForce {

	public static void main(String[] args) {
		
		 // The name of the file to open.
        String fileName = "Commands.txt";

        // This will reference one line at a time
        String line = null;

        try {
            
            FileReader fileReader = 
                new FileReader(fileName);

            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
            	
            	// Execute the given command
                processCommand(line);
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + fileName + "'");
        }
    }

	/**
	 * Method to call the CommandManager to execute the given line
	 *@param line
	 */
	private static void processCommand(String line) {
		// TODO Auto-generated method stub
		CommandManager.executeCommand(line);
	}

}
