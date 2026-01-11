package day32;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class StaticTableHandling {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Total number of rows
		List<WebElement> rows = driver.findElements(By.xpath("//table[@name='BookTable']//tr"));
		
		System.out.println("Total number of rows in the Static table: "+ rows.size()); // 7
		
		// Total number of columns in a table
		List<WebElement> columns = driver.findElements(By.xpath("//table[@name='BookTable']//th"));
		
		System.out.println("Total number of columns in the Static table: "+ columns.size()); // 4
		
		// Read data from a specific row and column (5th row & 1st column)
		String val = driver.findElement(By.xpath("//table[@name='BookTable']//tr[5]//td[1]")).getText();
		System.out.println("Value of the cell in 5th row and 1st column: " + val);
		
		// Read data from all the rows and columns
		for(int i=2; i<= rows.size(); i++) {
			for(int j=1; j<= columns.size(); j++) {
				/*
				String xpathText =  "//table[@name='BookTable']//tr["+i+"]//td["+j+"]";
				String cellVal = driver.findElement(By.xpath(xpathText)).getText();
				*/
				String cellVal = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+i+"]//td["+j+"]")).getText();
				System.out.println("Value of row #"+i+" and column #"+j+": "+cellVal);
			}
		}
		
		// Print book names whose author is Mukesh
		for(int r = 2; r<=rows.size(); r++) {
			
			if(driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[2]")).getText().equals("Mukesh")) {
				String bookName = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[1]")).getText();
				System.out.println(bookName+" - auther is Mukesh.");
				continue;
			}
			else {
				continue;
			}
		}
		
		// Find total price of all the books
		int totalPrice = 0;
		for(int r = 2; r<=rows.size(); r++) {
			String price = driver.findElement(By.xpath("//table[@name='BookTable']//tr["+r+"]//td[4]")).getText();
			totalPrice = totalPrice + Integer.parseInt(price);
		}
		System.out.println("Total price is: " + totalPrice);
	}
}
