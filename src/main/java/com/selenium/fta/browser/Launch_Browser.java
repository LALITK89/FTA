package com.selenium.fta.browser;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import com.selenium.fta.utility.Utilityclass;

public class Launch_Browser 
{
	 public void Launchbrowser() throws InterruptedException, IOException
     {
      Utilityclass.configfile();	
      Utilityclass.browser(Utilityclass.propobj.getProperty("browser.name"));
      Utilityclass.driver.manage().window().maximize();
      Utilityclass.driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
      Utilityclass.url(Utilityclass.propobj.getProperty("application.url"));
      Utilityclass.driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
     }
}
