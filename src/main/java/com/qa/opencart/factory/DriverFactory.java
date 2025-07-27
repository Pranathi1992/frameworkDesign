package com.qa.opencart.factory;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
public class DriverFactory {
	public WebDriver driver;
	Properties prop;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<WebDriver>();
	public static Logger log=LogManager.getLogger(DriverFactory.class);//use from apache log4j
	/**
	 * This method is used to initialise the browser on the basis of given browsername
	 * @param Browsername
	 * @return it will return driver
	 */
	public WebDriver initDriver(Properties prop) {
		log.info("properties are: "+ prop);
		String Browsername=prop.getProperty("browser");
		//System.out.println("Browser name is"+":"+Browsername);
		log.info("Browser name is"+":"+Browsername);
		OptionsManager optionsManager=new OptionsManager(prop);
		switch(Browsername.toLowerCase().trim()) {
		case "chrome":
			//driver=new ChromeDriver(optionsManager.getChromeOptions());
			tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			break;
		case "firefox":
			//driver=new FirefoxDriver(optionsManager.getFirefoxOptions());
			tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			break;
		case "edge":
			//driver=new EdgeDriver(optionsManager.getEdgeOptions());
			tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
		default:
			//System.out.println("please pass right browser name"+Browsername);
			log.error("please pass right browser name"+Browsername);
			
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().get(prop.getProperty("url"));
		return getDriver();		
	}
	public static WebDriver getDriver() {
		return tlDriver.get();
		
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
			//System.out.println("env is null run in qa env");
			log.warn("env is null run in qa env");
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
	public static File getScreenshotFile() {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		return srcFile;
	}

	public static byte[] getScreenshotByte() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);// temp dir

	}

	public static String getScreenshotBase64() {
		return ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BASE64);// temp dir

	}


}
