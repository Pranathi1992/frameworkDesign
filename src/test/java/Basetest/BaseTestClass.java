package Basetest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.Pages.AccountsPage;
import com.qa.opencart.Pages.LoginPage;
import com.qa.opencart.Pages.ProductInfoPage;
import com.qa.opencart.Pages.ResultsPage;
import com.qa.opencart.factory.DriverFactory;

public class BaseTestClass {
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;

	protected LoginPage loginPage;
	protected AccountsPage accPage;
	protected ResultsPage resultsPage;
	protected ProductInfoPage productInfoPage;
	@BeforeTest
	//creating object for driver class to get the driver 
	//and supplying that driver to login page
	public void setup() {
		df=new DriverFactory();
		prop=df.initprop();
		driver=df.initDriver(prop);
		loginPage=new LoginPage(driver);
	}
	@AfterTest
	public void tearDown(){
		driver.quit();
	}	
}
