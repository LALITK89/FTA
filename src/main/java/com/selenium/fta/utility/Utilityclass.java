package com.selenium.fta.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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
import com.jacob.com.LibraryLoader;
import autoitx4java.AutoItX;

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
	
	public static void contestclick(WebElement we)
	{
		if(we.isDisplayed())
		{
			if(we.isEnabled())
			{
				Actions actobj = new Actions(driver);
				actobj.contextClick(we).build().perform();		}
		}
	}
	public static void draganddrop(WebElement Sourcelocator, WebElement Destinationlocator  )
	{
		Actions actobj = new Actions(driver);
		actobj.dragAndDrop(Sourcelocator, Destinationlocator).build().perform();
	}
	
	public static void driverWait(WebElement web, Duration val)
	{
		WebDriverWait wait = new WebDriverWait(Utilityclass.driver, val);
		wait.until(ExpectedConditions.elementToBeClickable(By.id("web")));
	}
	
	//browser file from the local system.
		 public static void uploadfileAutoIT(String dialogTitle, String jcobDllPath, String pathFIleToUpload)
		 {
		 File file = new File(jcobDllPath);
		 System.setProperty(LibraryLoader.JACOB_DLL_PATH, file.getAbsolutePath());
		 AutoItX x = new AutoItX ();
		 x.winActivate(dialogTitle);
		 x.winWaitActive(dialogTitle);
		 
		 // To click on the Dialog pop ok button then you have to comment below line only
		 x.ControlSetText(dialogTitle, "", "Edit1", pathFIleToUpload);
		 x.controlClick(dialogTitle, "", "Button1");
		 }
		
		 public static void fileoutput(String validation) throws IOException 
		    {
		        XSSFWorkbook workbook = new XSSFWorkbook();
		        XSSFSheet sheet = workbook.createSheet("TestOutput");
		         
		        Object[][] bookData = {{validation},};
		 
		        int rowCount = 0;
		         
		        for (Object[] aBook : bookData) 
		        {
		            XSSFRow row = sheet.createRow(++rowCount);
		             
		            int columnCount = 0;
		             
		            for (Object field : aBook) 
		            {
		                Cell cell = row.createCell(++columnCount);
		                if (field instanceof String) 
		                {
		                    cell.setCellValue((String) field);
		                } 
		                else if (field instanceof Integer) 
		                {
		                    cell.setCellValue((Integer) field);
		                }
		            }
		             
		        } 
		         
		        try (FileOutputStream outputStream = new FileOutputStream("\"D:\\FTA_Project\\Output\\Testoutput.xlsx\"")) {
		            workbook.write(outputStream);
		        
		        }
		    }   	
	}



