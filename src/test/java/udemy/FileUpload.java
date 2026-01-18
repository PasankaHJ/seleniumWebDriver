package udemy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FileUpload {
	
	WebDriver driver = null;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void uploadFileTest() throws InterruptedException {
		Assert.assertEquals(driver.getTitle(), "The Internet");
		
		WebElement fileUploadBtn = driver.findElement(By.xpath("//input[@id='file-upload']"));
		
		String fileName = "C:/Users/Pasanka Jayawardena/OneDrive - Xeynergy/Desktop/Projects/WrapMe/Data/blue baby hamper.jpg";
		
		fileUploadBtn.sendKeys(fileName);
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//input[@id='file-submit']")).click();
		
		
		boolean result = driver.findElement(By.xpath("//h3[normalize-space()='File Uploaded!']")).isDisplayed();
		System.out.println(result);
		Thread.sleep(5000);
	}
}
