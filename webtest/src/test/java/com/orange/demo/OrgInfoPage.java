package com.orange.demo;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class OrgInfoPage {

	private WebDriver driver;
	
	@FindBy(id = "organization_taxId")
	private WebElement taxid;
	
	@FindBy(id = "organization_registraionNumber")
	private WebElement regid;
		
	public OrgInfoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);	
	}

	public void validateOrginfoPage() {
		Assert.assertTrue(driver.getCurrentUrl().endsWith("viewOrganizationGeneralInformation"));
	}

	public void validateTaxid(long id) {
		Assert.assertFalse(taxid.isEnabled());
		Assert.assertEquals(Long.parseLong(taxid.getAttribute("vlaue")), id);

	}
	
	public void validateRegid(String id) {
		Assert.assertEquals(regid.getAttribute("value"), id);

	}

	public void validateRegIdDisabled() {
		Assert.assertFalse(regid.isEnabled());		

	}
	
}
