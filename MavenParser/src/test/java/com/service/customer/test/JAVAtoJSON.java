
package com.service.customer.test;

import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.service.customer.entity.Staff;

public class JAVAtoJSON {
	public static void main(String[] args) {
		Staff staff = createDummyObject();

		// Convert java object to JSON string
		Gson gson = new Gson();
		String json = gson.toJson(staff);
		System.out.println(json);

		// Convert object to json string and save into the file directory
		try (FileWriter writer = new FileWriter("D:\Volume D\Apex Consulting\classes\Software Testing\Projects\WorkSpaces1010\MavenParser\staff.json")) {
			gson.toJson(staff, writer);
			//Java Object to JSON, and assign to a String 
			//String jsonInString = gson.toJson(staff);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static Staff createDummyObject() {

		Staff staff = new Staff();
		staff.setName("mkyong");
		staff.setAge(35);
		staff.setPosition("Founder");
		staff.setSalary(new BigDecimal("10000"));

		List<String> skills = new ArrayList<>();
		skills.add("java");
		skills.add("python");
		skills.add("shell");

		staff.setSkills(skills);

		return staff;

	}
}
