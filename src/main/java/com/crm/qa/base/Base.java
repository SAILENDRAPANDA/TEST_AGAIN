package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.crm.qa.utils.TestUtil;

public class Base {
	public static WebDriver driver;
	public static Properties prop;
	
	public  Base() {
		try {
			prop = new Properties();
			FileInputStream fis=new FileInputStream("F:\\IDENEW\\PomProject\\src\\main\\java\\com\\crm\\qa\\properties\\config.properties");
			prop.load(fis);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public  void initialize() {
		String browserName =prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			 ChromeOptions opt=new ChromeOptions();
			 opt.addArguments("--disable-notifications");
			 System.setProperty("webdriver.chrome.driver","C:\\Users\\Public\\Documents\\selenium softy\\chromedriver_win32 (1)\\chromedriver.exe");   
		   	 driver=new ChromeDriver(opt);

		}
		 else if(browserName.equalsIgnoreCase("Firefox"))
		 {
			
				 System.setProperty("webdriver.gecko.driver","F:\\selenium softy\\geckodriver-v0.27.0-win64\\geckodriver.exe\\");   
	    			 driver=new FirefoxDriver();
		 }
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load,TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicity_wait,TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
	}


}
