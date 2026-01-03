package day29;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {
		 WebDriver driver = new ChromeDriver();
		 
		 driver.get("https://testautomationpractice.blogspot.com/");
		 driver.manage().window().maximize();
		 
		 // Select a specific check box
		 //driver.findElement(By.xpath("//input[@id='sunday']")).click();

		 // Select all the check boxes
		 List<WebElement> checkboxes = driver.findElements(By.xpath("//*[@class=\"form-check-input\" and @type=\"checkbox\"]"));
		 
		 // for
		 /*for(int i=0; i<checkboxes.size();i++) {
			 checkboxes.get(i).click();
		 }*/
		 
		 // Using enhanced for loop - Preferable
		 /*for(WebElement checkbox:checkboxes) {
			 checkbox.click();
		 }*/
		 
		 // Select last three check boxes
		 /*for(int i=checkboxes.size()-3;i<checkboxes.size();i++) {
			 checkboxes.get(i).click();
		 }*/
		 
		 // Select first 3 check boxes
		 /*for(int j = 0; j<3; j++) {
			 checkboxes.get(j).click();		 
		 }*/
		 
		 // Un-select check boxes if they are selected
		 for(int j = 0; j<3; j++) {
			 checkboxes.get(j).click();		 
		 }
		 
		 Thread.sleep(5000);
		 
		 for(int i=0; i<checkboxes.size();i++) {
			 if(checkboxes.get(i).isSelected()) {
				 checkboxes.get(i).click();
			 }
		 }
	}
}
