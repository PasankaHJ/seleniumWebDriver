package udemy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class BrowserOptions {
	
	@Test
	public void ChromeBrowserProfiling() {
		ChromeOptions options = new ChromeOptions();
		
		//set binary - Setting chrome browser binary path
		//options.setBinary("");
		
		//Start Chrome maximize
		options.addArguments("--start-maximized");
		
		//Open specific profile
		// To get the path; open the profile and search "chrome://version"
		options.addArguments("--user-data-dir=C:\\Users\\Pasanka Jayawardena\\AppData\\Local\\Google\\Chrome\\User Data\\Profile 1");
		
		
		WebDriver driver = new ChromeDriver(options);
		
		driver.get("https://www.facebook.com/");
		
		String title = driver.getTitle();
		System.out.println(title);
		
		if(title.equals("Facebook – log in or sign up")) {
			System.out.println("Correct");
		}
		else {
			System.out.println("Incorrect");
		}
		
		driver.quit();
	}
	
	//public void FirefoxBrowserProfiling() {
	//	
	//}
}
