package udemy;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PageLoadTimeOut {
	
	@Test
	public void pageLoadTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Page load time
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(100));
		driver.manage().timeouts().scriptTimeout(Duration.ofMinutes(2));
		
		driver.get("https://edition.cnn.com/");
		
		Assert.assertEquals(driver.getTitle(), "Breaking News, Latest News and Videos | CNN");
		
		driver.quit();
	}	
}
