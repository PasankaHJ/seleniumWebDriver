package udemy;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

public class FirstSeleniumProgram {

	@Test
	public void OpenSiteInIE() {
		// Set the path to the IE executable
		System.setProperty("webdriver.internetexplorer.driver", "C:\\Selenium\\seleniumwebdriver\\drivers\\IEDriverServer.exe");
		
		WebDriver driver = new InternetExplorerDriver();
		
		driver.get("https://www.facebook.com/");
		driver.manage().window().maximize();
		
		driver.quit();
	}
	
	/*@Test
	public void OpenSiteInFirefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\Selenium\\seleniumwebdriver\\drivers\\geckodriver.exe");
		
		WebDriver driver = new FirefoxDriver();
		
		//driver.manage().window().maximize();
		
		driver.get("https://www.cnn.com/");
		driver.quit();
	}
	*/
}
