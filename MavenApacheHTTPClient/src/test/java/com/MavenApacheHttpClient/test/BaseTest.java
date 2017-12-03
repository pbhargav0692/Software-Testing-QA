package com.MavenApacheHttpClient.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class BaseTest {

	protected String DataReadCode(HttpResponse response) throws IOException {
		// Data
		BufferedReader rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		StringBuffer result = new StringBuffer();
		String line = "";
		while ((line = rd.readLine()) != null) {
			result.append(line + "\n");
		}

		String ResultMsg = result.toString();
		System.out.println(ResultMsg);
		return ResultMsg;
	}

	protected int HttpStatusCodeResponseMsg(HttpResponse response) {
		// Status code
		int statuscode = response.getStatusLine().getStatusCode();
		System.out.println(statuscode);

		// Status Message
		String statusmsg = response.getStatusLine().getReasonPhrase();
		System.out.println(statusmsg);
		return statuscode;
	}

	protected HttpResponse HttpRequestResponseCode(String url) throws IOException, ClientProtocolException {
		// Creating HTTP Client
		HttpClient client = HttpClientBuilder.create().build();

		// Sending HTTP request
		HttpGet RequestMsg = new HttpGet(url);

		// Getting XML response
		HttpResponse response = client.execute(RequestMsg);
		return response;
	}

}
