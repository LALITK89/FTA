package com.selenium.fta.Signup_User;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.fta.TestData.TestData;
import com.selenium.fta.WordDocument.CreateWordDocument;
import com.selenium.fta.utility_class.Utilityclass;


public class Signup_User 
{
	@FindBy(xpath ="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a\r\n")
	static private WebElement signup_btn;
	
	@FindBy(id="gender-male")
	static private WebElement Gender;
	
	@FindBy(id="FirstName")
	static private WebElement first_name;
	
	@FindBy(id="LastName")
	static private WebElement last_name;
	
	@FindBy(id="Email")
	static private WebElement Email_id;
	
	@FindBy(id="Password")
	static private WebElement password_In;
	
	@FindBy(id="ConfirmPassword")
	static private WebElement confirm_Password;
	
	@FindBy(id="register-button")
	static private WebElement register_btn;
	
	@FindBy(id ="btnSignUpSubmit-content")
	static private WebElement submt_btn;
	
	@FindBy(id ="/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li\r\n")
	static private WebElement Varify_msg;

public void signupuser() throws Exception
{
	    PageFactory.initElements(Utilityclass.driver, Signup_User.class);
 	    Utilityclass.clickmethod(signup_btn);
 	    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Signup link");
 	    Utilityclass.driverWait(Gender,100);
 	    Utilityclass.clickmethod(Gender);
 	    Utilityclass.driverWait(first_name,100);
 	    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Select the Gender");
 	    Utilityclass.inputmethod(first_name,TestData.TDMap.get("firstName_ED"));
 	    Utilityclass.driverWait(last_name,100);
 	    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the first name");
		Utilityclass.inputmethod(last_name,TestData.TDMap.get("LastName_ED"));
		Utilityclass.driverWait(Email_id,100);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the last name");
		Utilityclass.inputmethod(Email_id,TestData.TDMap.get("Signup_emailid"));
		Utilityclass.driverWait(password_In,100);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the signup email id");
		Utilityclass.inputmethod(password_In,TestData.TDMap.get("Password_ED"));
		Utilityclass.driverWait(confirm_Password,100);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the password");
		Utilityclass.inputmethod(confirm_Password,TestData.TDMap.get("Conf_Password_ED"));
		Utilityclass.driverWait(register_btn,100);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Confirm password");
		Utilityclass.clickmethod(register_btn);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Click on the register button");
	}
}
	
