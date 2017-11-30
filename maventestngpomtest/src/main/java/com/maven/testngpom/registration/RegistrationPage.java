package com.maven.testngpom.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {
	private WebDriver Driver = null;

	@FindBy(linkText = RegistrationConstant.ACCOUNT_LOCATOR)
	private WebElement AccountElm;

	@FindBy(xpath = RegistrationConstant.SIGNUP_LOCATOR)
	private WebElement SignUpElm;

	// finding the element and filling up the registration form
	@FindBy(xpath = RegistrationConstant.GENDER_LOCATOR)
	private WebElement GenderElm;

	@FindBy(id = RegistrationConstant.FIRSTNAME_LOCATOR)
	private WebElement FirstNameElm;

	@FindBy(id = RegistrationConstant.LASTNAME_LOCATOR)
	private WebElement LastNameElm;

	@FindBy(id = RegistrationConstant.BIRTHDATE_LOCATOR)
	private WebElement BirthDateElm;

	@FindBy(id = RegistrationConstant.BIRTHMONTH_LOCATOR)
	private WebElement BirthMonthElm;

	@FindBy(id = RegistrationConstant.BIRTHYEAR_LOCATOR)
	private WebElement BirthYearElm;

	@FindBy(id = RegistrationConstant.HOUSENUMBER_LOCATOR)
	private WebElement HouseNoElm;

	@FindBy(id = RegistrationConstant.STREETADD_LOCATOR)
	private WebElement Add1Elm;

	@FindBy(id = RegistrationConstant.CITY_LOCATOR)
	private WebElement CityElm;

	@FindBy(id = RegistrationConstant.STATE_LOCATOR)
	private WebElement StateElm;

	@FindBy(id = RegistrationConstant.COUNTRY_LOCATOR)
	private WebElement CountryElm;

	@FindBy(id = RegistrationConstant.POSTCODE_LOCATOR)
	private WebElement PostCodeElm;

	@FindBy(id = RegistrationConstant.PHONE_LOCATOR)
	private WebElement PhoneNoElm;

	@FindBy(id = RegistrationConstant.PASSWORD_LOCATOR)
	private WebElement PasswordElm;

	@FindBy(id = RegistrationConstant.CONFIRMPASSWORD_LOCATOR)
	private WebElement ConfirmPasswordElm;

	@FindBy(id = RegistrationConstant.NEWSLETTER_LOCATOR)
	private WebElement NewsletterElm;

	@FindBy(id = RegistrationConstant.TERMS_LOCATOR)
	private WebElement TermsElm;

	@FindBy(name = RegistrationConstant.SUBMIT_LOCATOR)
	private WebElement SubmitElm;

	public RegistrationPage(WebDriver Driver) {
		this.Driver = Driver;
		PageFactory.initElements(Driver, this);
	}

	public void SetAccount() {
		AccountElm.click();
	}

	private void SetSignUp() {
		SignUpElm.click();
	}

	private void SetGender() {
		GenderElm.click();
	}

	private void SetFirstName(String FirstName) {
		FirstNameElm.sendKeys(FirstName);
	}

	private void SetLastName(String LastName) {
		FirstNameElm.sendKeys(LastName);
	}

	private void SetBirthDate(String BirthDate) {
		BirthDateElm.sendKeys(BirthDate);
	}

	private void SetBirthMonth(String BirthMonth) {
		BirthMonthElm.sendKeys(BirthMonth);
	}

	private void SetBirthYear(String BirthYear) {
		BirthYearElm.sendKeys(BirthYear);
	}

	private void SetHouseNo(String HouseNo) {
		HouseNoElm.sendKeys(HouseNo);
	}

	private void SetAdd1(String add) {
		Add1Elm.sendKeys(add);
	}

	private void SetCity(String city) {
		CityElm.sendKeys(city);
	}

	private void SetState(String state) {
		StateElm.sendKeys(state);
	}

	private void SetCountry(String country) {
		CountryElm.sendKeys(country);
	}

	private void SetPostcode(String postcode) {
		PostCodeElm.sendKeys(postcode);
	}

	private void SetPhoneNo(String phoneno) {
		PhoneNoElm.sendKeys(phoneno);
	}

	private void SetPassword(String password) {
		PasswordElm.sendKeys(password);
	}

	private void Confirmpassord(String confirmpassword) {
		ConfirmPasswordElm.sendKeys(confirmpassword);
	}

	private void Newsletter() {
		NewsletterElm.click();
	}

	private void Terms() {
		TermsElm.click();
	}

	private void Submit() {
		SubmitElm.click();
	}

	public void SignUpToEcommerceWebSite(String Firstname, String Lastname, String Birthdate, String Birthmonth,
			String Birthyear, String houseno, String add, String City, String State, String Country, String Postcode,
			String Phoneno, String Password, String confirmPassword) {
		SetAccount();
		SetSignUp();
		SetGender();
		SetFirstName(Firstname);
		SetLastName(Lastname);
		SetBirthDate(Birthdate);
		SetBirthMonth(Birthmonth);
		SetBirthYear(Birthyear);
		SetHouseNo(houseno);
		SetAdd1(add);
		SetCity(City);
		SetState(State);
		SetCountry(Country);
		SetPostcode(Postcode);
		SetPhoneNo(Phoneno);
		SetPassword(Password);
		Confirmpassord(confirmPassword);
		Newsletter();
		Terms();
		Submit();
	}


}
