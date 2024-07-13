package scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
//mofifiled in main branch

public class TestYourSetup {

	WebDriver driver;

	@Test
	public void loginToNicheThyselfTourism() {
		driver.get("https://nichethyself.com/tourism/home.html");
		
	}
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod() {
		driver = new ChromeDriver();
	}

}
