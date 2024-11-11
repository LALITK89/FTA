package B_RegistrationClasses;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityclasses.TPD_Document;
import A_CommonUtilityclasses.Utility_Class;

public class logout_User 
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	static private WebElement logout_btn;
	
    // To logout the user
	public void logoutUser() throws HeadlessException, InvalidFormatException, IOException, AWTException
	{
		PageFactory.initElements(Utility_Class.driver, logout_User.class);
		Utility_Class.clickMethod(logout_btn);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Logout the User");
		TPD_Document.printResult("Execution Status: Passed.");
	}
}
