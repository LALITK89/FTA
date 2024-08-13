package com.selenium.fta.TestNG;

import java.io.IOException;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.selenium.fta.browser.Close_Browser;
import com.selenium.fta.browser.Launch_Browser;
import com.selenium.fta.login.Login_User;
import com.selenium.fta.logout.logout;
import com.selenium.fta.signup.Signup_User;

public class TestNG 

{
      @BeforeTest(alwaysRun = true)
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
      
     
      @Test(priority = 2,groups = "Regression")
      public static void loginUser()
         {
    	  Login_User loginobj= new Login_User();
    	  loginobj.login();
         }
		
	  @AfterTest(alwaysRun = true) 
	  public void Logout_User() 
		 { 		  
		  logout logoutobj= new logout();
		  logoutobj.Logout();
		  Close_Browser close= new Close_Browser(); 
		  close.Browserclose(); 
	     }
		 
}
