package com.qa.opencart.Tests;



import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Basetest.BaseTestClass;

public class userRegisterTest extends BaseTestClass{
	@BeforeClass
	public void regsetup() {
		registerpage=loginpage.navigateToRegisterpage();
	}
	@Test
	public String getRandomEmail() {
		return "uiAutomation"+System.currentTimeMillis()+"@open.com";
	}
	@Test
	public void RegisterTest(){
		Assert.assertTrue(registerpage.userRegisteration("sai", "pranathi", getRandomEmail(), "987654321", "saibaba@1", "yes"));
	}
	
	
}
