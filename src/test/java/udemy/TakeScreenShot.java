package udemy;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TakeScreenShot {
	WebDriver driver = null;

	@BeforeMethod
	public void openWebsite() {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
	}

	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}

	@Test
	public void captureScreenShot() throws IOException {
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		takeScreenShot();
		
		driver.findElement(By.linkText("Privacy Policy")).click();
		
		WebElement widgets = driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div/div[2]/div/div/div[1]/div[1]/div/div/div[1]/div[1]/div[2]"));
		takeScreenshotOfSpecificArea(widgets);
		
	}

	// Capture screenshot function
	public void takeScreenShot() throws IOException {
		// String filePath = System.getProperty("user.dir") +
		// "/screenshots/screenshot.png";
		String filePath = System.getProperty("user.dir") + "/screenshots/" + generateFileName();
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		FileUtils.copyFile(screenshotFile, new File(filePath));
	}

	// To capture specific area of web page
	public void takeScreenshotOfSpecificArea(WebElement element) {
		// get entire page screenshot
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		BufferedImage fullImg;

		try {
			fullImg = ImageIO.read(screenshot);

			// Get the location of element on the page
			Point point = element.getLocation();

			// Get width and height of the element
			int eleWidth = element.getSize().getWidth();
			int eleHeight = element.getSize().getWidth();

			// Crop the entire page screenshot to get only element screenshot
			BufferedImage eleScreenshot = fullImg.getSubimage(point.getX(), point.getY(), eleWidth, eleHeight);
			ImageIO.write(eleScreenshot, "png", screenshot);

			// Copy the element screenshot to disk
			String filepath = System.getProperty("user.dir") + "/screenshots/" + generateFileName();
			FileUtils.copyFile(screenshot, new File(filepath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Generate screenshot name
	public String generateFileName() {
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM--dd_HH--mm--ss");
		String date = dateformat.format(new Date());

		String filename = date + ".png";

		return filename;
	}
}
