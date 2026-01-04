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

public class ExtractTextFromWebElement {

	WebDriver driver = null;
	
	@BeforeMethod
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("https://www.facebook.com/");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void extractTextFromWebPage() {
		// Extract text from heading
		WebElement heading = driver.findElement(By.className("_8eso"));
		Assert.assertEquals(heading.getText(), "Facebook helps you connect and share with the people in your life.");
		
		// Extract text from link
		WebElement linkText = driver.findElement(By.className("_8esh"));
		Assert.assertEquals(linkText.getText(), "Create a Page");
		
		// Extract text from placeholder
		WebElement placeholderText = driver.findElement(By.id("pass"));
		Assert.assertEquals(placeholderText.getAttribute("aria-label"), "Password");	
	}
}
