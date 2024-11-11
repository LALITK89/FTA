package C_OrderPlacingClasses;

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

public class Place_Order 
{
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/a" )
	static private WebElement Computer_link; 
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[2]/ul[1]/li[2]/ul/li[1]/a" )
	static private WebElement desktop_link; 
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div[2]/div[2]/div[3]/div[1]/div/div[2]/div[3]/div[2]/input" )
	static private WebElement AddToCard_btn; 
	
	@FindBy(id = "add-to-cart-button-72")
	static private WebElement cart_btn;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[3]/a/span[1]")
	static private WebElement shopping_cart;
	
	@FindBy(id = "termsofservice")
	static private WebElement terms_chk;
	
	@FindBy(id = "checkout")
	static private WebElement checkout_btn;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[1]/div[2]/div/input")
	static private WebElement Continue_btn;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[2]/div[2]/div/input")
	static private WebElement Continue_btn1;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[3]/div[2]/form/div[2]/input")
	static private WebElement Continue_btn2;
	
	@FindBy(id = "paymentmethod_2")
	static private WebElement Card_details;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[4]/div[2]/div/input")
	static private WebElement Continue_btn3;
	
	@FindBy(id = "CardholderName")
	static private WebElement CardholderName;
	
	@FindBy(id = "CardNumber")
	static private WebElement card_number;
	
	@FindBy(id = "CardCode")
	static private WebElement card_code;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[5]/div[2]/div/input")
	static private WebElement continue_btn4;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/ol/li[6]/div[2]/div[2]/input")
	static private WebElement confirm_btn;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")
	static private WebElement order_details;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div/div/div[2]/div/div[2]/input")
	static private WebElement Continue_btn5;
		
public void products() throws InterruptedException, IOException, HeadlessException, InvalidFormatException, AWTException
{
	//String TCID = "TC001";
	//TestData.GetactualScenarioData(TCID);
	PageFactory.initElements(Utility_Class.driver, Place_Order.class);
    Utility_Class.mouseHover(Computer_link);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Mouse hover on the Computer Menu");
    Utility_Class.clickMethod(desktop_link);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Open the desktop menu");
    Utility_Class.clickMethod(AddToCard_btn);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Add the product in the cart");
    Utility_Class.clickMethod(cart_btn);
    Utility_Class.clickMethod(shopping_cart);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Open the shopping cart");
    Utility_Class.clickMethod(terms_chk);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the checkout button");
    Utility_Class.scrollPage(checkout_btn);
    Utility_Class.clickMethod(checkout_btn);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the continue button");
    Utility_Class.scrollPage(Continue_btn);
    Utility_Class.clickMethod(Continue_btn);
    Utility_Class.driverWait(Continue_btn1,100);
    Utility_Class.scrollPage(Continue_btn1);
    Utility_Class.clickMethod(Continue_btn1);
    Utility_Class.driverWait(Continue_btn2,100);
    Utility_Class.scrollPage(Continue_btn2);
    Utility_Class.clickMethod(Continue_btn2);
    Utility_Class.driverWait(Card_details,100);
    Utility_Class.scrollPage(Card_details);
    Utility_Class.clickMethod(Card_details);
    Utility_Class.driverWait(Continue_btn3,100);
    Utility_Class.scrollPage(Continue_btn3);
    Utility_Class.clickMethod(Continue_btn3);
    Utility_Class.driverWait(CardholderName,100);
    Utility_Class.inputMethod(CardholderName,Input_TestData.TDMap.get("Card_Name_ED"));
    Utility_Class.inputMethod(card_number,Input_TestData.TDMap.get("Card_Number_ED"));
    Utility_Class.inputMethod(card_code,Input_TestData.TDMap.get("Card_CVV_ED"));
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the card details");
    Utility_Class.driverWait(continue_btn4,100);
    Utility_Class.scrollPage(continue_btn4);
    Utility_Class.clickMethod(continue_btn4);
    Utility_Class.driverWait(confirm_btn,100);
    Utility_Class.scrollPage(confirm_btn);
    Utility_Class.clickMethod(confirm_btn);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Check the order details");
    Utility_Class.driverWait(order_details,100);
    Utility_Class.scrollPage(order_details);
    Utility_Class.clickMethod(order_details);
    TPD_Document.captureScreenshotAndDescrptionInsertIntoWordDocument("Check the order listing");
}

}
