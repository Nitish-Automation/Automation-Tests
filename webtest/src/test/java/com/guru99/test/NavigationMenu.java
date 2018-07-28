package com.guru99.test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {
	private WebDriver driver;
	
	@FindBy(css = ".menusubnav a[href='EditCustomer.php']")
	private WebElement editCustomerEntry;
	
	@FindBy(css = ".menusubnav a[href='BalEnqInput.php']")
	private WebElement balanceEnquiryEntry;
	
	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public EditCustomerPage gotoEditCustomerPage() {
		editCustomerEntry.click();
		return new EditCustomerPage(driver);
	}
}
