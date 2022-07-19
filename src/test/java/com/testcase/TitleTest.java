package com.testcase;


import org.apache.logging.log4j.*;
import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.log.Log4jClass;
import com.pageObjects.TitleFetch;
import com.url.URLParse;
import com.webdriver.Webdriver;

public class TitleTest {
	public WebDriver driver;

	@BeforeTest

	public void browserLaunch() {
		String url = URLParse.url();
		driver = Webdriver.webDriver(driver);
		driver.get(url);
	}

	@Test

	public void titleCheck(){
		Logger log = Log4jClass.log();
		log.info("*****Starting test*****");
		String act_title = TitleFetch.title_check(driver);
		String exp_title = "Swag Labs";
		Assert.assertEquals(act_title, exp_title);
		log.info("*****Title matched*****");
		log.info("*****Test Completed*****");

	}

	@AfterTest

	public void browserClose() {
		driver.close();
	}

}
