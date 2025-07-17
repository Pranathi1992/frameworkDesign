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
		String envName=System.getProperty("env");
		System.out.println("running test on env"+ envName);
		FileInputStream ip=null;
		
		try 
		{
			if(envName==null) {
			System.out.println("env is null run in qa env");
			ip=new FileInputStream("./src/test/resources/config/config.properties");
			}else {
				switch (envName.toLowerCase().trim())
				{
				case "qa":
					ip=new FileInputStream("./src/test/resources/config/qa.config.properties");
					break;
				case "dev":
					ip=new FileInputStream("./src/test/resources/config/dev.config.properties");
					break;
				case "stage":
					ip=new FileInputStream("./src/test/resources/config/config.properties");
					break;

				default:
					System.out.println("please pass right environment"+ envName);
					break;
				}
			}
		prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}

}
