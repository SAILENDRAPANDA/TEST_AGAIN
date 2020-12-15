package com.crm.qa.test;


import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.crm.qa.base.Base;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends Base  {
 LoginPage log;
 HomePage hom;
  public LoginPageTest() {
	 super();
}
 
	
	@BeforeClass
	public  void setUp() {
				initialize();
		log=new  LoginPage();
	}
	
	@Test
	public void currentUrlTest() {
		String ttlTest=log.verifyTittle();
		Assert.assertEquals(ttlTest, "Facebook – log in or sign up");
	}
	
	@Test
	public void imageTest() {
		boolean flag=log.logoPresent();
		Assert.assertTrue(flag, "ok");
	}
	
	@Test 
	public void loginTest() throws InterruptedException {
		hom=log.login(prop.getProperty("username"),prop.getProperty("password"));
	Thread.sleep(10000);
	}

@AfterClass
public void tearDown() {
	driver.close();
}

}


