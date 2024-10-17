package com.selenium.fta.TestNG;
import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import A_CommonUtilityClasses.ClearCache;
import A_CommonUtilityClasses.Close_Browser;
import A_CommonUtilityClasses.CreateWordDocument;
import A_CommonUtilityClasses.Launch_Browser;
import A_CommonUtilityClasses.TestData;
import A_CommonUtilityClasses.Utilityclass;
import B1_EditRegistrationClasses.Add_Address;
import B_RegistrationClasses.Login_User;
import B_RegistrationClasses.Signup_User;
import B_RegistrationClasses.logout_User;
import C_OrderPlacingClasses.order;


public class TestNG 

{
	//will execute before all @Test method
	 @BeforeMethod(alwaysRun = true)
     public void clearCacheAndOpenBrowser() throws InterruptedException, IOException, AWTException
         {
    	  ClearCache.deleteCookiesAndData();
    	  Thread.sleep(5000);
    	  Launch_Browser browser =new Launch_Browser();
    	  browser.openBrowser();
         }
	 
	 
	 //Sign up the user	 
      @Test(priority = 1,groups = "Regression")
      public void registerNewUser() throws Exception
         {
    	  String TCID = "TC001";
 	      TestData.getactualScenarioData(TCID);
 	      CreateWordDocument.documentCreation(TCID);
    	  Signup_User signup = new Signup_User();
    	  signup.signupUser();
    	  String Actual_Value= "The specified email already exists";
    	  String Expected_Value= Utilityclass.driver.findElement(By.xpath("/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li")).getText();
     	  Assert.assertEquals(Actual_Value, Expected_Value);
         }
         
      
      //Login the user
      @Test(priority = 2,groups = "Regression")
      public static void loginTheUser() throws Exception
         {
    	  String TCID = "TC002";
 	      TestData.getactualScenarioData(TCID);
 	      CreateWordDocument.documentCreation(TCID);
    	  Login_User loginobj= new Login_User();
    	  loginobj.loginUser();
         }
      
    //Add the new address
      @Test(priority = 3,groups = "Regression")
      public static void addNewAddress() throws Exception
      {
    	  String TCID = "TC004";
 	      TestData.getactualScenarioData(TCID);
 	      CreateWordDocument.documentCreation(TCID);
 	      Login_User loginobj= new Login_User();
   	      loginobj.loginUser();
    	  Add_Address addressobj = new Add_Address();
  		  addressobj.addAddress();
      }
      
      //Place the order
      @Test(priority = 4,groups = "Regression")
      public static void placeTheOrder() throws Exception
      {
    	  String TCID = "TC003";
 	      TestData.getactualScenarioData(TCID);
 	      CreateWordDocument.documentCreation(TCID);
    	  Login_User loginobj= new Login_User();
    	  loginobj.loginUser();
    	  order orderobj = new order();
    	  orderobj.products();
      }
		
      
      //will execute after all @Test method
	  @AfterMethod(alwaysRun = true) 
	  public void logoutTheUser() throws HeadlessException, InvalidFormatException, IOException, AWTException 
		 { 		  
		  logout_User Logoutobj= new logout_User();
		  Logoutobj.logoutUser();
		  Close_Browser close= new Close_Browser(); 
		  close.closeBrowser(); 
	     }
		 
}
