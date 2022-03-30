package qa.Pages;
/*
 * *?
 * Created by Xolani Dlamini
 * 
 * 
 * 
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import qa.base.Base;

public class CustomerPage extends Base {

	@FindBy(xpath = "/html/body/table/tbody/tr/td/table/tbody/tr[4]/td[2]/input")
	WebElement nam;

	public CustomerPage() {

		// Initializing page object or factory
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//label[@id='message']")
	WebElement gndrTxt;
	
	@FindBy(name ="rad1")
	WebElement gndr;

	public boolean vrfyGender(String Gender) {
		return gndrTxt.isDisplayed();
	}
	public void selectGender(String genderIdentity) {
		
//		Select sele = new Select(driver.findElement(By.name("rad1")));
//		sele.selectByVisibleText(genderIdentity);
		
		if(genderIdentity == "male") {
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
		}else {
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
		}
		
		gndr.sendKeys(genderIdentity);
		
	}

	@FindBy(xpath = "//input[@name='dob']")
	WebElement dob;

	@FindBy(xpath = "//textarea[@name='addr']")
	WebElement addr;

	@FindBy(xpath = "//input[@name='city']")
	WebElement cty;

	@FindBy(xpath = "//input[@name='state']")
	WebElement stte;

	@FindBy(xpath = "//input[@name='pinno']")
	WebElement pn;

	@FindBy(xpath = "//input[@name='telephoneno']")
	WebElement tlphone;

	@FindBy(xpath = "//input[@name='emailid']")
	WebElement e_mail;

	@FindBy(xpath = "//input[@type='submit']")
	WebElement submit;

	@FindBy(xpath = "//input[@type='reset']")
	WebElement reset;
	
	public void fillTheForm(String name,String gender,String  d_o_b,String address,String city,String state, String pin,String telephone,String email) {

		nam.sendKeys(name);
		gndr.sendKeys(gender);
		if(gender == "male") {
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[1]"));
		}else {
			driver.findElement(By.xpath("/html/body/table/tbody/tr/td/table/tbody/tr[5]/td[2]/input[2]"));
		}
		dob.clear();
		dob.sendKeys(d_o_b);
		addr.sendKeys(address);
		cty.sendKeys(city);
		stte.sendKeys(state);
		pn.sendKeys(pin);
		tlphone.sendKeys(telephone);
		e_mail.sendKeys(email);
		submit.click();
		
	}
	

}
