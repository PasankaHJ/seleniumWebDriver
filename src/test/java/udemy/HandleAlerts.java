package udemy;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleAlerts {
	WebDriver driver = null;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.rediff.com/");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void handleAlertsTest() {
		Assert.assertEquals(driver.getTitle(), "Rediff.com: News | Rediffmail | Stock Quotes | Rediff Gurus");
		
		driver.findElement(By.xpath("//*[@class='signin']")).click();
		
		driver.findElement(By.xpath("(//input[@id='login1'])[1]")).sendKeys("test");
		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
		
		Alert alert1 = driver.switchTo().alert();
		Assert.assertEquals(alert1.getText(), "Please enter your password") ;
		
		alert1.accept();
		
		driver.findElement(By.xpath("(//input[@id='login1'])[1]")).clear();
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("test@123");
		driver.findElement(By.xpath("//button[normalize-space()='Log In']")).click();
		
		Alert alert2 = driver.switchTo().alert();
		Assert.assertEquals(alert2.getText(), "Please enter a valid user name") ;
		
		alert2.accept();
	}
}
