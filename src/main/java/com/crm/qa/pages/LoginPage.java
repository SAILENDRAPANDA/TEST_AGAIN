package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class LoginPage extends Base {
//Page Factory ;; OR
	@FindBy(name="email")
	WebElement username;
	
	@FindBy(name="pass")
	WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement logbtn;
	
	@FindBy(xpath="//img[@class='fb_logo _8ilh img']")
	WebElement logo;
	 //initialize object
	public  LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTittle() {
		String title=driver.getTitle();
		return  title;
	}
	public boolean logoPresent() {
		boolean b=logo.isDisplayed();
	return b;
	}
	public HomePage login(String id , String psd) {
		username.sendKeys(id);
		password.sendKeys(psd);
		logbtn.click();
		
		return new HomePage();
	}
}
