package udemy;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleMultipleTabs {

	WebDriver driver = null;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	//@Test
	public void getWindowIDTest() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test1@gmail.com");
		Thread.sleep(3000);
		String mainPageID = driver.getWindowHandle();
		System.out.println("Main page Id: " + mainPageID);
		
		// Click link which open in the same browser
		driver.findElement(By.linkText("Forgotten password?")).click();
		driver.findElement(By.xpath("//input[@id='identify_email']")).sendKeys("test2@gmail.com");
		Thread.sleep(3000);
		String forgotPWPageID = driver.getWindowHandle();
		System.out.println("Forgot password page Id: " + forgotPWPageID);
	}
	
	@Test
	public void multipleWindowHandle() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("test1@gmail.com");
		Thread.sleep(3000);
		
		String mainPageID = driver.getWindowHandle();
		System.out.println("Main page Id: " + mainPageID);
		
		// Click a link which opens in another tab
		driver.findElement(By.linkText("Meta Pay")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		Iterator<String> itr = windowIds.iterator();
		
		String homePageId = itr.next();
		System.out.println("homePageId: " + homePageId);
		String metaPayPageId = itr.next();
		System.out.println("metaPayPageId: " + metaPayPageId);
		
		driver.switchTo().window(metaPayPageId);
		
		System.out.println("Title: "+ driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Meta Pay | Meta");
		
		driver.close();
		driver.switchTo().window(homePageId); // Must switch the window
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
	}
}
