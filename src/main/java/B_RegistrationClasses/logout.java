package B_RegistrationClasses;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityClasses.CreateWordDocument;
import A_CommonUtilityClasses.Utilityclass;

public class logout 
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	static private WebElement logout_btn;
	
    // To logout the user
	public void Logout() throws HeadlessException, InvalidFormatException, IOException, AWTException
	{
		PageFactory.initElements(Utilityclass.driver, logout.class);
		Utilityclass.clickmethod(logout_btn);
		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Logout the User");
		CreateWordDocument.printResult("Execution Status: Passed.");
	}
}
