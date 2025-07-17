package Basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencart.pages.ProductInfoPage;
import com.qa.opencart.pages.RegisterPage;
import com.qa.opencart.pages.ResultsPage;

public class BaseTestClass {
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginpage;
	protected AccountsPage accntpage;
	protected ResultsPage resultspage;
	protected ProductInfoPage productinfopage;
	protected RegisterPage registerpage;
	@BeforeTest
	//creating object for driver class to get the driver 
	//and supplying that driver to login page
	public void setup() {
		df=new DriverFactory();
		prop=df.initprop();
		driver=df.initDriver(prop);
		loginpage=new LoginPage(driver);
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}	
}
