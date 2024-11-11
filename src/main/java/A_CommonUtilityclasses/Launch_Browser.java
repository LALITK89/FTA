package A_CommonUtilityclasses;
import java.io.IOException;

public class Launch_Browser 
{
	// To launch the browser and open the URL
	 public void openBrowser() throws InterruptedException, IOException
     {
      Utility_Class.configFile();	
      Utility_Class.launchBrowser(Utility_Class.propobj.getProperty("browser.name"));
      Utility_Class.driver.manage().window().maximize();
      Utility_Class.openURL(Utility_Class.propobj.getProperty("application.url"));      
     }
}
