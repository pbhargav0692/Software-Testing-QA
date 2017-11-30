package com.Maven.TestNG.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class BaseTest {

	protected WebDriver driver = null;

	@BeforeTest
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://ecommerce.saipratap.net/customerlogin.php");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterTest
	public void cleanup() {
		driver.close();
	}
}
