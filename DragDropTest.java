package scripts;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
//added new line
public class DragDropTest {
	
	private WebDriver driver;
	private StringBuffer verificationErrors = new StringBuffer();
	
	@BeforeMethod
	public void setUp()
	{
		driver = new ChromeDriver();
	}

	@Test
	public void testDragDrop() throws InterruptedException {
		
		driver.get("http://www.cookbook.seleniumacademy.com/DragDropDemo.html");
		
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		Actions builder = new Actions(driver);//Builder design Pattern
		builder.dragAndDrop(source, target).perform();
		
	//	builder.perform();
		Thread.sleep(5000);
		/*
		 * builder.moveToElement(source).dragAndDrop(source,target).contextClick(source)
		 * .build(); builder.contextClick(source).perform(); builder.perform();
		 * builder.perform();
		 */
			   
/*	
 * 	
		if () 
			 builder.doubleClick().build();
		else
			builder.click().build();
		builder.perform();
*/		
		//builder.
	
	/*	builder.dragAndDrop(source, target)
		   .moveToElement(source)
		   .contextClick(source)
		   .click()
		   .sendKeys("niche").build();;*/
		
	/*	builder.click().build();
		builder.dragAndDrop(source, target).build();
		
		builder.perform();
		*/
		

		
		
		try
		{
			System.out.println(target.getText());
			AssertJUnit.assertEquals("Dropped!", target.getText());
			
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
		String verificationErrorString = verificationErrors.toString();
		if (!"".equals(verificationErrorString)) {
			Assert.fail(verificationErrorString);
		}
	}
}