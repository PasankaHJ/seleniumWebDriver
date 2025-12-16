package day28;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CloseSpecificBrowserWindow {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		// Capture both browser windows
		Set <String> windowIds = driver.getWindowHandles();
		
		for(String winId: windowIds) {
			String title = driver.switchTo().window(winId).getTitle();
			System.out.println(title);
			
			if(title.equals("OrangeHRM") || title.equals("Human Resources Management Software | HRMS | OrangeHRM")) {
				driver.close();
			}
		}
	}
}
