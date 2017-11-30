package com.maven.testngpom.core;

//import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

	protected WebDriver driver = null;

	@BeforeMethod
	public void setup() {
		driver = new FirefoxDriver();
		driver.get("http://ecommerce.saipratap.net/customerlogin.php");
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void cleanup() {
		driver.close();
	}
}
