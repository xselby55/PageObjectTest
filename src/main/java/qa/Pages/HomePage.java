package qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import qa.base.Base;

public class HomePage extends Base {

	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/a/img")
	WebElement homepageLabel;

	@FindBy(linkText = "Edit Customer")
	WebElement editCustomer;

	@FindBy(xpath = "/html/body/div[3]/div/ul/li[2]/a")
	@CacheLookup
	WebElement customer;

	@FindBy(linkText = "New Account")
	WebElement newAccount;

	// Initialize Home Page, page object

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Verification
	public String verifyHomeTitle() {

		return driver.getTitle();
	}
	
	public boolean verifyLogo() {

		return homepageLabel.isDisplayed();
	}

	public CustomerPage clickNewCustomerLink() throws InterruptedException {

		customer.click();

		return new CustomerPage();

	}


	public void newAccount() {
		newAccount.click();
	}

	public EditCustomer clickEditCustomerLink() {

		editCustomer.click();

		return new EditCustomer();

	}

	public NewAccountPage clickNewAccountLink() {

		newAccount.click();

		return new NewAccountPage();

	}

}
