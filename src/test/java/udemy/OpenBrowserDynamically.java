package udemy;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class OpenBrowserDynamically {

	public WebDriver driver = null;
	
	@Parameters("browser")
	
	@BeforeMethod
	public void OpenBrowser(String browser) {
		
		if(browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--start-maximized", "--disable-infobars");
			options.addArguments("--disable-extensions");
			
			// Use proxy
			/*
			Proxy proxy = new Proxy();
			proxy.setHttpProxy("proxy.example.com:8000");
			options.setCapability("proxy", proxy);
			*/
			
			// to open in incognito
			options.addArguments("--incognito");
			
			//to stop notification
			options.addArguments("--disable-notifications");
			
			// to disable certificate errors
			options.addArguments("ignore-certificate-errors");
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			FirefoxOptions options = new FirefoxOptions();
		}
		
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void QuitBrowser() {
		driver.quit();
	}
	
	@Test
	public void VerifyFBTitle() {
		
		driver.get("https://www.facebook.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Facebook – log in or sign up")) {
			System.out.println("Correct");
		}
		else {
			System.out.println("Incorrect");
		}
	}	
	

	@Test
	public void VerifyMVNTitle() {
		
		driver.get("https://mvnrepository.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Maven Repository: Search/Browse/Explore")) {
			System.out.println("Correct");
		}
		else {
			System.out.println("Incorrect");
		}
	}	
}
