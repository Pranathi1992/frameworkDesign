package com.qa.opencart.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.appConstant.appConstants;
import com.qa.opencart.utils.elementUtil;

public class ProductInfoPage {
	private WebDriver driver;
	private elementUtil eleUtil;
	private By productHeader = By.tagName("h1");
	private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	private Map<String, String> productmap;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new elementUtil(driver);
	}
	
	public String getProductHeader() {
		String productHeaderValue = 
				eleUtil.waitForElementVisible(productHeader, appConstants.DEFAULT_SHORT_TIME_OUT).getText();
		System.out.println("Product Header ===> " + productHeaderValue);
		return productHeaderValue;
	}
	private void getMetaData() {
		List<WebElement> metaList=eleUtil.getElements(productMetaData);
		for(WebElement meta: metaList) {
			String metaText=meta.getText();
			String metaData[]=metaText.split(":");
			String metaKey=metaData[0].trim();
			String metaValue=metaData[1].trim();
			productmap.put(metaKey, metaValue);
		}
	}
	private void getProductPriceData() {
		List<WebElement> priceList=eleUtil.getElements(productPriceData);
		String price=priceList.get(0).getText();
		String exprice=priceList.get(1).getText().split(":")[1].trim();
		productmap.put("price", price);
		productmap.put("exprice", exprice);
	}
	public Map<String, String> getproductData() {
		productmap=new LinkedHashMap<String, String>();
		productmap.put("productHeader", getProductHeader());
		getMetaData();
		getProductPriceData();
		return productmap;
	}
}
