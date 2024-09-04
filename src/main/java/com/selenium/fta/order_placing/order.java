package com.selenium.fta.order_placing;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.fta.TestData.TestData;
import com.selenium.fta.WordDocument.CreateWordDocument;
import com.selenium.fta.utility_class.Utilityclass;

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
    Utilityclass.mousehover(Computer_link);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Mouse hover on the Computer Menu");
    Utilityclass.clickmethod(desktop_link);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Open the desktop menu");
    Utilityclass.clickmethod(AddToCard_btn);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Add the product in the cart");
    Utilityclass.clickmethod(cart_btn);
    Utilityclass.clickmethod(shopping_cart);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Open the shopping cart");
    Utilityclass.clickmethod(terms_chk);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Click on the checkout button");
    Utilityclass.scrollpage(checkout_btn);
    Utilityclass.clickmethod(checkout_btn);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Click on the continue button");
    Utilityclass.scrollpage(Continue_btn);
    Utilityclass.clickmethod(Continue_btn);
    Utilityclass.driverWait(Continue_btn1,100);
    Utilityclass.scrollpage(Continue_btn1);
    Utilityclass.clickmethod(Continue_btn1);
    Utilityclass.driverWait(Continue_btn2,100);
    Utilityclass.scrollpage(Continue_btn2);
    Utilityclass.clickmethod(Continue_btn2);
    Utilityclass.driverWait(Card_details,100);
    Utilityclass.scrollpage(Card_details);
    Utilityclass.clickmethod(Card_details);
    Utilityclass.driverWait(Continue_btn3,100);
    Utilityclass.scrollpage(Continue_btn3);
    Utilityclass.clickmethod(Continue_btn3);
    Utilityclass.driverWait(CardholderName,100);
    Utilityclass.inputmethod(CardholderName,TestData.TDMap.get("Card_Name_ED"));
    Utilityclass.inputmethod(card_number,TestData.TDMap.get("Card_Number_ED"));
    Utilityclass.inputmethod(card_code,TestData.TDMap.get("Card_CVV_ED"));
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Enter the card details");
    Utilityclass.driverWait(continue_btn4,100);
    Utilityclass.scrollpage(continue_btn4);
    Utilityclass.clickmethod(continue_btn4);
    Utilityclass.driverWait(confirm_btn,100);
    Utilityclass.scrollpage(confirm_btn);
    Utilityclass.clickmethod(confirm_btn);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Check the order details");
    Utilityclass.driverWait(order_details,100);
    Utilityclass.scrollpage(order_details);
    Utilityclass.clickmethod(order_details);
    CreateWordDocument.CaptureScreenshotAndDescrptionInsertIntoWordDocument("Check the order listing");
}

}
