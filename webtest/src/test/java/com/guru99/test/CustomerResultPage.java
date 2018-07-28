package com.guru99.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerResultPage {
	@FindBy(name = "name")
	private WebElement nameField;
	
	@FindBy(name = "gender")
	private WebElement genderField;
	
	@FindBy(name = "dob")
	private WebElement dobField;
	
	public CustomerResultPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String getName() {
		return nameField.getAttribute("value");
	}
	
	public String getGender() {
		return genderField.getAttribute("value");
	}
	
	public String getDob() {
		return dobField.getAttribute("value");
	}	
}
