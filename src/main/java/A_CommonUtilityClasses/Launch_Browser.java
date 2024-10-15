package A_CommonUtilityClasses;
import java.io.IOException;

public class Launch_Browser 
{
	// To launch the browser and open the URL
	 public void Launchbrowser() throws InterruptedException, IOException
     {
      Utilityclass.configfile();	
      Utilityclass.browser(Utilityclass.propobj.getProperty("browser.name"));
      Utilityclass.driver.manage().window().maximize();
      Utilityclass.url(Utilityclass.propobj.getProperty("application.url"));      
     }
}
