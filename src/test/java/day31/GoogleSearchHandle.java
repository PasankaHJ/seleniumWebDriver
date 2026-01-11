package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchHandle {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium");
		
		List<WebElement> options = driver.findElements(By.xpath("//ul[@role='listbox']//div[@class='wM6W7d']"));
		
		System.out.println("Number of options: " + options.size());
		
		for(WebElement op : options) {
			if(op.getText().equals("selenium")) {
				op.click();
				break;
			}	
		}
	}
}
