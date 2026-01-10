package udemy;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HandleDropDowns {

	WebDriver driver = null;
	
	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void handleMultiSelectDropDown() throws InterruptedException {
		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select_multiple");
		driver.switchTo().frame("iframeResult");
		
		WebElement dropDown = driver.findElement(By.id("cars"));
		Select multiSelect = new Select(dropDown);
		
		// Verify is drop down multi select
		Assert.assertTrue(multiSelect.isMultiple());
		
		// Select any element
		multiSelect.selectByValue("saab");
		Thread.sleep(5000);
		multiSelect.selectByValue("audi");
		
		// Verify selected options
		List <WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
		for(WebElement option : selectedOptions) {
			System.out.println("Selected Value: " + option.getText());
		}
		
		// De-select all
		multiSelect.deselectAll();
		
		// Select again
		multiSelect.selectByValue("opel");
		Thread.sleep(5000);
		multiSelect.selectByValue("volvo");
		Thread.sleep(5000);
		
		// Select first element
		String value = multiSelect.getFirstSelectedOption().getText();
		System.out.println("First selected text is: " + value);
		
		multiSelect.deselectByVisibleText("Audi");
	}
}
