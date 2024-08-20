package com.selenium.fta.TestNG;

import java.io.IOException;
import java.net.Socket;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.selenium.fta.browser.Close_Browser;
import com.selenium.fta.browser.Launch_Browser;
import com.selenium.fta.login.Login_User;
import com.selenium.fta.logout.logout;
import com.selenium.fta.order_placing.order;
import com.selenium.fta.signup.Signup_User;
import com.selenium.fta.utility.Utilityclass;

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
    	  //String Actual_Value= "The specified email already exists";
    	  //String Expected_Value= Utilityclass.driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li")).getAttribute("value");
    	  //String Expected_Value =Utilityclass.driver.findElement(By.className("validation-summary-errors")).getAttribute("value");
    	  //System.out.println(Expected_Value);
    	  //Assert.assertEquals(Actual_Value, Expected_Value);
    	
    	  
         }
           
      @Test(priority = 2,groups = "Regression")
      public static void loginUser()
         {
    	  Login_User loginobj= new Login_User();
    	  loginobj.login();
    	  
         }
      @Test(priority = 3,groups = "Regression")
      public static void placing_order() throws InterruptedException
      {
    	  order orderobj = new order();
    	  orderobj.products();
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
