package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleiFrames {
	public WebDriver driver = null;
	
	@BeforeMethod
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("https://jqueryui.com/");
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}
	
	@Test
	public void handleiFrames() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "jQuery UI");
		
		driver.findElement(By.xpath("//a[normalize-space()='Controlgroup']")).click();
		Assert.assertEquals(driver.getTitle(), "Controlgroup | jQuery UI");
		
		WebElement iFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iFrame);
		
		driver.findElement(By.xpath("//label[@for='transmission-standard']//span[@class='ui-checkboxradio-icon ui-corner-all ui-icon ui-icon-background ui-icon-blank']")).click();
		Thread.sleep(3000);
		
		driver.switchTo().parentFrame();
		Assert.assertEquals(driver.getTitle(), "Controlgroup | jQuery UI");
	}
}
