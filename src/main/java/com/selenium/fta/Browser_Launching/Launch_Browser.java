package com.selenium.fta.Browser_Launching;
import java.io.IOException;

import com.selenium.fta.utility_class.Utilityclass;

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
