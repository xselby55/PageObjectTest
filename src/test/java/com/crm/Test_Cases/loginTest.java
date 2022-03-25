package com.crm.Test_Cases;

import org.junit.Assert;
import org.testng.annotations.*;

import qa.Pages.HomePage;
import qa.Pages.LoginPage;
import qa.base.Base;

public class loginTest extends Base {
	
	LoginPage loginPage;
	HomePage homepage;

	public loginTest() {
		super();
	}

	@BeforeMethod 
	public void setUp() {
		
		initialize();
		loginPage = new LoginPage();
	}
	@Test(priority = 1, groups = "login")
	public void validatePageTitleTest() {
		String title =loginPage.validationLogin();
		
		Assert.assertEquals(title, "GTPL Bank Home Page");
	}
	@Test(priority = 2)
	public void crmLogoTest() {
		boolean logo =loginPage.validationLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority =3)
	public void loginiTest() {
		homepage =loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		String title =driver.getTitle();
		Assert.assertEquals(title, "GTPL Bank Manager HomePage");
	}
	
	@AfterMethod
	public void exitBrowser() {
		driver.quit();
	}

}
