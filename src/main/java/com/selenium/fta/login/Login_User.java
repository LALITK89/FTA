package com.selenium.fta.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.fta.signup.Signup_User;
import com.selenium.fta.utility.Utilityclass;

public class Login_User 
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	static private WebElement Login_link;
	
	@FindBy(id="Email")
	static private WebElement Emial_In;
	
	@FindBy(id="Password")
	static private WebElement Password_In;
	
	@FindBy(id="RememberMe")
	static private WebElement Remeber_Chk;
	
	@FindBy(xpath="/html/body/div[4]/div[1]/div[4]/div[2]/div/div[2]/div[1]/div[2]/div[2]/form/div[5]/input")
	static private WebElement Login_btn;
	
	public void login()
     {
		Signup_User signup = new Signup_User();
		PageFactory.initElements(Utilityclass.driver, Login_User.class);
	    Utilityclass.clickmethod(Login_link);
        Utilityclass.inputmethod(Emial_In,"lalit.kumar@inveniolsi.com");
        Utilityclass.inputmethod(Password_In,"Lalit@123");
        Utilityclass.clickmethod(Remeber_Chk);
        Utilityclass.clickmethod(Login_btn);
    }
	
   }