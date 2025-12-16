package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		
		// get (URL) - opens the URL on the browser 
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		// getTitle() - returns the title of the page
		System.out.println("Title: " + driver.getTitle());
		
		// getCurrentUrl() - returns URL of the page 
		System.out.println("URL of the page: " + driver.getCurrentUrl());
		
		// getPageSource() - returns source code of the page
		System.out.println("Source code of the page: " + driver.getPageSource());
		
		// getWindowHandle() - returns ID of the single Browser window
		System.out.println("ID of the single Browser window: " + driver.getWindowHandle());
		
		// getWindowHandles() - returns IDs of the multiple Browser windows
		driver.findElement(By.linkText("OrangeHRM, Inc")).click();
		
		Set<String> windowIds = driver.getWindowHandles();
		System.out.println(windowIds);
		
		// Using the window Id we can switch between the browser windows
		
		// To close the window
		//driver.close(); // Only one browser window will be closed
		driver.quit(); // Close all the browser windows
	}
}
