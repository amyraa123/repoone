package Tests;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import PageObjects.AccountPage;
import PageObjects.LandingPage;
import PageObjects.LoginPage;
import Resources.Base;


public class LoginTest extends Base{
	
	WebDriver driver;
	Logger log;
	
	@BeforeMethod
	public void open() throws IOException {
		
		log = LogManager.getLogger(LoginTest.class.getName());
		
		driver = initializeDriver();
		log.debug("Browser got launched");
		driver.get(prop.getProperty("url"));
		log.debug("Navigated to application URL");
		
	}
	
	@Test(dataProvider="getLoginData")	//Here we have connected getLoginData() data provider to @Test method
	public void login(String email, String password, String expectedresult) {
		
		LandingPage landingPage = new LandingPage(driver);
		landingPage.myaccountdropdown().click();
		log.debug("Clicked on My Account dropdown");
		landingPage.loginoption().click();
		log.debug("Clicked on login option");
		
		LoginPage loginpage = new LoginPage(driver);
		//loginpage.email().sendKeys(prop.getProperty("email"));
		//loginpage.password().sendKeys(prop.getProperty("password"));
		loginpage.email().sendKeys(email);
		log.debug("Email addressed got entered");
		loginpage.password().sendKeys(password);
		log.debug("Password got entered");
		loginpage.loginButton().click();
		log.debug("Clicked on Login Button");
		
		AccountPage accountpage = new AccountPage(driver);
		
		String actualresult = null;
		
		try {
			
			if(accountpage.editaccountinformationOption().isDisplayed()) 
				log.debug("User got logged in");
				actualresult = "Successfull";	
			
		}catch(Exception e) {
			
			log.debug("User didn't log in");
			actualresult = "Failure";
		}
		
		Assert.assertEquals(actualresult, expectedresult);
		log.info("Login Test got passed");
		
		//Assert.assertTrue(accountpage.editaccountinformationOption().isDisplayed());	
	}
	
	@AfterMethod
	public void tearDown() {
		
		driver.close();
		log.debug("Browser got closed");
	}
	
	@DataProvider
	public Object[][] getLoginData() {	//If we multiple sets of data then use data provider instead of using data.properties
										//If we have single set of data then use data properties file
		//Object[][] data = {{"amyraa702@gmail.com","MavenProject@1","Successfull"},{"myraa123@gmail.com","12345","Failure"}};
		
		Object[][] data = {{"amyraa702@gmail.com","MavenProject@1","Successfull"}};
		
		return data;
		
	}
}
