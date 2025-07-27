package com.qa.opencart.Tests;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.appConstant.AppConstants;
import Basetest.BaseTestClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Feature("F 50: Open Cart - Login Feature")
@Epic("Epic 100: design pages for open cart application")
@Story("US 101: implement login page for open cart application")
public class LoginpageTest extends BaseTestClass {
	@Description("checking open cart login page title...")
	@Severity(SeverityLevel.MINOR)
	@Owner("Naveen")
	@Test(priority=1)
	public void loginPageTitleTest() {
		String actTitle = loginpage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE);
	}
	@Description("checking open cart login page url...")
	@Severity(SeverityLevel.NORMAL)
	@Owner("Naveen")
	@Test(priority=2)
	public void loginPageURLTest() {
		String actURL = loginpage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.Login_PAGE_FRACTION_URL));
	}
	@Description("checking open cart login page has forgot pwd link...")
	@Severity(SeverityLevel.CRITICAL)
	@Owner("Naveen")
	@Test(priority=3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginpage.isForgotPasswordLinkExist());
	}
	@Description("check user is able to login with valid user credentials...")
	@Severity(SeverityLevel.BLOCKER)
	@Owner("Naveen")
	@Test(priority=4)
	public void doLoginTest() {
		accntpage=loginpage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertEquals(accntpage.getAccountsPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);		
	}
}
