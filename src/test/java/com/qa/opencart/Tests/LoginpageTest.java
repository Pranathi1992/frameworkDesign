package com.qa.opencart.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.appConstant.appConstants;
import Basetest.BaseTestClass;
public class LoginpageTest extends BaseTestClass {
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actTitle, appConstants.LOGIN_PAGE_TITLE);
	}
	@Test(priority=2)
	public void loginPageURLTest() {
		String actURL = loginpage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(appConstants.Login_PAGE_FRACTION_URL));
	}
	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());
	}
	@Test(priority=4)
	public void doLoginTest() {
		accntpage=loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accntpage.getAccountsPageTitle(), appConstants.ACCOUNTS_PAGE_TITLE);		
	}
}
