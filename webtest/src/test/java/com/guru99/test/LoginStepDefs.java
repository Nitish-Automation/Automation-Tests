package com.guru99.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginStepDefs {
	private WebDriver driver;
	private LoginPage login;
	private HomePage home;
	private String errorMsg;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\PracticeWorkspace\\webtest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("the user in on the login page")
	public void userIsOnLoginPage() {
		login = new LoginPage(driver);
	}
	
	@When("he enters %([^%]*)% as user id")
	public void heEntersUserId(String userId) {
		login.enterUserId(userId);
	}
	
	@And("he enters %([^%]*)% as password")
	public void heEntersPassword(String password) {
		login.enterPassword(password);
	}
	
	@And("he clicks the LOGIN button with valid login info")
	public void heClicksLoginBtn() {
		home = login.clickLogin();
	}
	
	@Then("ensure the Manger Id is %([^%]*)%")
	public void ensureMangerId(String mangerId) {
		assertTrue(home.getMangerId().endsWith(mangerId));
	}	
	
	@And("he clicks the LOGIN button with invalid login info")
	public void heClicksLoginBtnWithInvalidLoginInfo() {
		errorMsg = login.clickLoginWithInvalidInfo();
	}
	
	@Then("ensure the appearance of alert message")
	public void ensureAlertMessage() {
		assertEquals(errorMsg, "User or Password is not valid");
	}
}
