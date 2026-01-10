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

public class VerifyElementEnable {
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
	public void VerifyElementIsEnabled() {
		driver.findElement(By.xpath("//a[normalize-space()='Spinner']")).click();
		Assert.assertEquals(driver.getTitle(), "Spinner | jQuery UI");
		
		WebElement iFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iFrame);
		Assert.assertTrue(driver.findElement(By.id("spinner")).isEnabled());
		
		WebElement disableBtn = driver.findElement(By.id("disable"));
		disableBtn.click();
		
		Assert.assertFalse(driver.findElement(By.id("spinner")).isEnabled());
		
		disableBtn.click();
		Assert.assertTrue(driver.findElement(By.id("spinner")).isEnabled());
		
		driver.switchTo().parentFrame();
	}
}
