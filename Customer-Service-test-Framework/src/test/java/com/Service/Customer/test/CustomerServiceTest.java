package com.Service.Customer.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Service.Customer.entity.Customer;
import com.service.customer.core.ApexHTTPclientUtils;
import com.service.customer.core.BaseTest;
import com.service.customer.core.CommonServiceValidator;
import com.service.customer.core.XMLParserUtil;

public class CustomerServiceTest extends BaseTest implements CustomerServiceConstant {

	/*@DataProvider(name = "SuccessID")
	public Object[][] successIDs() {

		Object[][] a = getTableArray("Book1.xls", "getTesting", "UserData");
		return (a);
	}
	/*
	 * String[][] Ids = { {"Laura" }, {"Bhargav" } }; return (Ids);
	 */
	// }

	// everything is good
	@Test(priority = 1)
	public void testGetCustomerwith200() throws Exception {
		// Prepare URL and test data
		String url = BASE_URL + 56;

		// Send and receive it
		HttpResponse response = ApexHTTPclientUtils.HttpRequestResponseCode(url);
		int statuscode = ApexHTTPclientUtils.HttpStatusCodeResponseMsg(response);
		String ResultMsg = ApexHTTPclientUtils.DataReadCode(response);
		Customer customer = XMLParserUtil.convertXmltoObject(ResultMsg);

		// Perform Specific Validations
		Assert.assertEquals(customer.getFirstname(), "Laura");

		// Perform Common Validation
		CommonServiceValidator.PerformCommonValidations(statuscode, ResultMsg);
	}

	@Test(priority = 2)
	public void testPostCustomerwith200() throws Exception {
		String url = BASE_URL;
		HttpClient client = HttpClientBuilder.create().build();
		HttpPost postRequest = new HttpPost(url);
		Customer customer = new Customer(8888, "Bhargav", "Patel", "3939 Monroe Ave", "Fremont");
		StringEntity entity = new StringEntity(XMLParserUtil.convertObjecttoXml(customer));
		postRequest.setEntity(entity);
		HttpResponse response = client.execute(postRequest);
		int statuscode = ApexHTTPclientUtils.HttpStatusCodeResponseMsg(response);
		String ResultMsg = ApexHTTPclientUtils.DataReadCode(response);

		CommonServiceValidator.PerformCommonValidationPost(statuscode, ResultMsg);
	}

	@Test(priority = 3)
	public void testDeleteCustomerwith200() throws Exception {
		String url = BASE_URL + 8888;
		HttpClient client = HttpClientBuilder.create().build();
		HttpDelete DeleteRequest = new HttpDelete(url);
		HttpResponse response = client.execute(DeleteRequest);
		int statuscode = ApexHTTPclientUtils.HttpStatusCodeResponseMsg(response);
		String ResultMsg = ApexHTTPclientUtils.DataReadCode(response);

		CommonServiceValidator.PerformCommonValidations(statuscode, ResultMsg);
	}

	/*public String[][] getTableArray(String xlFilePath, String sheetName, String tableName) {
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
	}*/

}
