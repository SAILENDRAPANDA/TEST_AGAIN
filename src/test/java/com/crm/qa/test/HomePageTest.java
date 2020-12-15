package com.crm.qa.test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.MessangerPage;
import com.crm.qa.pages.UserPage;

public class HomePageTest extends Base {

	LoginPage log;
	HomePage hom;
	MessangerPage messangerPage;
	UserPage userPage;
	public HomePageTest() {
		super();
	}
	
	@BeforeClass
	public void setUp() {
		initialize();
		log= new LoginPage();
		hom=log.login(prop.getProperty("username"),prop.getProperty("password"));
		
	}
	
	@Test(priority=1)
	public void tittleTest() throws InterruptedException {
Thread.sleep(2000);
	Assert.assertEquals(hom.verifytitle(), "Facebook");
	}
	
	@Test(priority=2)
	public void createPostTest() {
		Assert.assertTrue(hom.verifyCreatePost());
	}
	
	@Test(priority=4)
	public void userPageTest() throws InterruptedException {
		userPage=hom.userPage();
		Thread.sleep(3000);
	}
	
	@Test(priority=3)
	public void messengerPageTest() throws InterruptedException {
		messangerPage=hom.messengerPage();
		Thread.sleep(3000);
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
