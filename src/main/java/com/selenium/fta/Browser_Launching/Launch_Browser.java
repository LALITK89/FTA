package com.selenium.fta.Browser_Launching;
import java.io.IOException;

import com.selenium.fta.utility_class.Utilityclass;

public class Launch_Browser 
{
	 public void Launchbrowser() throws InterruptedException, IOException
     {
      Utilityclass.configfile();	
      Utilityclass.browser(Utilityclass.propobj.getProperty("browser.name"));
      Utilityclass.driver.manage().window().maximize();
      //Utilityclass.driver.manage().timeouts().implicitlyWait(2000,TimeUnit.SECONDS);
      Utilityclass.url(Utilityclass.propobj.getProperty("application.url"));
      //Utilityclass.driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);

      
     }
}
