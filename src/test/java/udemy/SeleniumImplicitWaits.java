package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class SeleniumImplicitWaits {
	@Test
	public void googleSearchTest() throws InterruptedException {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		//Implicit wait declaration
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://www.google.com/");
		WebElement searchBox = driver.findElement(By.xpath("//*[@title=\"Search\"]"));
				
		searchBox.sendKeys("selenium webdriver");
		
		//to click 6th search result
		WebElement searchResults = driver.findElement(By.xpath("//li[@role='presentation'][6]"));
		searchResults.click();
	
		driver.quit();
		
	}
}
