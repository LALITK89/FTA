package B_RegistrationClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityclasses.Input_TestData;
import A_CommonUtilityclasses.TPD_Document;
import A_CommonUtilityclasses.Utility_Class;


public class Signup_User 
{
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a")
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
	
public static String value = null;	
public String signupUser() throws Exception
{
	    PageFactory.initElements(Utility_Class.driver, Signup_User.class);
 	    Utility_Class.clickMethod(signup_btn);
 	    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Signup link");
 	    Utility_Class.driverWait(Gender,100);
 	    Utility_Class.clickMethod(Gender);
 	    Utility_Class.driverWait(first_name,100);
 	    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Select the Gender");
 	    Utility_Class.inputMethod(first_name,Input_TestData.TDMap.get("firstName_ED"));
 	    Utility_Class.driverWait(last_name,100);
 	    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the first name");
		Utility_Class.inputMethod(last_name,Input_TestData.TDMap.get("LastName_ED"));
		Utility_Class.driverWait(Email_id,100);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the last name");
		Utility_Class.inputMethod(Email_id,Input_TestData.TDMap.get("Signup_emailid"));
		String value = Utility_Class.driver.findElement(By.id("Email")).getText();
		Utility_Class.driverWait(password_In,100);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the signup email id");
		Utility_Class.inputMethod(password_In,Input_TestData.TDMap.get("Password_ED"));
		Utility_Class.driverWait(confirm_Password,100);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the password");
		Utility_Class.inputMethod(confirm_Password,Input_TestData.TDMap.get("Conf_Password_ED"));
		Utility_Class.driverWait(register_btn,100);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Confirm password");
		Utility_Class.clickMethod(register_btn);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the register button");
		return value;
	}
}
	
