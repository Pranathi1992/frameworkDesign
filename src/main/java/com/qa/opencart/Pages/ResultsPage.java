package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.qa.opencart.appConstant.appConstants;
import com.qa.opencart.utils.elementUtil;

public class ResultsPage {

	private WebDriver driver;
	private elementUtil eleUtil;

	private By searchHeader = By.cssSelector("div#content h2");
	private By results = By.cssSelector("div.product-thumb");

	public ResultsPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new elementUtil(driver);
	}

	public String getSearchHeader() {
		String searchHeaderValue = eleUtil.waitForElementVisible(searchHeader, appConstants.DEFAULT_SHORT_TIME_OUT)
				.getText();
		return searchHeaderValue;
	}

	public int getSearchResultsCount() {
		int resultCount = eleUtil.waitForElementsVisible(results, appConstants.DEFAULT_MEDIUM_TIME_OUT).size();
		System.out.println("search result count ===> " + resultCount);
		return resultCount;
	}

	public ProductInfoPage selectProduct(String productName) {
		System.out.println("selecting product: " + productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}

}