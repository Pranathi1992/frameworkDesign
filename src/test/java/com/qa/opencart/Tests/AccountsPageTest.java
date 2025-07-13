package com.qa.opencart.Tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.Pages.ResultsPage;

import com.qa.opencart.appConstant.AppConstants;


import Basetest.BaseTestClass;

public class AccountsPageTest extends BaseTestClass{
	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@Test(priority=1)
	public void accPageTitleTest() {
		String actTitle = accPage.getAccountsPageTitle();
		Assert.assertEquals(actTitle, AppConstants.ACCOUNTS_PAGE_TITLE);
	}
	@Test(priority=2)
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test(priority=3)
	public void accPageHeadersTest() {
		List<String> actualHeadersList = accPage.getAccPageHeaders();
		Assert.assertEquals(actualHeadersList, AppConstants.ACTUAL_ACCOUNTS_PAGE_HEADER_LIST);
	}
	@Test(priority=4)
	public void SearchCountTest() {
		resultsPage =accPage.doSearch("macbook");
		Assert.assertEquals(resultsPage.getSearchResultsCount(), 3);	
	}
	@Test(priority=5)
	public void searchTest() {
		resultsPage =accPage.doSearch("macbook");
		productInfoPage =resultsPage.selectProduct("MacBook Pro");
		Assert.assertEquals(productInfoPage.getProductHeader(),"MacBook Pro");
		
		}
	
}
