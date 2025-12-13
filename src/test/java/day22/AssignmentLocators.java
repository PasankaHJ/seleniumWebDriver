package day22;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AssignmentLocators {

	public static void main(String[] args) {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://demoblaze.com/");
		driver.manage().window().maximize();
		
		
		System.out.println(driver.findElements(By.tagName("img")).size());
	}

}
