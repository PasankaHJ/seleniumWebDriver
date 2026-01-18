	package udemy;
	
	import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
	
	public class WebTableHandling {
		WebDriver driver = null;
		WebDriverWait wait;
	
		@BeforeMethod
		public void openWebsite() {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://money.rediff.com/companies/most-traded?src=moneyhome_mosttraded_more");
		}
	
		@AfterMethod
		public void closeBrowser() {
			driver.quit();
		}
		
		@Test
		public void webTablehandlingTest() {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

	        // Validate navigation
	        wait.until(ExpectedConditions.titleContains("Most traded companies"));
	        Assert.assertEquals(
	                driver.getTitle(),
	                "Indian stock markets: Most traded companies - By volumes"
	        );

	        // Table headers
	        List<WebElement> headings =
	                driver.findElements(By.xpath("//*[@class='dataTable']//thead//th"));
	        System.out.println("Number of columns: " + headings.size());

	        // Table rows
	        List<WebElement> dataRows =
	                driver.findElements(By.xpath("//*[@class='dataTable']//tbody//tr"));
	        System.out.println("Number of rows: " + dataRows.size());

	        Assert.assertTrue(headings.size() > 0);
	        Assert.assertTrue(dataRows.size() > 0);
	        
	        //Print data in the 5th row
	        /*
	        System.out.println("Data in the 5th row: ");
	        for(int i=1; i<= headings.size();i++) {
	        	WebElement heading = driver.findElement(By.xpath("//*[@class='dataTable']//thead//th["+i+"]"));
	        	WebElement cell = driver.findElement(By.xpath("//*[@class='dataTable']//tbody//tr[5]//td["+i+"]"));
	        	System.out.println(heading.getText() +" - "+ cell.getText());
	        }
	        */
	        
	        //Print data in the all rows
	        for(int i=1; i<= dataRows.size();i++) {
	        	for(int j=1; j<= headings.size();j++) {
	        		WebElement heading = driver.findElement(By.xpath("//*[@class='dataTable']//thead//th["+j+"]"));
		        	WebElement cell = driver.findElement(By.xpath("//*[@class='dataTable']//tbody//tr["+i+"]//td["+j+"]"));
		        	System.out.println(heading.getText() +" - "+ cell.getText());
	        	}
	        }
		}
	}
