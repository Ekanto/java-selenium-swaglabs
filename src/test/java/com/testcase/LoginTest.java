package com.testcase;

import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.excelfile.XlUtility;
import com.log.Log4jClass;
import com.pageObjects.LoginPage;
import com.screenshot.ScreenShot;
import com.url.URLParse;
import com.webdriver.Webdriver;
import java.io.IOException;

import org.apache.logging.log4j.*;

public class LoginTest {
	public WebDriver driver;
	Logger log = Log4jClass.log();

	@BeforeTest
	public void borwserLaunch() {
		String url = URLParse.url();
		driver = Webdriver.webDriver(driver);
		driver.get(url);
	}

	@Test(dataProvider = "LoginData")
	public void loginCheck(String user, String pass, String val) throws IOException, InterruptedException {
		SoftAssert softAssert = new SoftAssert();
		log.info("****Starting Log In test****");
		LoginPage login = new LoginPage();
		login.setUserName(user, driver);
		login.setPassword(pass, driver);
		login.clickLogin(driver);

		if (val.equals("Valid")) {
			if (driver.findElement(By.xpath("//span[@class='title']")).isDisplayed()) {
				Assert.assertTrue(true);
				log.info("****Log in Successful****");
				login.clickLogOut(driver);
				log.info("****Logged out****");
			} else {
				softAssert.assertTrue(false);
				log.info("****Log in failed****");
				ScreenShot.screenShot(driver);
			}

		} else {
			if (val.equals("Invalid")) {

				try {
					driver.findElement(By.xpath("//span[@class='title']"));

				} catch (Exception e) {
					Assert.assertTrue(true);
					log.info("*****Test passed*****");
				}

			}
			else {
				log.info("*****Test failed*****");
				ScreenShot.screenShot(driver);
			}
		}

	}

	@DataProvider(name = "LoginData")
	public String[][] getData() throws IOException {
		String path = ".\\resources\\LoginDetails.xlsx";
		XlUtility utility = new XlUtility(path);
		int tot_rows = utility.getRowCount("Sheet1");
		int tot_column = utility.getCellCount("Sheet1", 1);
		String logindata[][] = new String[tot_rows][tot_column];

		for (int i = 1; i <= tot_rows; ++i) {
			for (int j = 0; j < tot_column; ++j) {
				logindata[i - 1][j] = utility.getCellData("Sheet1", i, j);

			}
		}
		return logindata;
	}

	@AfterTest
	public void browserClose() throws InterruptedException {

		driver.close();
	}

}
