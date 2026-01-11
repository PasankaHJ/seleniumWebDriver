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

public class HandleRadioButtons {
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
	
	@Test
	public void handleRadioBtns() {
		driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
		List<WebElement> radioBtns = driver.findElements(By.xpath("//span[@data-type='radio']//input[@name='sex']"));
		System.out.println("Radio button count: " + radioBtns.size());
		
		for(WebElement button : radioBtns) {
			System.out.println("Is radio button selected: "+button.isSelected());
		}
		
		radioBtns.get(1).click();
		
		for(WebElement button : radioBtns) {
			System.out.println("Is radio button selected: "+button.isSelected());
		}
	}
}
