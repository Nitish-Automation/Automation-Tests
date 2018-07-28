package com.orange.demo;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NavigationMenu {

	private WebDriver driver;
	
	@FindBy(id = "welcome")
	private WebElement welcome;
	
	@FindBy(id = "menu_admin_viewAdminModule")
	private WebElement adminmenu;
	
	@FindBy(id = "menu_admin_Organization")
	private WebElement orgmenu;
	
	@FindBy(id = "menu_admin_viewOrganizationGeneralInformation")
	private WebElement orginfo;
	
	public NavigationMenu(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);		
	}
	
	public void verifyUserLogin() {
		Assert.assertTrue(welcome.isDisplayed());
	}

	public void gotoAdminMenu() {
		Assert.assertTrue(adminmenu.isEnabled());
		adminmenu.click();
	}
	
	public OrgInfoPage gotoOrgMenu() {
		Assert.assertTrue(orgmenu.isEnabled());
		Actions action = new Actions(driver);
		action.moveToElement(orgmenu).moveToElement(orginfo).click().build().perform();
		return new OrgInfoPage(driver);
	}
}
