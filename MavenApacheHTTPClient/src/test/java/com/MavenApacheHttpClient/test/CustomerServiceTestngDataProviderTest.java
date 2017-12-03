package com.MavenApacheHttpClient.test;

import java.io.File;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class CustomerServiceTestngDataProviderTest extends BaseTest {

	@DataProvider(name = "SuccessID")
	public Object[][] successIDs() {
		
		 Object[][] a = getTableArray("Book1.xls", "getTesting", "UserData");
		 return (a);
		 
		/*String[][] Ids = { {"Laura" }, {"Bhargav" } };
		return (Ids);*/
	}

	// everything is good
	@Test(dataProvider = "SuccessID")
	public void testGetCustomerwith200(String FIRSTNAME) throws Exception {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/8888";
		HttpResponse response = HttpRequestResponseCode(url);
		int statuscode = HttpStatusCodeResponseMsg(response);
		String ResultMsg = DataReadCode(response);

		Assert.assertTrue(ResultMsg.contains(FIRSTNAME));
		// Assert.assertTrue(ResultMsg.contains(LASTNAME));
		// Assert.assertTrue(ResultMsg.contains("<STREET>381 Upland
		// Pl.</STREET>"));
		// Assert.assertTrue(ResultMsg.contains("<CITY>Palo Alto</CITY>"));
		// Assert.assertTrue(ResultMsg.contains("<ID>12</ID>"));
		Assert.assertEquals(statuscode, 200);
	}

	@Test
	public void testPostCustomerwith200() throws Exception {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER";
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost requestMsg = new HttpPost(url);
		String line = "<CUSTOMER xmlns:xlink=\"http://www.w3.org/1999/xlink\">"
				+ " <ID>8888</ID> <FIRSTNAME>Bhargav</FIRSTNAME> <LASTNAME>Patel</LASTNAME> <STREET>3939 Monroe Ave</STREET> <CITY>Fremont</CITY> </CUSTOMER>";
		StringEntity entity = new StringEntity(line);
		requestMsg.setEntity(entity);
		HttpResponse response = client.execute(requestMsg);
		int statuscode = HttpStatusCodeResponseMsg(response);
	}

	// Wrong Entry Error (No resource Found)
	@Test
	public void testGetCustomerwith404() throws Exception {

		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/205";
		HttpResponse response = HttpRequestResponseCode(url);
		int statuscode = HttpStatusCodeResponseMsg(response);
		String ResultMsg = DataReadCode(response);

		Assert.assertTrue(ResultMsg.contains("<u>Resource not found</u>"));
		Assert.assertTrue(ResultMsg.contains("<u>The requested resource is not available.</u>"));
		Assert.assertTrue(ResultMsg.contains("<u>Resource not found</u>"));
	}

	// Internal Server Error
	@Test
	public void testGetCustomerwith500() throws Exception {

		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMEr/205";
		HttpResponse response = HttpRequestResponseCode(url);
		int statuscode = HttpStatusCodeResponseMsg(response);
		String ResultMsg = DataReadCode(response);

		Assert.assertEquals(statuscode, 500);
		// Assert.assertTrue(ResultMsg.contains("Internal Server Error"));
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
