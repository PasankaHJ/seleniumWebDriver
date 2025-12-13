package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Xpaths {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		// xpath with single attribute
		//driver.findElement(By.xpath("//*[@id='small-searchterms']")).sendKeys("Laptop");
		//driver.findElement(By.xpath("//input[@placeholder='Search store']")).sendKeys("Test");
		
		// xpath with multiple attributes
		//driver.findElement(By.xpath("//input[@name='q'][@placeholder='Search store']")).sendKeys("Phone");
		
		// xpath with 'and' , 'or' operators
		//driver.findElement(By.xpath("//input[@name='q' and @placeholder='Search store']")).sendKeys("Phone");
		//driver.findElement(By.xpath("//input[@name='q' or @placeholder='Search store']")).sendKeys("Phone");
		
		// xpath with inner text
		//driver.findElement(By.xpath("//a[text()='Computers']")).click();
		
		boolean result = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
		System.out.println(result);
		
		String val = driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText();
		System.out.println(val);
		
		// xpath with contains()
		driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("Laptop");
		
		// xpath with startwith()
		driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sear')]")).sendKeys("Laptop");
				
		// chained xpath
		
	}
}
