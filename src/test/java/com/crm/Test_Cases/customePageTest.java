package com.crm.Test_Cases;

import org.testng.annotations.AfterMethod;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.*;

import qa.Pages.CustomerPage;
import qa.Pages.HomePage;
import qa.Pages.LoginPage;
import qa.base.Base;
import qa.utility.testUtil;

public class customePageTest extends Base {

	LoginPage loginPage;
	HomePage homepage;
	testUtil testutile;
	CustomerPage customerpage;
	String sheetname = "Guru99";
	String path = "/src/main/java/qa/test_data/Guru99.xlsx";

	// Create HomePageTest constructor
	public customePageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {

		// Initializing Base class
		initialize();

		// Create login object
		loginPage = new LoginPage();
		testutile = new testUtil(path);
		customerpage = new CustomerPage();
		homepage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@Test(priority = 1)
	public void addNewCustomer() throws InterruptedException {

		homepage.clickNewCustomerLink();
		driver.navigate().to("https://demo.guru99.com/V1/html/addcustomerpage.php");
		customerpage.selectGender("female");
	}

	@Test(priority = 2, groups = "confirmation")
	public void setValuesOnTheForm() throws InterruptedException {
		homepage.clickNewCustomerLink();
		driver.navigate().to("https://demo.guru99.com/V1/html/addcustomerpage.php");
		customerpage.selectGender("female");
		customerpage.fillTheForm("Xoks", "", "1992/09/12", "123 home school", "bangalo", "standard", "199293",
				"0981234747471", "test@test1.com");
		Thread.sleep(3000);
	}

	@Test(priority = 3, dataProvider = "getTestData")
	public void createNewCustomer(String name, String gender, String date, String address, String city, String state,
			String pin, String tel, String email) throws InterruptedException, IOException {
		homepage.clickNewCustomerLink();
		//driver.navigate().to("https://demo.guru99.com/V1/html/addcustomerpage.php");
		customerpage.fillTheForm(name, gender, date, address, city, state, pin, tel, email);
		testutile.setCellData("Sheet1", 1, 10, "Pass");
		Thread.sleep(3000);
	}

	@DataProvider(name = "getTestData")
	public String[][] getTestData() throws InvalidFormatException, IOException {
		String path = "src/main/java/qa/test_data/Guru99.xlsx";
		testutile = new testUtil(path);

		int totalrows = testutile.getRowCount("Sheet1");
		int totalcols = testutile.getCellCount("Sheet1", 1);

		String loginData[][] = new String[totalrows][totalcols];

		for (int i = 1; i <= totalrows; i++) // 1
		{
			for (int j = 0; j < totalcols; j++) // 0
			{
				loginData[i - 1][j] = testutile.getCellData("Sheet1", i, j);
			}

		}

		return loginData;
	}


	@AfterMethod
	public void exitBrowser() {
		driver.quit();
	}

}
