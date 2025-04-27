package B_RegistrationClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityclasses.Input_TestData;
import A_CommonUtilityclasses.TPD_Document;
import A_CommonUtilityclasses.Utility_Class;

public class Login_User 
{
	@FindBy(xpath = "//a[@class ='ico-login']") //It will provide the identifier reference to below webelement
	static private WebElement Login_link; //It will use in same call only.
	
	@FindBy(id="Email")
	static private WebElement Email_In;
	
	@FindBy(id="Password")
	static private WebElement Password_In;
	
	@FindBy(id="RememberMe")
	static private WebElement Remeber_Chk;
	
	@FindBy(xpath = "//input[@class ='button-1 login-button']")
	static private WebElement Login_btn;
	
     
	public void loginUser() throws Exception
      {
		PageFactory.initElements(Utility_Class.driver, Login_User.class);// To use the WebElement refrenece in test case use Pagefactory calss
		Utility_Class.clickMethod(Login_link);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Open the Login Link");
		Utility_Class.inputMethod(Email_In,Input_TestData.TDMap.get("User_Login_UserName_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the email id");
        Utility_Class.inputMethod(Password_In,Input_TestData.TDMap.get("User_Login_Password_ED"));
        TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Password");
        Utility_Class.clickMethod(Login_btn);
        TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the login button to login the user");
        }
	     
 }