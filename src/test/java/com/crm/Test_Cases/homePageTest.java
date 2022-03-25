package com.crm.Test_Cases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

//import org.junit.Assert;
import org.testng.Assert;
import org.testng.annotations.*;

import qa.Pages.CustomerPage;
import qa.Pages.HomePage;
import qa.Pages.LoginPage;
import qa.base.Base;
import qa.utility.testUtil;

public class homePageTest extends Base {

	LoginPage loginPage;
	HomePage homepage;
	testUtil testutile;
	CustomerPage customerpage;

	// Create HomePageTest constructor
	public homePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		// Initializing Base class
		initialize();

		// Create login object
		loginPage = new LoginPage();
		//testutile = new testUtil();
		customerpage = new CustomerPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority = 1)
	public void vrfyHomePageTitleTest() {
		
		String homepagetitle = homepage.verifyHomeTitle();
		Assert.assertEquals(homepagetitle, "GTPL Bank Manager HomePage", "Page does not match");

	}
	
	@Test(priority = 2)
	public void vrfyLogoTest() {
		
		//testutile.switchToFrame();
		Assert.assertTrue(homepage.verifyLogo());
		
	}
	@Test(priority =3)
	public void vrfyNewCustomerTest() throws InterruptedException {
		customerpage =homepage.clickNewCustomerLink();
		System.out.println("Done executing");
	}

	@AfterMethod
	public void exitBrowser() {
		driver.quit();
	}

}
