package com.selenium.fta.TestNG;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.selenium.fta.Browser_Launching.Close_Browser;
import com.selenium.fta.Browser_Launching.Launch_Browser;
import com.selenium.fta.Clear_Cache.ClearCache;
import com.selenium.fta.Login_User.Login_User;
import com.selenium.fta.Logout_User.logout;
import com.selenium.fta.Signup_User.Signup_User;
import com.selenium.fta.TestData.TestData;
import com.selenium.fta.WordDocument.CreateWordDocument;
import com.selenium.fta.order_placing.order;
import com.selenium.fta.utility_class.Utilityclass;


public class TestNG 

{
	 @BeforeTest(alwaysRun = true)
     public void launch_browsers() throws InterruptedException, IOException, AWTException
         {
    	  ClearCache.DeleteCookiesAndData();
    	  Thread.sleep(5000);
    	  Launch_Browser browser =new Launch_Browser();
    	  browser.Launchbrowser();
         }
      @Test(priority = 1,groups = "Regression")
      public void signupuser() throws Exception
         {
    	  String TCID = "TC001";
  	      TestData.GetactualScenarioData(TCID);
  	      CreateWordDocument.documentCreation(TCID);   	  
    	  Signup_User signup = new Signup_User();
    	  signup.signupuser();
    	  String Actual_Value= "The specified email already exists";
    	  String Expected_Value= Utilityclass.driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li")).getText();
    	  System.out.println(Expected_Value);
     	  Assert.assertEquals(Actual_Value, Expected_Value);
    	   
         }
           
      @Test(priority = 2,groups = "Regression")
      public static void loginUser() throws Exception
         {
    	  Login_User loginobj= new Login_User();
    	  loginobj.login();
    	  
         }
      @Test(priority = 3,groups = "Regression")
      public static void placing_order() throws InterruptedException, IOException, HeadlessException, InvalidFormatException, AWTException
      {
    	  order orderobj = new order();
    	  orderobj.products();
      }
		
	  @AfterTest(alwaysRun = true) 
	  public void Logout_User() throws HeadlessException, InvalidFormatException, IOException, AWTException 
		 { 		  
		  logout logoutobj= new logout();
		  logoutobj.Logout();
		  Close_Browser close= new Close_Browser(); 
		  close.Browserclose(); 
	     }
		 
}
