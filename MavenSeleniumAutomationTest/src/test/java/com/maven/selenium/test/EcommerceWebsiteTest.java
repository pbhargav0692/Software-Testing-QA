package com.maven.selenium.test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class EcommerceWebsiteTest implements EcommerceConstant {

	public static void main(String[] args) throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(WEBPAGE_URL);
		driver.findElement(By.id(EMAIL_LOCATOR)).sendKeys(EMAIL_DATA);
		driver.findElement(By.id(PASSWORD_LOCATOR)).sendKeys(LOGIN_PASSWORD_DATA);
		driver.findElement(By.linkText(LOGIN_LOCATOR)).click();
		Thread.sleep(1000);
		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
		driver.close();
	}

}
