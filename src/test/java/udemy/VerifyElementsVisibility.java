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

public class VerifyElementsVisibility {
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
	public void verifyElementAvailability() {
		Assert.assertEquals(driver.getTitle(), "jQuery UI");

		driver.findElement(By.xpath("//a[normalize-space()='Show']")).click();
		Assert.assertEquals(driver.getTitle(), "Show | jQuery UI");

		WebElement iFrame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(iFrame);

		driver.findElement(By.xpath("//button[@id='button']")).click();
		boolean result = driver.findElement(By.xpath("//*[@id=\"effect\"]")).isDisplayed();

		if (result == true) {
			System.out.println("Displayed");
		} else {
			System.out.println("Not displayed");
		}

		driver.switchTo().parentFrame();
	}
}
