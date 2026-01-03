package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		// Normal alert
		/*driver.findElement(By.xpath("//button[@id='alertBtn']")).click();
		Thread.sleep(5000);
		//Need to switch to the alert
		
		//driver.switchTo().alert().accept();
		
		// Or
		
		Alert myAlt = driver.switchTo().alert();
		System.out.println(myAlt.getText());
		myAlt.accept();*/
		
		// Confirmation Alert
		/*
		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().dismiss(); // Cancel button
		
		Thread.sleep(5000);
		
		driver.findElement(By.xpath("//button[@id='confirmBtn']")).click();
		Thread.sleep(5000);
		driver.switchTo().alert().accept(); // OK button
		*/
		
		// Prompt Alert
		driver.findElement(By.xpath("//button[@id='promptBtn']")).click();
		Thread.sleep(5000);
		
		Alert pAlert = driver.switchTo().alert();
		pAlert.sendKeys("ABC");
		Thread.sleep(5000);
		
		pAlert.accept();
		
		String confirmationMsg = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(confirmationMsg.equals("Hello ABC! How are you today?")) {
			System.out.println("Success");
		}
		else {
			System.out.println("Fail");
		}
	}
}
