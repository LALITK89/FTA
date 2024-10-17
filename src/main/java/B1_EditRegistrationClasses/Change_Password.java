package B1_EditRegistrationClasses;

import java.io.IOException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import A_CommonUtilityClasses.TestData;
import A_CommonUtilityClasses.Utilityclass;

public class Change_Password
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	static private WebElement Login_link;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[4]/span/a")
	static private WebElement forgot_link;
	
	@FindBy(id = "Email")
	static private WebElement forgot_email;
	
	@FindBy(name = "send-email")
	static private WebElement Recovery_btn;
	
	@FindBy(xpath = "/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div")
	static private WebElement success_msg;
	
	
   public static void changePassword() throws IOException, InterruptedException
    {
	 
	 String TCID = "TC001";
	 TestData.getactualScenarioData(TCID);  
	 PageFactory.initElements(Utilityclass.driver,Change_Password.class );
	 Utilityclass.clickMethod(Login_link);
	 Utilityclass.clickMethod(forgot_link);
	 Utilityclass.mouseHover(Login_link);
	 Utilityclass.inputMethod(forgot_email, TestData.TDMap.get("User_Login_UserName_ED"));
	 Utilityclass.clickMethod(Recovery_btn);
	 String actual_message = success_msg.getText();
	 String Expected_message = "Email with instructions has been sent to you.";  
	   if(actual_message == Expected_message)
	   {
		System.out.println("Email Has been sent to Your mail ID."); 
	   }
	   else
	   {
		 System.out.println("Please enter the correct registerd mail id");
	  }
	 
    }
}
