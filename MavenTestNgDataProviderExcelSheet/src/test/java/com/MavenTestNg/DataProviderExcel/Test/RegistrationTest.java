package com.MavenTestNg.DataProviderExcel.Test;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class RegistrationTest extends BaseTest implements EcommerceConstant{
  @DataProvider(name = "successIds")
  public Object[][] SuccessIDS(){
	  Object[][] a = getTableArray("Book1.xls", "UnitTesting","Ecomm_Success_Ids");
	  return (a); 
  }
  @Test(dataProvider = "successIds")
  public void SignUpTest(String EmailId, String pwd) {
	    WebElement AccountElm = driver.findElement(By.linkText(ACCOUNT_LOCATOR));
	    AccountElm.click();
		WebElement SignUpElm = driver.findElement(By.xpath(SIGNUP_LOCATOR));
		SignUpElm.click();
		WebElement GenderElm = driver.findElement(By.xpath(GENDER_LOCATOR));
		GenderElm.click();
		WebElement FirstNameElm = driver.findElement(By.id(FIRSTNAME_LOCATOR));
		FirstNameElm.sendKeys(FIRSTNAME_DATA);
		WebElement LastNameElm = driver.findElement(By.id(LASTNAME_LOCATOR));
		LastNameElm.sendKeys(LASTNAME_DATA);
		WebElement BirthDateElm = driver.findElement(By.id(BIRTHDATE_LOCATOR));
		BirthDateElm.sendKeys(BIRTHDATE_DATA);
		WebElement BirthMonthElm = driver.findElement(By.id(BIRTHMONTH_LOCATOR));
		BirthMonthElm.sendKeys(BIRTHMONTH_DATA);
		WebElement BirthYearElm = driver.findElement(By.id(BIRTHYEAR_LOCATOR));
		BirthYearElm.sendKeys(BIRTHYEAR_DATA);
		WebElement EmailElm = driver.findElement(By.id(EMAIL_LOCATOR));
		EmailElm.sendKeys(EmailId);
		WebElement HouseNoElm = driver.findElement(By.id(HOUSENUMBER_LOCATOR));
		HouseNoElm.sendKeys(HOUSENUMBER_DATA);
		WebElement StreetAddElm = driver.findElement(By.id(STREETADD_LOCATOR));
		StreetAddElm.sendKeys(STREETADD_DATA);
		WebElement CityElm = driver.findElement(By.id(CITY_LOCATOR));
		CityElm.sendKeys(CITY_DATA);
		WebElement StateElm = driver.findElement(By.id(STATE_LOCATOR));
		StateElm.sendKeys(STATE_DATA);
		WebElement CountryElm = driver.findElement(By.id(COUNTRY_LOCATOR));
		CountryElm.sendKeys(COUNTRY_DATA);
		WebElement PostcodeElm = driver.findElement(By.id(POSTCODE_LOCATOR));
		PostcodeElm.sendKeys(POSTCODE_DATA);
		WebElement PhoneElm = driver.findElement(By.id(PHONE_LOCATOR));
		PhoneElm.sendKeys(PHONE_DATA);
		WebElement PasswordElm = driver.findElement(By.id(PASSWORD_LOCATOR));
		PasswordElm.sendKeys(pwd);
		WebElement ConfirmPasswordElm = driver.findElement(By.id(CONFIRMPASSWORD_LOCATOR));
		ConfirmPasswordElm.sendKeys(pwd);
		WebElement NewsLetterElm = driver.findElement(By.id(NEWSLETTER_LOCATOR));
		NewsLetterElm.click();
		WebElement TermsElm = driver.findElement(By.id(TERMS_LOCATOR));
		TermsElm.click();
		WebElement SubmitElm = driver.findElement(By.name(SUBMIT_LOCATOR));
		SubmitElm.click();
  }
	// get directly from the site
	public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) {
		String[][] tabArray = null;
		try {
			Workbook workbook = Workbook.getWorkbook(new File(xlFilePath));
			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1, startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();
			System.out.println("startRow=" + startRow + ", endRow=" + endRow + ", " + "startCol=" + startCol
					+ ", endCol=" + endCol);
			tabArray = new String[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (Exception e) {
			System.out.println("error in getTableArray()");
		}
		return (tabArray);
	}

}
