package com.maven.testngpom.product;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.maven.testngpom.core.BaseTest;

import junit.framework.Assert;

public class ProductPage {

	private static final String ADDED_ITEM_LOCATOR = "html/body/table/tbody/tr[2]/td/table/tbody/tr/td[2]/table[1]/tbody/tr[3]/td/table/tbody/tr[2]/td[3]/img";

	private WebDriver driver = null;

	// CategoryProductListCheck
	@FindBy(linkText = ProductConstant.ACCOUNT_LOCATOR)
	private WebElement AccountElm;

	@FindBy(id = ProductConstant.EMAIL_ID_LOCATOR)
	private WebElement EmailIdElm;

	@FindBy(id = ProductConstant.PASSWORD_LOCATOR)
	private WebElement PasswordElm;

	@FindBy(linkText = ProductConstant.LOGIN_LOCATOR)
	private WebElement LoginElm;

	@FindBy(linkText = ProductConstant.CATEGORY_LOCATOR)
	private WebElement CategoryElm;

	@FindBy(xpath = ProductConstant.CATEGORY_CLICKTOCONTINUE_LOCATOR)
	private WebElement CategoryContinueElm;

	@FindBy(xpath = ProductConstant.CATEGORY_CONTINUE_LOCATOR)
	private WebElement ContinueElm;

	// EcommerceCartAddRemoveTest

	@FindBy(linkText = ProductConstant.PRODUCTS_LOCATOR)
	private WebElement ProductElm;

	@FindBy(xpath = ProductConstant.PRODUCT_LOCATOR)
	private WebElement ViewItemElm;

	@FindBy(xpath = ProductConstant.PRDUCT_DESCRIPTION_LOCATOR)
	private WebElement ProductDescriptionElm;

	@FindBy(linkText = ProductConstant.MY_CART_LOCATOR)
	private WebElement CartElm;

	// Removing the product from the cart
	@FindBy(xpath = ProductConstant.CART_ITEM_DELETE_LOCATOR)
	private WebElement CartItemDeleteElm;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// CategoryProductListCheck
	public void Account() {
		AccountElm.click();
	}

	public void Email(String email) {
		EmailIdElm.sendKeys(email);
	}

	public void Password(String password) {
		PasswordElm.sendKeys(password);
	}

	public void Login() {
		LoginElm.click();
	}

	public void Category() {
		CategoryElm.click();
	}

	public void CategoryContniue() {
		CategoryContinueElm.click();
	}

	// EcommerceCartAddTest
	public void Product() {
		ProductElm.click();
	}

	public void ViewItem() {
		ViewItemElm.click();
	}

	public void AddtoCart() {
		ProductDescriptionElm.click();
	}

	public void Cart() {
		CartElm.click();
	}

	// EcommerceCartRemoveTest
	public void ItemDelete() {
		CartItemDeleteElm.click();
	}

	// CategoryProductListCheck
	public void ListCheck() {
		String ExpUrl = "http://ecommerce.saipratap.net/products.php";
		if (ExpUrl.equals(driver.getCurrentUrl())) {
			System.out.println("There are items to buy");
		} else {
			System.out.println("There are no items available, please try again later");
		}
	}

	public void CategoryProductListCheck(String emailId, String password) throws Exception {
		Account();
		Email(emailId);
		Password(password);
		Login();
		Category();
		CategoryContniue();
		Thread.sleep(3000);
		ListCheck();
		Thread.sleep(3000);
	}

	// EcommerceCartAddTest

	public void ProductAddTest() {
		boolean test = true;
		if (driver.findElement(By.xpath(ADDED_ITEM_LOCATOR)) != null) {
			System.out.println("The product has been added successfully");
		} else {
			System.out.println("The product has not been added yet!");
			test = false;
		}
		Assert.assertEquals(test, true);
	}

	public void EcommerceCartAddTest(String emailId, String password) throws Exception {
		Account();
		Email(emailId);
		Password(password);
		Login();
		Product();
		System.out.println("Choose your favurite Product");
		ViewItem();
		Thread.sleep(3000);
		AddtoCart();
		Thread.sleep(3000);
		Cart();
		ProductAddTest();
	}

	// EcommerceCartAddTest
	public void EcommerceCartRemoveTest(String emailId, String password) throws Exception {
		Account();
		Email(emailId);
		Password(password);
		Login();
		Product();
		System.out.println("Choose your favurite Product");
		ViewItem();
		Thread.sleep(3000);
		AddtoCart();
		Thread.sleep(3000);
		Cart();
		ItemDelete();
		Alert alert = driver.switchTo().alert(); // Get a handle to the open alert, prompt or confirmation
		Thread.sleep(1000);
		alert.getText(); // Get the text of the alert or prompt
		Thread.sleep(1000);
		alert.accept(); // And acknowledge the alert (equivalent to clicking "OK")
		Thread.sleep(1000);
		System.out.println("Your product has been removed successfully");
	}


}
