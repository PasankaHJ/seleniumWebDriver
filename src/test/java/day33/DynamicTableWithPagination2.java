package day33;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableWithPagination2 {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		List<WebElement> Pages = driver.findElements(By.xpath("//ul[@class='pagination']//li"));
		int numberOfPages = Pages.size();
		System.out.println("Number of pages: "+numberOfPages);
		
		for(int i=1; i<=numberOfPages; i++) {
			if(i>1) {
				driver.findElement(By.xpath("//ul[@class='pagination']//li["+i+"]")).click();
				Thread.sleep(3000);
			}
			
			int dataRows = driver.findElements(By.xpath("//table[@id='productTable']//tbody//tr")).size();
			
			for(int j=1; j<=dataRows; j++) {
				String id = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[1]")).getText();
				String name = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+j+"]//td[2]")).getText();
				String price = driver.findElement(By.xpath("//table[@id='productTable']//tbody//tr["+i+"]//td[3]")).getText();
				System.out.println(id + " - " + name + " - " + price);
			}
		}
	}
}
