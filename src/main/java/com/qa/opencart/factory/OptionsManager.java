package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

public class OptionsManager {
	private Properties prop;
	private ChromeOptions co;
	private EdgeOptions eo;
	private FirefoxOptions fo;
	public OptionsManager(Properties prop) {
		this.prop=prop;
	}
	public ChromeOptions getChromeOptions() {
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		co.addArguments("--headless");
	}
	if(Boolean.parseBoolean(System.getProperty("incognito"))) {
		co.addArguments("--incognito");
	}
		return co;	
	}
	public FirefoxOptions getFirefoxOptions() {
		fo=new FirefoxOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		fo.addArguments("--headless");
	}
	if(Boolean.parseBoolean(System.getProperty("incognito"))) {
		fo.addArguments("--incognito");
	}
		return fo;	
	}
	public EdgeOptions getEdgeOptions() {
		eo=new EdgeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless"))) {
		eo.addArguments("--headless");
	}
	if(Boolean.parseBoolean(System.getProperty("incognito"))) {
		eo.addArguments("--inprivate");
	}
		return eo;	
	}
	
}
