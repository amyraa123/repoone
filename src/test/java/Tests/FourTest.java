package Tests;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Resources.Base;

public class FourTest extends Base{

	public WebDriver driver;
	
	@Test
	public void TestFour() throws IOException, InterruptedException {
		
		System.out.println("Has Been Updated Test Four Executed");
		
		System.out.println("Moving to staging branch");
		
		driver = initializeDriver();
		
		driver.get("http://www.tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		Assert.assertTrue(false);
		
	}
	
	@AfterMethod
	public void closure() throws InterruptedException {
		
		Thread.sleep(2000);
		driver.close();
	}
}
