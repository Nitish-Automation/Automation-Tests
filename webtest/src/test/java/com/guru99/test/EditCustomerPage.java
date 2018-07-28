package com.guru99.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EditCustomerPage {
	private WebDriver driver;
	
	@FindBy(name = "cusid")
	private WebElement customerIdField;
	
	@FindBy(name = "AccSubmit")
	private WebElement submitBtn;
	
	public EditCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public CustomerResultPage query(String customerId) {
		customerIdField.clear();
		customerIdField.sendKeys(customerId);
		submitBtn.click();
		return new CustomerResultPage(driver);
	}
}
