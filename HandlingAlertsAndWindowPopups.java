package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchWindowException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;

public class HandlingAlertsAndWindowPopups {
	WebDriver driver;
	Alert myAlert;

	// @Test
	public void handlingAlerts() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		driver.findElement(By.name("username")).sendKeys("stc123");
		driver.findElement(By.name("username")).submit();
		Thread.sleep(3000);
		try {
			myAlert = driver.switchTo().alert();
			assertEquals(myAlert.getText(), "Please enter Password");
			myAlert.accept();
			// myAlert.dismiss();
			// myAlert.sendKeys("ABC");
			Thread.sleep(3000);
		} catch (NoAlertPresentException e) {
			fail("Alert is not present");
		}
		driver.findElement(By.name("password")).sendKeys("12345");

	}

	@Test
	public void handlingWindowPopups() throws InterruptedException {
		driver.get("https://nichethyself.com/tourism/home.html");
		driver.findElement(By.xpath("//button[text()='Contact us!']")).click();
		String parentWindowHandle = driver.getWindowHandle();
		try {
			driver.switchTo().window("Contact");// Window Name or Window Handle
		} catch (NoSuchWindowException e) {
			fail("Window not found");
		}
		driver.findElement(By.xpath("//a[@onclick = 'prompty()']")).click();
		try {
			myAlert = driver.switchTo().alert();
			myAlert.sendKeys("STC");
			Thread.sleep(3000);
			myAlert.accept();
		} catch (NoAlertPresentException e) {
			fail("Alert is not present");
		}
		driver.close();
		driver.switchTo().window(parentWindowHandle);
		driver.findElement(By.xpath("//button[text()='Write to us!']")).click();
		Set<String> allOpenWindows = driver.getWindowHandles();
		for (String window : allOpenWindows) {
			if (window.equals(parentWindowHandle)) {
				continue;
			}
			driver.switchTo().window(window);
			driver.findElement(By.name("name")).sendKeys("Mark");
		}
		Thread.sleep(3000);
		driver.switchTo().window(parentWindowHandle);
		
	}

	@BeforeClass
	public void beforeClass() {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
