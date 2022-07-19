package com.pageObjects;

import org.openqa.selenium.WebDriver;

public class TitleFetch {
	public static String title_check(WebDriver driver) {
		String title = driver.getTitle();
		return title;
		
	}

}
