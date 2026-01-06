package udemy;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {

	public WebDriver driver = null;
	
	@BeforeMethod
	public void openWebSite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		driver.get("https://edition.cnn.com/");
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}
	
	@Test
	public void findBrokenLinks() throws IOException {
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		
		System.out.println("Total number of links: " + allLinks.size());
		
		for(WebElement link: allLinks) {
			String URL = link.getAttribute("href");
			VerifyLinkStatus.verifyLink(URL);
		}
		
		System.out.println("Total number of invalid links: ");
		VerifyLinkStatus.getInvalidLinkCount();
	}
}
