package com.maven.testngpom.login;

import java.io.File;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.maven.testngpom.core.BaseTest;

import junit.framework.Assert;
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class MavenTestNGDataproviderExcelTest extends BaseTest implements loginConstant {
	@DataProvider(name = "SuccessIds")
	public Object[][] successIDs() {
		Object[][] a = getTableArray("Book1.xls", "UnitTesting", "Ecomm_Success_Ids");
		return (a);
	}

	@Test(dataProvider = "SuccessIds")
	public void EcommLoginTest(String emailId, String pwd) {
		// Create a page
		LoginPage loginpage = new LoginPage(driver);
		// call the action
		loginpage.EcommerceWebsiteLogin(emailId, pwd);
		// validate
		Assert.assertEquals(PAGE_TITLE, driver.getTitle());
		Assert.assertEquals("http://ecommerce.saipratap.net/thankyoumessage.php?msg=login", driver.getCurrentUrl());
		Assert.assertEquals("You have Logged In successfully.", driver.findElement(By.className("fntstyle")).getText());
	}

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
