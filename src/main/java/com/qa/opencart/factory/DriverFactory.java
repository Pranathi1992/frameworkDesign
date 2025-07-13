package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import com.qa.opencart.exceptions.browserException;
public class DriverFactory {
	public WebDriver driver;
	Properties prop;
	/**
	 * This method is used to initialise the browser on the basis of given browsername
	 * @param Browsername
	 * @return it will return driver
	 */
	public WebDriver initDriver(Properties prop) {
		String Browsername=prop.getProperty("browser");
		System.out.println("Browser name is"+":"+Browsername);
		switch(Browsername.toLowerCase().trim()) {
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
		default:
			System.out.println("please pass right browser name"+Browsername);
			throw new browserException("invaid browser"+Browsername);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;		
	}
	/**
	 * this method is used to intialize the properties from config file
	 * @return Properties
	 */
	public Properties initprop() {
		prop=new Properties();
		try {
		FileInputStream ip=new FileInputStream("./src/test/resources/config/config.properties");
		prop.load(ip);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
