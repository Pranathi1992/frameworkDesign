package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.appConstant.appConstants;

import com.qa.opencart.utils.elementUtil;

public class LoginPage {
	//default value of driver is null
	private WebDriver driver;
	private elementUtil eleutil;
	//1.in pom we have to give by locator as private
	private By emailId=By.id("input-email");
	private By password=By.id("input-password");
	private By loginBtn=By.xpath("//input[@value='Login']");
	private By forgotpwdlink=By.linkText("Forgotten Password");
	private By logoimg=By.cssSelector("img.img-responsive");
	private By registerLink=By.linkText("register");
	//we will use parametrised constructor to intialise driver
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new elementUtil(driver);
	}
	//3.pageaction/methods
	public String getLoginPageTitle() {
		String title=eleutil.waitForTitleContainsAndReturn(appConstants.LOGIN_PAGE_TITLE, appConstants.DEFAULT_SHORT_TIME_OUT);
		//String title=driver.getTitle();
		System.out.println("Login page title is: "+title);
		return title;
	}
	public String getLoginPageURL() {
		String currenturl=eleutil.waitForURLContainsAndReturn(appConstants.Login_PAGE_FRACTION_URL, appConstants.DEFAULT_SHORT_TIME_OUT);
		//String currenturl=driver.getCurrentUrl();
		System.out.println("Login page title is: "+currenturl);
		return currenturl;
	}
	public boolean isForgotPasswordLinkExist() {
		return eleutil.isElementDisplayed(forgotpwdlink);
		//return driver.findElement(forgotpwdlink).isDisplayed();
		
	}
	public boolean isLogoImageExist() {
		return eleutil.isElementDisplayed(logoimg);
		//return driver.findElement(logoimg).isDisplayed();
	}
	
	public AccountsPage doLogin(String un, String pwd) {
		eleutil.waitForElementVisible(emailId,appConstants.DEFAULT_MEDIUM_TIME_OUT ).sendKeys(un);
		eleutil.doSendKeys(password, pwd);
		eleutil.doClick(loginBtn);
		//driver.findElement(emailId).sendKeys(un);
		//driver.findElement(password).sendKeys(pwd);
		//driver.findElement(loginBtn).click();
		//String accnttitle=eleutil.waitForTitleContainsAndReturn(appConstants.ACCOUNTS_PAGE_TITLE, appConstants.DEFAULT_SHORT_TIME_OUT);
		//String accnttitle=driver.getTitle();
		//System.out.println("account page title:"+accnttitle);
		return new AccountsPage(driver);
	}
	public RegisterPage navigateToRegisterpage() {
		eleutil.doClick(registerLink);
		return new RegisterPage(driver);
	}
}
