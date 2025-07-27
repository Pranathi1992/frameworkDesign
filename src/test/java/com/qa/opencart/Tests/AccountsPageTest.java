package com.qa.opencart.Tests;

import java.util.List;


import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.appConstant.appConstants;
import com.qa.opencart.pages.ResultsPage;

import Basetest.BaseTestClass;
import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Feature("F 60: Open Cart - Login Feature")
@Epic("Epic 200: design pages for open cart application")
@Story("US 201: implement Accounts page for open cart application")

public class AccountsPageTest extends BaseTestClass{
	@BeforeClass
	public void accSetup() {
		accntpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Description("checking open cart Acc page title...")
	@Severity(SeverityLevel.MINOR)
	@Owner("pranathi")
	@Test(priority=1)
	public void accPageTitleTest() {
		String actTitle = accntpage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, appConstants.ACCOUNTS_PAGE_TITLE);
	}
	@Description("checking logout link existance ...")
	@Severity(SeverityLevel.MINOR)
	@Owner("pranathi")
	@Test(priority=2)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accntpage.isLogoutLinkExist());
	}
	@Description("checking open cart acc page headers...")
	@Severity(SeverityLevel.MINOR)
	@Owner("pranathi")
	@Test(priority=3)
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accntpage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, appConstants.ACTUAL_ACCOUNTS_PAGE_HEADER_LIST);
	}
	@DataProvider
	public Object[][] getsearchKey(){
		return new Object[][]{{"macbook",3},{"imac",1},{"samsung",2}};
	}
	@Test(priority=4, dataProvider="getsearchKey")
	public void SearchCountTest(String searchKey, int SearchCount ) {
		resultspage =accntpage.doSearch(searchKey);
		Assert.assertEquals(resultspage.getSearchResultsCount(), SearchCount);	
	}
	@DataProvider
	public Object[][] getSearchData(){
		return new Object[][] {{"macbook","MacBook Pro"},{"macbook","MacBook Air"},{"imac","iMac"},
			{"samsung","Samsung SyncMaster 941BW"}};
	}
	@Test(priority=5, dataProvider="getSearchData")
	public void searchTest(String searchKey,String productName ) {
		resultspage =accntpage.doSearch(searchKey);
		productinfopage =resultspage.selectProduct(productName);
		Assert.assertEquals(productinfopage.getProductHeader(),productName);
		}
	
}
