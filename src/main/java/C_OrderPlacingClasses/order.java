package C_OrderPlacingClasses;

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

public class order 
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
	PageFactory.initElements(Utilityclass.driver, order.class);
    Utilityclass.mouseHover(Computer_link);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Mouse hover on the Computer Menu");
    Utilityclass.clickMethod(desktop_link);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Open the desktop menu");
    Utilityclass.clickMethod(AddToCard_btn);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Add the product in the cart");
    Utilityclass.clickMethod(cart_btn);
    Utilityclass.clickMethod(shopping_cart);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Open the shopping cart");
    Utilityclass.clickMethod(terms_chk);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the checkout button");
    Utilityclass.scrollPage(checkout_btn);
    Utilityclass.clickMethod(checkout_btn);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Click on the continue button");
    Utilityclass.scrollPage(Continue_btn);
    Utilityclass.clickMethod(Continue_btn);
    Utilityclass.driverWait(Continue_btn1,100);
    Utilityclass.scrollPage(Continue_btn1);
    Utilityclass.clickMethod(Continue_btn1);
    Utilityclass.driverWait(Continue_btn2,100);
    Utilityclass.scrollPage(Continue_btn2);
    Utilityclass.clickMethod(Continue_btn2);
    Utilityclass.driverWait(Card_details,100);
    Utilityclass.scrollPage(Card_details);
    Utilityclass.clickMethod(Card_details);
    Utilityclass.driverWait(Continue_btn3,100);
    Utilityclass.scrollPage(Continue_btn3);
    Utilityclass.clickMethod(Continue_btn3);
    Utilityclass.driverWait(CardholderName,100);
    Utilityclass.inputMethod(CardholderName,TestData.TDMap.get("Card_Name_ED"));
    Utilityclass.inputMethod(card_number,TestData.TDMap.get("Card_Number_ED"));
    Utilityclass.inputMethod(card_code,TestData.TDMap.get("Card_CVV_ED"));
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Enter the card details");
    Utilityclass.driverWait(continue_btn4,100);
    Utilityclass.scrollPage(continue_btn4);
    Utilityclass.clickMethod(continue_btn4);
    Utilityclass.driverWait(confirm_btn,100);
    Utilityclass.scrollPage(confirm_btn);
    Utilityclass.clickMethod(confirm_btn);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Check the order details");
    Utilityclass.driverWait(order_details,100);
    Utilityclass.scrollPage(order_details);
    Utilityclass.clickMethod(order_details);
    CreateWordDocument.captureScreenshotAndDescrptionInsertIntoWordDocument("Check the order listing");
}

}
