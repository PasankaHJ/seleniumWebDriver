package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class HandleBrowserWindows {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		// Capture both browser windows
		Set <String> windowIds = driver.getWindowHandles();
		
		// Approach 1
		List <String> windowList = new ArrayList(windowIds);
		String parentId = windowList.get(0);
		String childId = windowList.get(1);
		
		System.out.println(driver.getTitle()); // Parent browser window title
		
		//switch to child window
		driver.switchTo().window(childId);
		System.out.println(driver.getTitle()); // Child browser window title
		
		//switch to parent window
		driver.switchTo().window(parentId);
		System.out.println(driver.getTitle()); // Parent browser window title
		
		// Approach 2 - More number of browser windows
		for(String windId: windowIds) {
			String title = driver.switchTo().window(windId).getTitle();
			
			if(title.equals("OrangeHRM")) {
				System.out.println(driver.getCurrentUrl());
			}
		}
	}
}
