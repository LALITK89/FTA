package B1_EditRegistrationClasses;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityClasses.CreateWordDocument;
import A_CommonUtilityClasses.TestData;
import A_CommonUtilityClasses.Utilityclass;

public class Add_Address 
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a") //It will provide the identifier refecnece to below webelement
	static private WebElement user_email; //It will use in same call only.
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[1]/div/div[2]/ul/li[2]/a")
	static private WebElement Address_link;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[2]/input")
	static private WebElement Add_btn;
	
	@FindBy(id="Address_FirstName")
	static private WebElement firstname;
	
	@FindBy(id="Address_LastName")
	static private WebElement lastname;
	
	@FindBy(id="Address_Email")
	static private WebElement email_id;
	
	@FindBy(id="Address_Company")
	static private WebElement Comapny_Name;
	
	@FindBy(id="Address_CountryId")
	static private WebElement CountryId;
	
	@FindBy(id="Address_StateProvinceId")
	static private WebElement StateProvinceId;
	
	@FindBy(id="Address_City")
	static private WebElement City;
	
	@FindBy(id="Address_Address1")
	static private WebElement Address1;
	
	@FindBy(id="Address_Address2")
	static private WebElement Address2;
	
	@FindBy(id="Address_ZipPostalCode")
	static private WebElement ZipPostalCode;
	
	@FindBy(id="Address_PhoneNumber")
	static private WebElement PhoneNumber;
	
	@FindBy(id="Address_FaxNumber")
	static private WebElement FaxNumber;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[2]/input")
	static private WebElement save_btn;
     
	public void addAddress() throws HeadlessException, InvalidFormatException, IOException, AWTException
	{
		PageFactory.initElements(Utilityclass.driver, Add_Address.class);// To use the WebElement refrenece in test case use Pagefactory calss	
		Utilityclass.clickMethod(user_email);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the email hyperlink");
		Utilityclass.clickMethod(Address_link);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Address menu");
		Utilityclass.clickMethod(Add_btn);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Add new button");
		Utilityclass.inputMethod(firstname,TestData.TDMap.get("firstName_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the first name");
		Utilityclass.inputMethod(lastname,TestData.TDMap.get("LastName_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the last name");
		Utilityclass.inputMethod(email_id,TestData.TDMap.get("Signup_emailid"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the email id");
		Utilityclass.inputMethod(Comapny_Name,TestData.TDMap.get("Comapny_Name_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the company name");
		Utilityclass.inputMethod(CountryId,TestData.TDMap.get("Country_ID_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Select the country ID from drop down");
//		Utilityclass.inputmethod(StateProvinceId,TestData.TDMap.get("State_ID_ED"));
//		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Select the state from drop down");
		Utilityclass.inputMethod(City,TestData.TDMap.get("City_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the city name");
		Utilityclass.inputMethod(Address1,TestData.TDMap.get("Address1_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Address1");
		Utilityclass.inputMethod(Address2,TestData.TDMap.get("Address2_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Address2");
		Utilityclass.inputMethod(ZipPostalCode,TestData.TDMap.get("ZipPostalCode_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Zip Postal Code");
		Utilityclass.inputMethod(PhoneNumber,TestData.TDMap.get("PhoneNumber_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Phone Number");
		Utilityclass.inputMethod(FaxNumber,TestData.TDMap.get("FaxNumber_ED"));
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Fax Number");
		Utilityclass.clickMethod(save_btn);
		CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Save button");
	}
	public static void main(String[] args) throws HeadlessException, InvalidFormatException, IOException, AWTException
{
		Add_Address addressobj = new Add_Address();
		addressobj.addAddress();
}
}

