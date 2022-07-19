package com.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	String textbox_username_id = "user-name";
	String textbox_password_id = "password";
	String button_login = "//input[@id='login-button']";
	String button_logout = "//a[@id='logout_sidebar_link']";

	public void setUserName(String username, WebDriver driver) {
		driver.findElement(By.id(textbox_username_id)).clear();
		driver.findElement(By.id(textbox_username_id)).sendKeys(username);
	}
	
	public void setPassword(String pass, WebDriver driver) {
		driver.findElement(By.id(textbox_password_id)).clear();
		driver.findElement(By.id(textbox_password_id)).sendKeys(pass);	
	}
	
	public void clickLogin(WebDriver driver) {
		driver.findElement(By.xpath(button_login)).click();
	}
	
	public void clickLogOut(WebDriver driver) throws InterruptedException {
		driver.findElement(By.xpath("//button[@id='react-burger-menu-btn']")).click();
		Thread.sleep(2500);
		driver.findElement(By.xpath("//a[@id='logout_sidebar_link']")).click();
	}
	
	

}
