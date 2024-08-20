package com.selenium.fta.signup;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.fta.utility.Utilityclass;


public class Signup_User 
{
	@FindBy(xpath ="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[1]/a\r\n")
	static private WebElement signup_btn;
	
	@FindBy(id="gender-male")
	static private WebElement Gender;
	
	@FindBy(id="FirstName")
	static private WebElement first_name;
	
	@FindBy(id="LastName")
	static private WebElement last_name;
	
	@FindBy(id="Email")
	static private WebElement Email_id;
	
	@FindBy(id="Password")
	static private WebElement password_In;
	
	@FindBy(id="ConfirmPassword")
	static private WebElement confirm_Password;
	
	@FindBy(id="register-button")
	static private WebElement register_btn;
	
	@FindBy(id ="btnSignUpSubmit-content")
	static private WebElement submt_btn;
	
	@FindBy(id ="/html/body/div[4]/div[1]/div[4]/div[2]/form/div/div[2]/div[1]/div/ul/li\r\n")
	static private WebElement Varify_msg;

public void signupuser()
{
	    PageFactory.initElements(Utilityclass.driver, Signup_User.class);
 	    Utilityclass.clickmethod(signup_btn);
 	    Utilityclass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
 	    Utilityclass.clickmethod(Gender);
 	    Utilityclass.inputmethod(first_name,"Lalit");
		Utilityclass.inputmethod(last_name,"Kumar");
		//Utilityclass.inputmethod(Email_id,"testing@gmail.com");
		Utilityclass.inputmethod(Email_id,"lalit.kumar@inveniolsi.com");
		//String EmailID = Utilityclass.driver.findElement(By.id("Email")).getAttribute("value");
		Utilityclass.inputmethod(password_In,"Welcome@123");
		Utilityclass.inputmethod(confirm_Password,"Welcome@123");
		Utilityclass.clickmethod(register_btn);
	}
}
	
