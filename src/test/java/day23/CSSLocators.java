package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// Tag id
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("T-shirts");
		// id - tag name is not required but # is required
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("T-shirts");
		
		// Tag class
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Laptop");
		//driver.findElement(By.cssSelector("button.button-1")).click(); // button-1 search-box-button - can remove the 2nd part
		//driver.findElement(By.cssSelector(".button-1")).click();
		
		// tag attribute
		//driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("Car");
		//driver.findElement(By.cssSelector("input[placeholder='Search store']")).sendKeys("Car");
		//driver.findElement(By.cssSelector("[placeholder='Search store']")).sendKeys("Car");
		
		// tag class attribute
		//driver.findElement(By.cssSelector("input.search-box-text[name='q']")).sendKeys("Phone");
		driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("Phone");
		
	}
}
