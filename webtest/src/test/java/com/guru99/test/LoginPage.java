package com.guru99.test;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
	private WebDriver driver;
	private String url = "http://demo.guru99.com/V4/";
	
	@FindBy(name = "uid")
	private WebElement userIdField;
	
	@FindBy(name = "password")
	private WebElement passwordField;
	
	@FindBy(name = "btnLogin")
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
	
	public HomePage clickLogin() {
		loginBtn.click();
		return new HomePage(driver);
	}
	
	public String clickLoginWithInvalidInfo() {
		loginBtn.click();
		
		WebDriverWait wait = 
			new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.alertIsPresent());
		
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}
}
