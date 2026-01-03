package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class HardCodeWaits {

	@Test
	public void googleSearchTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.xpath("//*[@title=\"Search\"]"));
				
		searchBox.sendKeys("selenium webdriver");
		
		Thread.sleep(4000);
		
		//to click 6th search result
		WebElement searchResults = driver.findElement(By.xpath("//li[@role='presentation'][6]"));
		searchResults.click();
	
		driver.quit();
		
	}
}
