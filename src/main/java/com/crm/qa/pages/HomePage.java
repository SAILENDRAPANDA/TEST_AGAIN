package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.Base;

public class HomePage extends Base {
	

	@FindBy(xpath="//div[contains(text(),'Bijay')]")
	WebElement userpage;
	
	@FindBy(xpath="//*[contains(text(),'Create post')]")
	WebElement createPost;
	
	@FindBy(xpath="//div[contains(text(),'Messenger')][1]")
	WebElement messengerPage;
	
	@FindBy(xpath="//a[contains(text(),'Home')]")
	WebElement homePage;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyCreatePost() {
		
		return createPost.isDisplayed();
	}
	
	public String verifytitle() {
		
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	
	public MessangerPage messengerPage() {
		messengerPage.click();
		homePage.click();
		return new MessangerPage();
	}
	public UserPage userPage() {
		userpage.click();
		return new UserPage();
	}
	
	
	
}
