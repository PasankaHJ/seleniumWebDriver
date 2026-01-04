package udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtractMultipleElements {

WebDriver driver = null;
	
	@BeforeMethod
	public void openApplication() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("https://edition.cnn.com/");
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void findNumberOfLinksOnWebPage() {
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Number of links: " + allLinks.size());
		
		// Extract text and URL of Specific Link
		WebElement sixthLink = allLinks.get(5);
		System.out.println("6th Link Text: " + sixthLink.getText());
		System.out.println("6th Link URL: " + sixthLink.getAttribute("href"));
		
		System.out.println("***************************************");
		
		// Extract text and URL of all Links
		for(WebElement link : allLinks) {
			System.out.println("Link text is: " + link.getText());
			System.out.println("Link URL is: " + link.getAttribute("href"));
		}
	}
}
