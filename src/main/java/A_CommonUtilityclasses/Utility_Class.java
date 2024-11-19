package A_CommonUtilityclasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility_Class {
	public static Properties propobj =null;
	public static WebDriver driver=null;
	
	// To launch the browser
	public static WebDriver launchBrowser(String browsers)
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
	// To open the URL
	public static void openURL(String val)
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
	
	// To take the input from Configuration file
    public static void configFile() throws IOException
	{
		FileInputStream fis = new FileInputStream("Configuration//config.properties");
		propobj =new Properties();
		propobj.load(fis);
	}
    
    
    // To enter the value in field
    public static void inputMethod(WebElement web,String val)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				web.sendKeys(val);
			}
		}
	}
    
    // To click on the element
    public static void clickMethod(WebElement web)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				web.click();
			}
		}
	}
    
    // To mousehover on the element 
    public static void mouseHover(WebElement web)
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
    
    // To select the value from drop down list by using indexing
    public static void selectByIndexing(WebElement web, int val)
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
 // To select the value from drop down list by using visible text
    public static void selectByVisibletext(WebElement web, String val)
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
 // To select the value from drop down list by using value
    public static void selectByValue(WebElement web, String val)
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
 // To de-select the value from drop down list by using indexing
	public static void deselectByIndexing(WebElement web, int val)
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
	// To de-select the value from drop down list by using visible text
	public static void deselectByVisibletext(WebElement web, String val)
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
	// To de-select the value from drop down list by using value
	public static void deselectByValue(WebElement web, String val)
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
	// To scroll the page till element.
	public static void scrollPage(WebElement web)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				JavascriptExecutor js = (JavascriptExecutor)Utility_Class.driver;
				js.executeScript("arguments[0].scrollIntoView(true)", web);
			}
	     }
	 }
	
	// To right click on the element
	public static void contextClick(WebElement web)
	{
		if(web.isDisplayed())
		{
			if(web.isEnabled())
			{
				Actions actobj = new Actions(driver);
				actobj.contextClick(web).build().perform();		}
		}
	}
	
	// To drag and drop the element from one location to another location
	public static void dragAndDrop(WebElement Sourcelocator, WebElement Destinationlocator)
	{
		Actions actobj = new Actions(driver);
		actobj.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
	}
	
	// To dynamic wait
	public static void driverWait(WebElement web, int val)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(val));
		wait.until(ExpectedConditions.elementToBeClickable(web));
	}
	
	
	// To upload the attachment file
	public static void uploadFile(WebElement web, String filePath)
	{
		if(web.isDisplayed())
				{
			if(web.isEnabled())
					{
				driver.findElement(By.linkText("Upload a Document:( .tex, .txt, .doc, .docx, .odt, .pdf, .rtf )"));
				web.sendKeys(filePath);
				driver.close();
					}
				}
	  }
	// To switch on the window
	public static WebDriver switchTabs(String windowTitle)
	{
		Set<String> handle = driver.getWindowHandles();
		Iterator<String> ss = handle.iterator();
		while(ss.hasNext())
		{
			String handleval =  ss.next();
			WebDriver driver1 = driver.switchTo().window(handleval);
			String title = driver1.getTitle();
			if(title.equalsIgnoreCase(windowTitle))
			{
				return driver1;
			}
			//driver1.switchTo().defaultContent();
		}
		return driver;
	}
	}



