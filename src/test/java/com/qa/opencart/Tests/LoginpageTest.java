package com.qa.opencart.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.appConstant.AppConstants;
import Basetest.BaseTestClass;
public class LoginpageTest extends BaseTestClass {
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.Login_PAGE_FRACTION_URL));
	}
	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPasswordLinkExist());
	}
	@Test(priority=4)
	public void doLoginTest() {
		 accPage=loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accPage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);		
	}
}
