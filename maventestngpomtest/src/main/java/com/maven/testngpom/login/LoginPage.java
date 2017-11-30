package com.maven.testngpom.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver = null;
	
	@FindBy(id = loginConstant.EMAIL_LOCATOR)
	private WebElement emailElm;
	
	@FindBy(id = loginConstant.PASSWORD_LOCATOR)
	private WebElement passwordElm;
	
	@FindBy(linkText = loginConstant.LOGIN_LOCATOR)
	private WebElement signonLinkElm;
	
	public LoginPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	private void SetEmail(String Email){
		emailElm.sendKeys(Email);
	}
	
	private void SetPassword(String Password){
		passwordElm.sendKeys(Password);
	}
		
	public void LoginClick(){
		signonLinkElm.click();
	}
	
	public void EcommerceWebsiteLogin(String EmailId, String Password){
		SetEmail(EmailId);
		SetPassword(Password);
		LoginClick();
	}
}
