package com.orange.demo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class OrgInfoValidationStepDef {
	
	private WebDriver driver;
	private OrgInfoPage orginfo;
	private LoginPage login;
	private NavigationMenu navmenu;
	
	@Before
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "E:\\PracticeWorkspace\\webtest\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("^User is on the login page$")
	public void user_is_on_the_login_page() {
		login = new LoginPage(driver);
	}

	@Given("^Enters %([^%]*)% as username$")
	public void enters_admin_as_username(String userId) {
		login.enterUserId(userId);
	}

	@Given("^Enters %([^%]*)% as password$")
	public void enters_admin_as_password(String password) {
		login.enterPassword(password);
	}

	@Given("^Click login button$")
	public void click_login_button() {
		navmenu = login.clickLogin();
	}
	
	@Then("^Make sure login is success$")
	public void make_sure_login_is_sucess() {
		navmenu.verifyUserLogin();
	}
	
	@Then("^User is able to navigate to orginfo page$")
	public void user_is_able_to_navigate_to_orginfo_page() {		
		navmenu.gotoAdminMenu();
		orginfo = navmenu.gotoOrgMenu();
	}

	@When("^User sucessfully land on orginfo page$")
	public void user_sucessfully_land_on_orginfo_page() {
		orginfo.validateOrginfoPage();
	}

	
	@Then("^Registration id is disabled and value is %([^%]*)%")
	public void registration_id_is_disabled_and_value_is(String regid) {
		orginfo.validateRegIdDisabled();
		orginfo.validateRegid(regid);
	}
	
}
