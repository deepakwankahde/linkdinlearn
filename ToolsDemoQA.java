package scripts;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

//modified file in dev branch

public class ToolsDemoQA {
	WebDriver driver;
 @Test
  public void fillForm() {
	  driver.get("https://demoqa.com/automation-practice-form");
	  driver.findElement(By.id("firstName")).sendKeys("Dhairya");
	  WebElement surname= driver.findElement(By.id("lastName"));
	  surname.sendKeys("Wankhade");
	  System.out.println(surname.getAttribute("lastName"));
	  //driver.findElement(By.xpath("//label[text()='Male']")).click();
	  driver.findElement(By.id("userNumber")).sendKeys("7798268998");
	 // driver.findElement(By.id("dateOfBirthInput")).click();
	  driver.findElement(By.id("subjectsInput")).sendKeys("English");
	  driver.findElement(By.id("//label[text()='Reading']")).click();
	  driver.findElement(By.id("currentAddress")).sendKeys("E706, Park Ivory, Park Street, Pune 411057");
	  WebElement state=driver.findElement(By.xpath("//div[text()='Select State']"));
	  Select stateSelect= new Select(state);
	         stateSelect.selectByValue("Rajasthan");
	  WebElement city=driver.findElement(By.xpath("//div[text()='Select City']']"));
	  Select citySelect= new Select(city);
	  citySelect.selectByIndex(1);
	  driver.findElement(By.id("submit")).click();
	  
	      
  }
  
  //@Test
  
  public void cookBookCheckBox() {
	 		/*
		 * Click on Diesel radio button. Click on ABS checkbox Verify the LED Headlamp
		 * checkbox is disabled
		 */
	  driver.get("http://www.cookbook.seleniumacademy.com/Config.html");
	  driver.findElement(By.xpath("//p/input[@value='Diesel']")).click();
	  WebElement abs= driver.findElement(By.name("abs"));
	  if (!abs.isSelected()) {
			abs.click();
		}
	  
	  WebElement headLamp= driver.findElement(By.name("ledheadlamp"));
	  System.out.println("Is headLamp enabled - " + headLamp.isEnabled());
	  
  }
  
  //@Test
  public void dropDown() throws InterruptedException {
	  
		/*
		 * Go to https://the-internet.herokuapp.com/dropdown And select option 1 from
		 * dropdown And then select option 2 from dropdown
		 */
	  
	  driver.get("https://the-internet.herokuapp.com/dropdown");
	  WebElement selectDropdown= driver.findElement(By.id("dropdown"));
	  Thread.sleep(5000);
	  Select selectDropdowntest =new Select(selectDropdown);
	  selectDropdowntest.selectByVisibleText("Option 2");
	 
	  System.out.println(selectDropdowntest);
  }
  
  @BeforeClass
  public void beforeClass() {
	  driver=new ChromeDriver();
	 // driver=new FirefoxDriver();
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  
  }

  @AfterClass
  public void afterClass() {
	 // driver.close();
  }

}
