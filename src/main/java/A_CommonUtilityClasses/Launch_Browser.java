package A_CommonUtilityClasses;
import java.io.IOException;

public class Launch_Browser 
{
	// To launch the browser and open the URL
	 public void openBrowser() throws InterruptedException, IOException
     {
      Utilityclass.configFile();	
      Utilityclass.launchBrowser(Utilityclass.propobj.getProperty("browser.name"));
      Utilityclass.driver.manage().window().maximize();
      Utilityclass.openURL(Utilityclass.propobj.getProperty("application.url"));      
     }
}
