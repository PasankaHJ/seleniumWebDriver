package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicTableWithPagination {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://demo3x.opencartreports.com/admin/");
		driver.findElement(By.xpath("//input[@id='input-username']")).sendKeys("demo");
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("demo");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		driver.findElement(By.xpath("//a[@class='parent collapsed'][normalize-space()='Customers']")).click();
		driver.findElement(By.xpath("(//a[contains(text(),'Customers')])[2]")).click();
		
		String fullPaginationText = driver.findElement(By.xpath("(//div[@class='col-sm-6 text-right'])[1]")).getText();
		System.out.println(fullPaginationText);
		int indexOfFirstDigit = fullPaginationText.indexOf('(')+1;
		int indexOfPages = fullPaginationText.indexOf("Pages")-1;
		
		String pageCountText = fullPaginationText.substring(indexOfFirstDigit, indexOfPages);
		System.out.println(pageCountText);
		
		int numberOfPages = Integer.parseInt(pageCountText);
		
		for(int p=1; p<=numberOfPages; p++) {
			if(numberOfPages > 1) {
				WebElement activePage = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()="+p+"]"));
				activePage.click();
				Thread.sleep(3000);
			}
			
			int numberOfDataRows = driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr")).size();
			
			for(int i=1; i<=numberOfDataRows; i++) {
				System.out.println(driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]//td[2]")).getText() +" - "+ driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tbody//tr["+i+"]//td[3]")).getText());
			}
		}
	}
}
