package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DragAndDrop {

	WebDriver driver = null;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	//@Test
	public void dragableCordiTest() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "jQuery UI");
		
		driver.findElement(By.xpath("//a[normalize-space()='Draggable']")).click();
		Assert.assertEquals(driver.getTitle(), "Draggable | jQuery UI");
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement dragable = driver.findElement(By.id("draggable"));
		
		Actions action = new Actions(driver);
		action.dragAndDropBy(dragable, 200, 200).build().perform();
		Thread.sleep(5000);
	}
	
	//@Test
	public void dragableTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[normalize-space()='Droppable']")).click();
		Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement dragableEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.dragAndDrop(dragableEle, targetEle).build().perform();
		
		Thread.sleep(5000);
	}
	
	@Test
	public void dragAndDropHardenTest() throws InterruptedException {
		
		driver.findElement(By.xpath("//a[normalize-space()='Droppable']")).click();
		Assert.assertEquals(driver.getTitle(), "Droppable | jQuery UI");
		
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement dragableEle = driver.findElement(By.id("draggable"));
		WebElement targetEle = driver.findElement(By.id("droppable"));
		
		Actions action = new Actions(driver);
		action.clickAndHold(dragableEle).moveToElement(targetEle).build().perform();
		
		Thread.sleep(5000);
	}
}
