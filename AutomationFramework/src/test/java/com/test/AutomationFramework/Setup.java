package com.test.AutomationFramework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Setup {

	WebDriver driver;
	Properties prop;
	
	@BeforeClass
	public void initalization() throws IOException
	{
		
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\Properties\\config.properties");
		prop = new Properties();
		prop.load(fis);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
		driver = new ChromeDriver(); //runtime polymorhism
		
		//	WebDriver driver = new FirefoxDriver();
			driver.get(prop.getProperty("URL"));
			driver.manage().window().maximize();
			
			System.out.println(driver.getTitle());
	}
	
	
	
//	@AfterClass
	public void cleanUp()
	{
		driver.close();
	}

}
