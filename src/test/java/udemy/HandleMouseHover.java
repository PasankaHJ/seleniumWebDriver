package udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleMouseHover {
	WebDriver driver = null;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.americangolf.co.uk/en/");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void handleMouseHoverActions() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "American Golf SALE Now on up to 50% off");
		
		List<WebElement> menus = driver.findElements(By.xpath("//*[@class='ag_menu group relative']"));
		
		int counter = 0;
		for(WebElement link: menus) {
			System.out.println(counter + " - " + link.getText());
			counter++;
		}
		
		WebElement clubs = menus.get(2);
		//WebElement clothing = menus.get(3);
		
		Actions action = new Actions(driver);
		action.moveToElement(clubs).build().perform();
		
		driver.findElement(By.xpath("//a[normalize-space()='Ladies Drivers']")).click();
		
		Assert.assertEquals(driver.getTitle(), "Ladies Golf Drivers | Women's Drivers | American Golf");
	}
}
