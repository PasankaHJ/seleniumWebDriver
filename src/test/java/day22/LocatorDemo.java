package day22;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorDemo {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		//driver.get("https://demo.opencart.com/");
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		// Name locator
		//boolean status = driver.findElement(By.name("username")).isDisplayed();
		//System.out.println(status);
		
		// Id
		//boolean logoDisplayStatus = driver.findElement(By.id("[value of the id]")).isDisplayed();
		//System.out.println(logoDisplayStatus);
		
		// LinkedText
		//driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		//driver.findElement(By.partialLinkText("OrangeHRM")).click();
		
		// className
		//List<WebElement> headerLinks = driver.findElements(By.className("list-inline-item"));
		//System.out.println(headerLinks.size());
		
		//tagname
		List<WebElement> links = driver.findElements(By.tagName("img"));
		System.out.println(links.size());
	}
}
