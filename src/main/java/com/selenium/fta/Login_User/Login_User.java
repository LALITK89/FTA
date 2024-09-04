package com.selenium.fta.Login_User;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.fta.TestData.TestData;
import com.selenium.fta.WordDocument.CreateWordDocument;
import com.selenium.fta.utility_class.Utilityclass;

public class Login_User 
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a") //It will provide the identifier refecnece to below webelement
	static private WebElement Login_link; //It will use in same call only.
	
	@FindBy(id="Email")
	static private WebElement Email_In;
	
	@FindBy(id="Password")
	static private WebElement Password_In;
	
	@FindBy(id="RememberMe")
	static private WebElement Remeber_Chk;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	static private WebElement Login_btn;
	
     
	public void login() throws Exception
      {
		PageFactory.initElements(Utilityclass.driver, Login_User.class);// To use the WebElement refrenece in test case use Pagefactory calss
		Utilityclass.clickmethod(Login_link);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Open the Login Link");
		Utilityclass.inputmethod(Email_In,TestData.TDMap.get("User_Login_UserName_ED"));
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the email id");
        Utilityclass.inputmethod(Password_In,TestData.TDMap.get("User_Login_Password_ED"));
        CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Password");
        Utilityclass.clickmethod(Login_btn);
        CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Click on the login button to login the user");
        }
	     
 }