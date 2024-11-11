package B1_EditRegistrationClasses;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityclasses.Input_TestData;
import A_CommonUtilityclasses.TPD_Document;
import A_CommonUtilityclasses.Utility_Class;

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
		PageFactory.initElements(Utility_Class.driver, Add_Address.class);// To use the WebElement refrenece in test case use Pagefactory calss	
		Utility_Class.clickMethod(user_email);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the email hyperlink");
		Utility_Class.clickMethod(Address_link);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Address menu");
		Utility_Class.clickMethod(Add_btn);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Add new button");
		Utility_Class.inputMethod(firstname,Input_TestData.TDMap.get("firstName_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the first name");
		Utility_Class.inputMethod(lastname,Input_TestData.TDMap.get("LastName_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the last name");
		Utility_Class.inputMethod(email_id,Input_TestData.TDMap.get("Signup_emailid"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the email id");
		Utility_Class.inputMethod(Comapny_Name,Input_TestData.TDMap.get("Comapny_Name_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the company name");
		Utility_Class.inputMethod(CountryId,Input_TestData.TDMap.get("Country_ID_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Select the country ID from drop down");
//		Utilityclass.inputmethod(StateProvinceId,TestData.TDMap.get("State_ID_ED"));
//		CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Select the state from drop down");
		Utility_Class.inputMethod(City,Input_TestData.TDMap.get("City_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the city name");
		Utility_Class.inputMethod(Address1,Input_TestData.TDMap.get("Address1_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Address1");
		Utility_Class.inputMethod(Address2,Input_TestData.TDMap.get("Address2_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Address2");
		Utility_Class.inputMethod(ZipPostalCode,Input_TestData.TDMap.get("ZipPostalCode_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Zip Postal Code");
		Utility_Class.inputMethod(PhoneNumber,Input_TestData.TDMap.get("PhoneNumber_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Phone Number");
		Utility_Class.inputMethod(FaxNumber,Input_TestData.TDMap.get("FaxNumber_ED"));
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the Fax Number");
		Utility_Class.clickMethod(save_btn);
		TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the Save button");
	}
	public static void main(String[] args) throws HeadlessException, InvalidFormatException, IOException, AWTException
{
		Add_Address addressobj = new Add_Address();
		addressobj.addAddress();
}
}

