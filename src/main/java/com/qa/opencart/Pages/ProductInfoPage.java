package com.qa.opencart.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.appConstant.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private ElementUtil eleUtil;
	private By productHeader = By.tagName("h1");
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	
	public String getProductHeader() {
		String productHeaderValue = 
				eleUtil.waitForElementVisible(productHeader, AppConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Product Header ===> " + productHeaderValue);
		return productHeaderValue;
	}
}
