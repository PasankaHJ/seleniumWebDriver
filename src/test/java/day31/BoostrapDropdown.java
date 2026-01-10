package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BoostrapDropdown {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("");
		
		// 1. open the drop down
		driver.findElement(null).click();
		
		// 2. select single option
		driver.findElement(null).click();
		
		// 3. select all the options ad find out size
		List <WebElement> options = driver.findElements(null);
		System.out.println("Number of options: "+ options.size());
		
		// 4. Print options
		for(WebElement op: options) {
			System.out.println(op.getText());
		}
		
		// 5. Select multiple options
		for(WebElement op: options) {
			if(op.getText().equals("Java") || op.getText().equals("Python") || op.getText().equals("MySQL")) {
				op.click();
			}
		}
	}
}
