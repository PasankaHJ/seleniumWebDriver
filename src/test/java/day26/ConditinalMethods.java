package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditinalMethods {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/register");
		
		// isDisplayed()
		Boolean result1 = driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		System.out.println("Display status: " + result1); // Display status: true
		
		// isEnabled() 
		Boolean result2 = driver.findElement(By.xpath("//button[normalize-space()='Search']")).isDisplayed();
		System.out.println("Search button is enabled: " + result2); // Search button is enabled: true
		
		// isSelected()
		WebElement male_radioBtn = driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_radioBtn = driver.findElement(By.xpath("//input[@id='gender-female']"));
		
		System.out.println("Before selecting radio buttons: " + male_radioBtn.isSelected()); // Before selecting radio buttons: false
		System.out.println("Before selecting radio buttons: " + female_radioBtn.isSelected()); // Before selecting radio buttons: false
		
	    System.out.println("After selecting male...");	
	    
	    male_radioBtn.click();
	    
	    System.out.println("After selecting male radio button: " + male_radioBtn.isSelected()); // After selecting male radio button: true
		System.out.println("After selecting male radio button: " + female_radioBtn.isSelected()); // After selecting male radio button: false
		
		System.out.println("After selecting female...");
		
		female_radioBtn.click();
		
		System.out.println("After selecting female radio button: " + male_radioBtn.isSelected()); // After selecting female radio button: false
		System.out.println("After selecting female radio button: " + female_radioBtn.isSelected()); // After selecting female radio button: true
		
		System.out.println("Newsletter checkbox is selected by default: " + driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected()); // Newsletter checkbox is selected by default: true
		driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).click();
		System.out.println("Newsletter checkbox after unselect: " + driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected()); // Newsletter checkbox after unselect: false
		
	    driver.close();
	}
}
