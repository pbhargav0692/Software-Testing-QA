package com.MavenTestNg.DataProviderExcel.Test;

import java.io.File;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class EcommerceCategories extends BaseTest implements EcommerceConstant {
	/*
	 * @Test public void EcommerceCategoryTest() throws Exception {
	 * Driver.findElement(By.linkText(CATEGORY_LOCATOR)).click();
	 * Thread.sleep(3000); String ExpUrl =
	 * "http://ecommerce.saipratap.net/catlist.php";
	 * Assert.assertEquals(Driver.getCurrentUrl(), ExpUrl); }
	 */
	@DataProvider(name = "successIds")
	public Object[][] successIDS() {
		Object[][] a = getTableArray("Book1.xls", "UnitTesting", "Ecomm_Success_Ids");
		return (a);
	}

	@Test
	public void EcommereceCategorieslistTest() throws Exception {
		driver.findElement(By.linkText(CATEGORY_LOCATOR)).click();
		driver.findElement(By.xpath(CATEGORY_CLICKTOCONTINUE_LOCATOR)).click();
		driver.findElement(By.xpath(CATEGORY_CONTINUE_LOCATOR)).click();
		Thread.sleep(3000);
		String ExpUrl = "http://ecommerce.saipratap.net/products.php";
		if (ExpUrl.equals(driver.getCurrentUrl())) {
			System.out.println("There are items to buy");
		} else {
			System.out.println("There are no items available, please try again later");
		}
		// Assert.assertEquals(Driver.getCurrentUrl(), ExpUrl);
	}

	@Test(dataProvider = "successIds")
	public void EcommerceCartAddRemoveTest(String EmailId, String Pwd) throws Exception {

		// Adding the item to the cart
		driver.findElement(By.linkText(ACCOUNT_LOCATOR)).click();
		driver.findElement(By.id(EMAIL_LOCATOR)).sendKeys(EmailId);
		driver.findElement(By.id(PASSWORD_LOCATOR)).sendKeys(Pwd);
		driver.findElement(By.linkText(LOGIN_LOCATOR)).click();
		driver.findElement(By.linkText(PRODUCTS_LOCATOR)).click();
		System.out.println("Choose your favurite Product");
		driver.findElement(By.xpath(PRODUCT_LOCATOR)).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath(PRDUCT_DESCRIPTION_LOCATOR)).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText(MY_CART_LOCATOR)).click();
		boolean test = true;
		if (driver.findElement(By.xpath(CART_DATA_LOCATOR)) != null) {
			System.out.println("The product has been added successfully");
		} else {
			System.out.println("The product has not been added yet!");
			test = false;
		}
		Assert.assertEquals(test, true);

		// Removing the product from the cart
		driver.findElement(By.linkText(MY_CART_LOCATOR)).click();
		driver.findElement(By.xpath(CART_ITEM_DELETE_LOCATOR)).click();
		Alert alert = driver.switchTo().alert(); // Get a handle to the open
													// alert, prompt or
													// confirmation
		Thread.sleep(1000);
		alert.getText(); // Get the text of the alert or prompt
		Thread.sleep(1000);
		alert.accept(); // And acknowledge the alert (equivalent to clicking
						// "OK")
		Thread.sleep(1000);
		System.out.println("Your product has been removed successfully");
		/*
		 * String ExpUrl =
		 * "http://ecommerce.saipratap.net/cart.php?a=3&intid=5163";
		 * if(ExpUrl.equals(Driver.getCurrentUrl())){ System.out.
		 * println("The product has been removed successfully from the list");
		 * }else{ System.out.println("You still have product to buy"); }
		 */
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
