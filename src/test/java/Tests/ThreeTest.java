package Tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import Resources.Base;

public class ThreeTest extends Base{

	@Test
	public void TestThree() throws IOException, InterruptedException {
		
		System.out.println("Test Three Executed");
		
		WebDriver driver = initializeDriver();
		
		driver.get("http://www.tutorialsninja.com/demo/");
		
		Thread.sleep(2000);
		
		driver.close();
	}
}
