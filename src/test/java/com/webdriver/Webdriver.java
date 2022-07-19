package com.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Webdriver {
	public static WebDriver webDriver(WebDriver driver) {
		driver = new ChromeDriver();
		return driver;
		
	}

}
