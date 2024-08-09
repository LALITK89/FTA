package com.selenium.fta.utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Utilityclass 
 {
	public static Properties propobj =null;
	public static WebDriver driver=null;
	public static WebDriver browser(String browsers)
{
	if(browsers.equalsIgnoreCase("ch"))
      {
	     System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	    driver = new ChromeDriver();
      }
	
	else if(browsers.equalsIgnoreCase("FF"))
	  {
		System.setProperty("webdriver.chrome.driver","gechkodriver.exe");
		driver = new FirefoxDriver();
      }
	else if(browsers.equalsIgnoreCase("ie"))
	  {
		System.setProperty("webdriver.chrome.driver","internetIEDriver.exe");
		driver = new InternetExplorerDriver();
    }
	return driver;
}
	
	public static void url(String val)
	{
	if(val.equalsIgnoreCase("S42"))
	{
		driver.get("https://demowebshop.tricentis.com/");
	}
	else if(val.equalsIgnoreCase("UAT"))
	{
		driver.get("https://demowebshop.tricentis.com/");
	}
	else if(val.equalsIgnoreCase("PP"))
	{
		driver.get("https://demowebshop.tricentis.com/");
	}
	}
	
    public static void configfile() throws IOException
	{
		FileInputStream fis = new FileInputStream("Configuration//config.properties");
		propobj =new Properties();
		propobj.load(fis);
	}
	
    public static void inputmethod(WebElement web, String val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				web.sendKeys(val);
			}
		}
	}
    
    public static void clickmethod(WebElement web)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				web.click();
			}
		}
	}
    
    public static void mousehover(WebElement web)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Actions actobj = new Actions(driver);
				actobj.moveToElement(web).build().perform();
			}
		}
	}
    
    public static void selectbyindexing(WebElement web, int val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Select selobj= new Select(web);
				selobj.selectByIndex(val);
			}
		}
	}
    
    public static void selectbyvisibletext(WebElement web, String val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Select selobj= new Select(web);
				selobj.selectByVisibleText(val);;
			}
		}
	}
    
    public static void selectbyvalue(WebElement web, String val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Select selobj= new Select(web);
				selobj.selectByValue(val);;
			}
		}
	}
    
	public static void deselectbyindexing(WebElement web, int val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Select selobj= new Select(web);
				selobj.deselectByIndex(val);
			}
		}
	}
	
	public static void deselectbyvisibletext(WebElement web, String val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Select selobj= new Select(web);
				selobj.deselectByVisibleText(val);;
			}
		}
	}
	public static void deselectbyvalue(WebElement web, String val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Select selobj= new Select(web);
				selobj.deselectByValue(val);;
			}
		}
	}
	
	public static void scrollpage(WebElement web)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				JavascriptExecutor js = (JavascriptExecutor)Utilityclass.driver;
				js.executeScript("arguments[0].scrollIntoView(true)", web);
			}
	     }
	 }
 }
