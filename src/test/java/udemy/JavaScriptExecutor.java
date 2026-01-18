package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JavaScriptExecutor {
	WebDriver driver = null;
	WebDriverWait wait;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void handleJSTest() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeScript("window.location='https://www.rediff.com/'");
		
		// Verify the page title
		String pageTitle = (String) js.executeScript("return document.title");
		
		Assert.assertEquals(pageTitle, "Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");
		
		// Navigate to another page
		WebElement moneyBtn = driver.findElement(By.xpath("//a[@class='linkcolor bold'][normalize-space()='Money']"));
		js.executeScript("arguments[0].click();", moneyBtn);
		
		Thread.sleep(5000);
		
		// Scroll webpage up to coordinate
		js.executeScript("window.scrollBy(0,1000)");
		
		Thread.sleep(5000);
		
		// Scroll to web element
		WebElement bottomEle = driver.findElement(By.xpath("//a[normalize-space()='Privacy Policy']"));
		js.executeScript("arguments[0].scrollIntoView(true)", bottomEle);
		
		Thread.sleep(5000);
	}
}
