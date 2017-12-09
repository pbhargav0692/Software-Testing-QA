package com.service.customer.test;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.service.customer.entity.Staff;

public class JSONtoJAVA {
	public static void main(String[] args) throws IOException, IOException {
		Gson gson = new Gson();
		try (Reader reader = new FileReader("D:\\staff.json")) {

			// convert JSON to java object
			Staff staff = gson.fromJson(reader, Staff.class);
			System.out.println(staff);

			// Convert JSON to JSON element and then to String
			/*JsonElement json = gson.fromJson(reader, JsonElement.class);
			String jsonInString = gson.toJson(json);
			System.out.println(jsonInString);*/

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
