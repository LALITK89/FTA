package B_RegistrationClasses;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityClasses.CreateWordDocument;
import A_CommonUtilityClasses.TestData;
import A_CommonUtilityClasses.Utilityclass;

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
		PageFactory.initElements(Utilityclass.driver, Login_User.class);// To use the WebElement refrenece in test case use Pagefactory calss
		Utilityclass.clickMethod(Login_link);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Open the Login Link");
		Utilityclass.inputMethod(Email_In,TestData.TDMap.get("User_Login_UserName_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the email id");
        Utilityclass.inputMethod(Password_In,TestData.TDMap.get("User_Login_Password_ED"));
        CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Password");
        Utilityclass.clickMethod(Login_btn);
        CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the login button to login the user");
        }
	     
 }