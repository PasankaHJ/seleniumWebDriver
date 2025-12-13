package day21;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
1) Launch browser (chrome)
2) Open URL https://demo.nopcommerce.com/
3) Validate title should be "Your Store"
4) Close browser
*/

public class FirstTestCase {

	public static void main(String[] args) {
		// 1) Launch browser (chrome)
		//ChromeDriver driver = new ChromeDriver();
		WebDriver driver = new ChromeDriver(); // Best way
		
		// 2) Open URL https://demo.nopcommerce.com/
		driver.get("https://demo.nopcommerce.com/");
		
		// 3) Validate title should be "nopCommerce demo store"
		String act_title = driver.getTitle();
		if(act_title.equals("Your Store")) {
			System.out.println("Test Passed");
		}
		else {
			System.out.println("Test Failed");
		}
		
		// 4) Close browser 
		//driver.close();
		driver.quit();
	}
}
