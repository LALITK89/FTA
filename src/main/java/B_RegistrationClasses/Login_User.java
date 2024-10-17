package B_RegistrationClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityClasses.TPD_Document;
import A_CommonUtilityClasses.Input_TestData;
import A_CommonUtilityClasses.Utility_Class;

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