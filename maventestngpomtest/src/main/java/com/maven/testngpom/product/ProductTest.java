package com.maven.testngpom.product;

import org.testng.annotations.Test;

import com.maven.testngpom.core.BaseTest;

public class ProductTest extends BaseTest implements ProductConstant {
	@Test
	public void ProductListCheckTest() throws Exception {
		ProductPage product = new ProductPage(driver);
		product.CategoryProductListCheck("test1@gmail.com", "pwd1");
	}

	@Test
	public void ProductItemAddTest() throws Exception {
		ProductPage product = new ProductPage(driver);
		product.EcommerceCartAddTest("test1@gmail.com", "pwd1");
	}

	@Test
	public void ProductRemoveTest() throws Exception {
		ProductPage product = new ProductPage(driver);
		product.EcommerceCartRemoveTest("test1@gmail.com", "pwd1");

	}
}
