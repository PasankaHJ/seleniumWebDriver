package day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBoostrapTable {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//ul[@class='oxd-main-menu']//span[text()='Admin']")).click();
		
		List<WebElement> Rows = driver.findElements(By.xpath("//div[@role='table']//div[@class='oxd-table-body']//div[@role='row']"));
		System.out.println("Number of data rows: " + Rows.size());
		
		for(int i=1; i<= Rows.size(); i++) {
			String username = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+i+"]//div[2]")).getText();
			String userRole = driver.findElement(By.xpath("//div[@role='table']//div[@class='oxd-table-body']//div[@class='oxd-table-card']["+i+"]//div[3]")).getText();
			
			System.out.println(username + " - " + userRole);
		}
	}
}
