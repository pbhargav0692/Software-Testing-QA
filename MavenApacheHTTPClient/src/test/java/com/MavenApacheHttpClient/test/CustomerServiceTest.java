package com.MavenApacheHttpClient.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class CustomerServiceTest {
	public static void main(String[] args) throws IOException, IOException {
		String url = "http://www.thomas-bayer.com/sqlrest/CUSTOMER/13";
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet requestMsg = new HttpGet(url);
		HttpResponse responseMsg = client.execute(requestMsg);

		// status code
		// status msg
		// actual msg
		// data

		int status_code = responseMsg.getStatusLine().getStatusCode();
		System.out.println(status_code);
		String status_msg = responseMsg.getStatusLine().getReasonPhrase();
		System.out.println(status_msg);

		// Code for getting the message(DATA)
		BufferedReader rd = new BufferedReader(new InputStreamReader(responseMsg.getEntity().getContent()));

		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line + "\n");
		}
		System.out.println(result.toString());
	}
}
