package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	WebDriver driver;
	
	public LandingPage(WebDriver driver){
		
		this.driver = driver;
		PageFactory.initElements(driver, this);	// Here this means initialize the objects of the LandingPage class
	}
	
	@FindBy(xpath="//a[@title='My Account']")
	private WebElement myaccountdropdown;
	
	
	@FindBy(linkText="Login")
	private WebElement loginoption;
	
	
	public WebElement myaccountdropdown() {
		
		return myaccountdropdown;
	}
	
	public WebElement loginoption() {
		
		return loginoption;
	}
}
