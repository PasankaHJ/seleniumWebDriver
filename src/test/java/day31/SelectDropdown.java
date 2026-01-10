package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		WebElement drpCountryField = driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpCountry = new Select(drpCountryField);
		
		// Select option from the drop down
		// 1st Method - visible text
		drpCountry.selectByVisibleText("Canada");
		
		// 2nd Method - value
		drpCountry.selectByValue("germany");
		
		// 3rd Method - index
		drpCountry.selectByIndex(2); // United Kingdom
		
		// Total number of options
		List<WebElement> options = drpCountry.getOptions();
		System.out.println("Number of drop down options: " + options.size()); // Number of drop down options: 10
		
		// Print the options
		for(WebElement option: options) {
			System.out.println(option.getText());
		}
		
		
	}
}
