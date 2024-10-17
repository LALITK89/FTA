package A_CommonUtilityClasses;

import java.awt.AWTException;
import java.io.File;
import java.io.IOException;
public class Clear_Cache 
{
	//To clear the browser Cookies cache And Data
  public static void deleteCookiesAndData() throws IOException, InterruptedException, AWTException
   {
	 try 
	  {
          //Get the project path
		    String directoryPath = System.getProperty("user.dir"); 
		    String batchFilePath = directoryPath+ "\\Files\\"; 
            ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "start","cache.bat");
            File dir = new File(batchFilePath);
            pb.directory(dir);
            Process process = pb.start();
			   
         // Wait for the process to complete
            int exitCode = process.waitFor();

         // Check the exit code
            if (exitCode == 0) 
            {
             System.out.println("Clear Cache batch file executed successfully."); 
            } 
            else 
            {
             System.out.println("Clear Cache batch file execution failed with exit code: " + exitCode);
            }
      } 
	 catch (IOException e) 
	   {
            System.err.println("IOException occurred: " + e.getMessage());
             } 
	        catch (InterruptedException e) 
	         {
            System.err.println("InterruptedException occurred: " + e.getMessage());
            Thread.currentThread().interrupt(); // Preserve interrupt status
              }
        }

     public static void main(String args[]) throws IOException, InterruptedException, AWTException
	        {
	        deleteCookiesAndData();
	        }
}
