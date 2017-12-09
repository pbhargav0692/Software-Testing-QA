package com.service.customer.core;

import org.testng.Assert;

public class CommonServiceValidator implements CommonServiceConstant {
	public static void PerformCommonValidations(int statuscode, String ResultMsg) {
		Assert.assertEquals(statuscode, STATUS_CODE_200);
		Assert.assertFalse(ResultMsg.contains(STATUS_MSG_OK));
	}
	
	public static void PerformCommonValidationPost(int statuscode, String ResultMsg) {
		// Perform Common Validation
		Assert.assertEquals(statuscode, STATUS_CODE_201);
		Assert.assertFalse(ResultMsg.contains(STATUS_MSG_CREATED));
	}
}
