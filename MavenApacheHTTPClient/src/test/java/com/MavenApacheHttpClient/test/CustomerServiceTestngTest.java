package com.MavenApacheHttpClient.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerServiceTestngTest extends BaseTest {

	// everything is good
	@Test
	public void testGetCustomerwith200() throws Exception {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/12";
		HttpResponse response = HttpRequestResponseCode(url);
		int statuscode = HttpStatusCodeResponseMsg(response);
		String ResultMsg = DataReadCode(response);

		Assert.assertTrue(ResultMsg.contains("<FIRSTNAME>George</FIRSTNAME>"));
		Assert.assertTrue(ResultMsg.contains("<LASTNAME>Ott</LASTNAME>"));
		Assert.assertTrue(ResultMsg.contains("<STREET>381 Upland Pl.</STREET>"));
		Assert.assertTrue(ResultMsg.contains("<CITY>Palo Alto</CITY>"));
		Assert.assertTrue(ResultMsg.contains("<ID>12</ID>"));
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
}
