package com.test.AutomationFramework;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;

public class AddingItemtocart extends Setup {
	
	@Test(priority=0)
	public void Hovering() throws InterruptedException {
		WebElement women = driver.findElement(By.xpath("//a[text()='Women']"));
		Actions act = new Actions(driver);
		act.moveToElement(women).perform(); // Hovering to Women
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("CasulaDress"))).click(); // Click on Casual dresses

		Thread.sleep(3000);

		WebElement instock = driver.findElement(By.xpath(prop.getProperty("Instock")));
		act.moveToElement(instock).perform(); // Hovering to In stock
		driver.findElement(By.xpath(prop.getProperty("Quickview"))).click();
		Thread.sleep(3000);
		driver.switchTo().frame(0); // Inside in to the frame
		Thread.sleep(3000);
		for (int i = 0; i <= 1; i++) {
			driver.findElement(By.xpath(prop.getProperty("icon-plus"))).click();
		}
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Addtocart"))).click();
		Thread.sleep(4000);
		String ExpectedValue = driver.findElement(By.xpath(prop.getProperty("Totalvalue"))).getText(); // Sometimes it
																											// shows
																											// error
		//System.out.println(Value);

		driver.findElement(By.xpath(prop.getProperty("Proceedtocheckout"))).click();
		Thread.sleep(3000);
		String ActualVal = driver.findElement(By.xpath(prop.getProperty("total_price"))).getText();
		Thread.sleep(3000);

		/*
		 * if (Value.equals(Val)) { System.out.println("Values are equal"); } else {
		 * System.out.println("Values are not  equal"); }
		 */
		
		Assert.assertEquals(ExpectedValue, ActualVal);

		driver.findElement(By.xpath(prop.getProperty("Checkout"))).click();
		
	}

	@Test(priority=1)
	public void login() throws InterruptedException {
		driver.findElement(By.xpath(prop.getProperty("email"))).sendKeys(prop.getProperty("Email")); // how to get from
																							// config file
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(prop.getProperty("Password"));
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Submitlogin"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("checkout"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("checkbox"))).click();
		driver.findElement(By.xpath(prop.getProperty("submit"))).click();
		Thread.sleep(3000);

	}

	@Test(priority=3)
	public void confirmOrder() throws InterruptedException {
		Thread.sleep(3000);
		//String Value1= driver.findElement(By.xpath("//span[@id='total_price']")).getText();
		driver.findElement(By.xpath(prop.getProperty("Paybybank"))).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Submit_login"))).click();
		Thread.sleep(3000);
		// doubt in finding xpath of " You order on mY store text
		String Text = driver.findElement(By.xpath(prop.getProperty("Text"))).getText();
		System.out.println(Text);

	}
	
	@Test(priority=4)
	public void contactDetails() throws InterruptedException
	{
		driver.findElement(By.xpath(prop.getProperty("Contact"))).click();
		WebElement Seldrop =driver.findElement(By.id(prop.getProperty("id")));
		Select sel = new Select(Seldrop);
		sel.selectByVisibleText("Customer service");
		WebElement Seldrop1 = driver.findElement(By.name(prop.getProperty("order")));
		Select sel1 = new Select(Seldrop1);
		sel1.selectByIndex(1);
		Thread.sleep(3000);
		WebElement seldrop2 = driver.findElement(By.name(prop.getProperty("product")));
		Select sel2 = new Select(Seldrop1);
		sel2.selectByIndex(1);
		driver.findElement(By.xpath(prop.getProperty("message"))).sendKeys("Hello");
		Thread.sleep(3000);
		driver.findElement(By.xpath(prop.getProperty("Send"))).click();
	}

}
