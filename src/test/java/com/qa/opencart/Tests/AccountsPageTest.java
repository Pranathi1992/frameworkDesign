package com.qa.opencart.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.appConstant.appConstants;
import com.qa.opencart.pages.ResultsPage;

import Basetest.BaseTestClass;

public class AccountsPageTest extends BaseTestClass{
	@BeforeClass
	public void accSetup() {
		accntpage = loginpage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void accPageTitleTest() {
		String actTitle = accntpage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, appConstants.ACCOUNTS_PAGE_TITLE);
	}
	@Test(priority=2)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accntpage.isLogoutLinkExist());
	}
	@Test(priority=3)
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accntpage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, appConstants.ACTUAL_ACCOUNTS_PAGE_HEADER_LIST);
	}
	@DataProvider
	public Object[][] getsearchKey(){
		return new Object[][]{{"mackbook",3},{"imac",1},{"samsung",2}};
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
