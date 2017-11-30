package com.maven.testngpom.registration;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.maven.testngpom.core.BaseTest;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class RegistrationTest extends BaseTest implements RegistrationConstant {
	@DataProvider(name = "SuccessIds")
	public Object[][] successIDs() {
		Object[][] a = getTableArray("SignUpData.xls", "UnitTesting", "Ecomm_SignUp_Ids");
		return (a);
	}

	@Test(dataProvider = "SuccessIds")
	public void testRegistrationsuccessful(String firstname, String Lastname, String DateofBirth, String DateofMonth,
			String DateofYear, String Houseno, String Streetadd, String Town, String County, String Country,
			String Postcode, String Telno, String Password, String ConfirmPassword) {
		// Create a page
		RegistrationPage signuppage = new RegistrationPage(driver);
		// call the action
		signuppage.SignUpToEcommerceWebSite(firstname, Lastname, DateofBirth, DateofMonth, DateofYear, Houseno,
				Streetadd, Town, County, Country, Postcode, Telno, Password, ConfirmPassword);
		// validate
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
