package com.qa.opencart.Tests;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.pages.LoginPage;

import Basetest.BaseTestClass;

public class ProductInfoPageTest  extends BaseTestClass {
	@BeforeClass
	public void productinfoSetup() {
		accntpage=loginpage.doLogin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	public void productHeaderTest() {
		resultspage=accntpage.doSearch("macbook");
		productinfopage=resultspage.selectProduct("MacBook Pro");
		Assert.assertEquals(productinfopage.getProductHeader(), "MacBook Pro");
	}
	@Test
	public void productInfoTest() {
		resultspage=accntpage.doSearch("macbook");
		productinfopage=resultspage.selectProduct("MacBook Pro");
		Map<String, String> actproductdata=productinfopage.getproductData();
		Assert.assertEquals(actproductdata.get("Brand"),"Apple");
		Assert.assertEquals(actproductdata.get("Product Code"),"Product 18	");
		Assert.assertEquals(actproductdata.get("Reward Points"),"800");
		Assert.assertEquals(actproductdata.get("Availability"),"Out Of Stock");
		//softAssert.assertEquals(actproductdata.get("productprice"),"$2,000.00");
		//softAssert.assertEquals(actproductdata.get("extraprice"),"$2,000.00");
		//softAssert.assertAll();
	}
	

}
