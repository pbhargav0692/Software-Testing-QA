package com.MavenLog4j.test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import junit.framework.Assert;

public class log4jTest implements EcommerceConstant {

	static Logger Log = LogManager.getLogger(log4jTest.class.getName());

	public static void main(String[] args) throws Exception {

		DOMConfigurator.configure("log4j.xml");

		WebDriver driver = new FirefoxDriver();
		Log.info("New Driver Initialized");

		driver.manage().window().maximize();
		Log.info("maximized windows");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get(WEBPAGE_URL);
		Log.info("Got the webpage");

		driver.findElement(By.id(EMAIL_LOCATOR)).sendKeys(EMAIL_DATA);
		Log.info("already inserted email id");

		driver.findElement(By.id(PASSWORD_LOCATOR)).sendKeys(LOGIN_PASSWORD_DATA);
		Log.info("already inserted password");

		driver.findElement(By.linkText(LOGIN_LOCATOR)).click();
		Log.info("Clicked on login");
		Thread.sleep(1000);

		Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
		Log.info("Matched the actual and expected page title");

		driver.close();
		Log.info("closed browser");
	}
}
