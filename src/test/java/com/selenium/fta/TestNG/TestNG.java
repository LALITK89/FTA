package com.selenium.fta.TestNG;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.selenium.fta.browser.Close_Browser;
import com.selenium.fta.browser.Launch_Browser;
import com.selenium.fta.signup.Signup_User;

public class TestNG 

{
//	@BeforeMethod
//	public void run()
//	{
//		System.setProperty("webdriver.http.factory", "jdk-http-client");
//	}
      @BeforeMethod(alwaysRun = true)
      public void launch_browsers() throws InterruptedException, IOException
       {
    	  Launch_Browser browser =new Launch_Browser();
    	  browser.Launchbrowser();
       }
      
      @Test(priority = 1,groups = "Regression")
      public void signupuser() throws InterruptedException, IOException
       {
    	  Signup_User signup = new Signup_User();
    	  signup.signupuser();
       }
//      @AfterMethod(alwaysRun = true)
//      public void Close_browser()
//       {
//    	  Close_Browser close=   new Close_Browser();
//    	  close.Browserclose();  	  
//       }
}
