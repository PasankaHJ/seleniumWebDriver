package udemy;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExplicitWaitDemo {

	public WebDriver driver = null;
	
	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("file:///C:/Users/Pasanka%20Jayawardena/OneDrive%20-%20Xeynergy/Desktop/My%20Files/Selenium/ExplicitWait.html");
	}
	
	@AfterMethod
	public void finish() {
		driver.quit();
	}
	
	@Test
	public void verifyAlert() {
		WebElement alertBtn = driver.findElement(By.id("alert"));
		alertBtn.click();
		
		//Explicit Wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.alertIsPresent());
		
		// Accept the alert
		driver.switchTo().alert().accept();
	}
	
	@Test
	public void verifyTestPresent() {
		WebElement txt = driver.findElement(By.xpath("//*[@class='target-text']"));
		
		WebElement textChangeBtn = driver.findElement(By.id("populate-text"));
		textChangeBtn.click();
		
		//Explicit wait
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.textToBePresentInElement(txt, "Selenium Webdriver"));
	}	
	
	@Test
	public void verifyButtonAvailable() {
		WebElement displayOtherBtn = driver.findElement(By.id("display-other-button"));
		displayOtherBtn.click();
		
		WebElement hiddenBtn = driver.findElement(By.id("hidden"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(hiddenBtn));
	}
	
	public void verifyEnableBtn() {
		WebElement BtnEnable = driver.findElement(By.id("enable-button"));
		BtnEnable.click();
		
		WebElement enableBtn = driver.findElement(By.id("disable"));
				
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeClickable(enableBtn));
	}
	
	@Test
	public void verifyElementSelectedTest() {
		
		WebElement btnForCheckBox = driver.findElement(By.id("checkbox"));
		btnForCheckBox.click();
		
		WebElement checkBox = driver.findElement(By.xpath("//*[@type='checkbox']"));
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMinutes(1));
		wait.until(ExpectedConditions.elementToBeSelected(checkBox));
	}
}
