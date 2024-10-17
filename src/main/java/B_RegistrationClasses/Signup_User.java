package B_RegistrationClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityClasses.CreateWordDocument;
import A_CommonUtilityClasses.TestData;
import A_CommonUtilityClasses.Utilityclass;


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
	
public static String value = null;	
public String signupUser() throws Exception
{
	    PageFactory.initElements(Utilityclass.driver, Signup_User.class);
 	    Utilityclass.clickMethod(signup_btn);
 	    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Signup link");
 	    Utilityclass.driverWait(Gender,100);
 	    Utilityclass.clickMethod(Gender);
 	    Utilityclass.driverWait(first_name,100);
 	    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Select the Gender");
 	    Utilityclass.inputMethod(first_name,TestData.TDMap.get("firstName_ED"));
 	    Utilityclass.driverWait(last_name,100);
 	    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the first name");
		Utilityclass.inputMethod(last_name,TestData.TDMap.get("LastName_ED"));
		Utilityclass.driverWait(Email_id,100);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the last name");
		Utilityclass.inputMethod(Email_id,TestData.TDMap.get("Signup_emailid"));
		String value = Utilityclass.driver.findElement(By.id("Email")).getText();
		Utilityclass.driverWait(password_In,100);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the signup email id");
		Utilityclass.inputMethod(password_In,TestData.TDMap.get("Password_ED"));
		Utilityclass.driverWait(confirm_Password,100);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the password");
		Utilityclass.inputMethod(confirm_Password,TestData.TDMap.get("Conf_Password_ED"));
		Utilityclass.driverWait(register_btn,100);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Confirm password");
		Utilityclass.clickMethod(register_btn);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the register button");
		return value;
	}
}
	
