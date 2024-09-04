package com.selenium.fta.Logout_User;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.fta.utility_class.Utilityclass;

public class logout 
{
	@FindBy(xpath="/html/body/div[4]/div[1]/div[1]/div[2]/div[1]/ul/li[2]/a")
	static private WebElement logout_btn;

	public void Logout()
	{
		PageFactory.initElements(Utilityclass.driver, logout.class);
		Utilityclass.clickmethod(logout_btn);
	}
}
