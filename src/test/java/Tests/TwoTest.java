package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class TwoTest extends Base{

	@Test
	public void TestTwo() throws IOException, InterruptedException {
		
		System.out.println("Has Been again Updated");
		
		System.out.println("Test Two Executed");
		
		WebDriver driver = initializeDriver();
		
		driver.get("http://www.tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		driver.close();
	}
}
