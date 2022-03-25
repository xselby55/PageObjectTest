package qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.Base;



public class LoginPage extends Base{
	
	//Page factory or Object Repository
	//Username
	@FindBy(name ="uid")
	WebElement username;
	
	//password
	@FindBy(name ="password")
	WebElement password;
	
	//Login button
	@FindBy(name = "btnLogin")
	WebElement login;
	
	//Working with signup button
	@FindBy(linkText = "Sign Up")
	WebElement signup;
	
	//Finding the image on the website
	@FindBy(xpath = "/html/body/div[1]/div[1]/div[1]/div[1]/a/img")
	WebElement crmlogo;
	
	public LoginPage() {
		
		//Initializing  page object or factory
		PageFactory.initElements(driver, this);	
	}
	//Actions
	public String validationLogin() {
		return driver.getTitle();
	}
	
	public boolean validationLogo() {
		return crmlogo.isDisplayed();
	}
	
	public HomePage login(String usern, String pass) {
		username.sendKeys(usern);
		password.sendKeys(pass);
		login.click();
		
		return new HomePage();
	}
	

}
