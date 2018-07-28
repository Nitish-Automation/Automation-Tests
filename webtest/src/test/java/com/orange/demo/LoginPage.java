package com.orange.demo;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	private WebDriver driver;
	private String url = "http://opensource.demo.orangehrmlive.com";
	
	@FindBy(id = "txtUsername")
	private WebElement userIdField;
	
	@FindBy(id = "txtPassword")
	private WebElement passwordField;
	
	@FindBy(id = "btnLogin")
	private WebElement loginBtn;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		driver.get(url);
		PageFactory.initElements(driver, this);
	}
	
	public void enterUserId(String userId) {
		userIdField.clear();
		userIdField.sendKeys(userId);
	}
	
	public void enterPassword(String password) {
		passwordField.clear();
		passwordField.sendKeys(password);
	}
	
	public NavigationMenu clickLogin() {
		Assert.assertTrue(loginBtn.isEnabled());
		loginBtn.click();
		return new NavigationMenu(driver);
	}
	

}
