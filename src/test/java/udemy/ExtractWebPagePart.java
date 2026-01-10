package udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExtractWebPagePart {
	public WebDriver driver = null;

	@BeforeMethod
	public void openApplication() {
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
	public void extractPart() {
		WebElement topStories = driver.findElement(By.xpath(
				"//*[@class='container container_lead-plus-headlines  lazy' and @data-collapsed-text='More top stories']"));
		Assert.assertTrue(topStories.isDisplayed());
		System.out.println("Is top stories available: " + topStories.isDisplayed());
		
		// Identify links in the specific part
		List<WebElement> topStoryURL = topStories.findElements(By.tagName("a"));
		System.out.println("Number of top stories: " + topStoryURL.size());
		
		for(WebElement URL: topStoryURL) {
			if(!URL.getText().isEmpty()) {
				System.out.println(URL.getText());
			}
		}
	}
}
