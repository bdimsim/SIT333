package sit333_week2;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.By;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver; // WebDriver interface
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver; // Specific implementation of WebDriver for Chrome

public class SeleniumOperations {
	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void findElementByIdSendKeys(WebDriver driver, String id, String input) {
		WebElement element = driver.findElement(By.id(id));
		System.out.println("Found element: " + element);
		element.sendKeys(input);
	}

	public static void takeScreenshot(WebDriver driver, String fileName) {
		try {
			File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			File destination = new File(fileName);
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void officeworks_registration_page(String url) {
		// Open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver(); // Upcast chromedriver class to webdriver interface
		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load a webpage in chromium browser.
		driver.get(url);

		// Send first name
		findElementByIdSendKeys(driver, "firstname", "Brandon");
		// Send last name
		findElementByIdSendKeys(driver, "lastname", "Dimoski");
		// Send phone no.
		findElementByIdSendKeys(driver, "phoneNumber", "0449064318");
		// Send email
		findElementByIdSendKeys(driver, "email", "bdimoski@deakin.edu.au");
		// Send password
		findElementByIdSendKeys(driver, "password", "Task2.1PBrandon");
		// NOTE: Confirmation password is blank

		// Identify button 'Create account' and click to submit using Selenium API.
		WebElement element = driver.findElement(By.cssSelector("[data-testid='account-action-btn']"));

		try {
			System.out.println("Submit is enabled: " + element.isEnabled());
			element.click();
		} catch (WebDriverException e) { // <-- exceptions wrapped by WebDriverException 
			System.out.println("Caught exception: " + e.getClass().getName()); // Get further information
			//e.printStackTrace();
		}

		sleep(2); // Let the submission process

		// Take screenshot using selenium API.
		takeScreenshot(driver, "task2_1P/screenshots/officeworks-registration-screenshot.png");

		// Sleep a while
		sleep(2);

		// close chrome driver
		driver.close();
	}

	public static void culturekings_registration_page(String url) {
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();
		System.out.println("driver info: " + driver);

		sleep(2);

		driver.get(url);

		// Send first name
		findElementByIdSendKeys(driver, "first-name", "Brandon");
		// Send last name
		findElementByIdSendKeys(driver, "last-name", "Dimoski");
		// Send email
		findElementByIdSendKeys(driver, "email", "bdimoski@deakin.edu.au");
		// NOTE: Password is blank

		sleep(2);

		// Tag.class[attribute='']
		WebElement element = driver.findElement(By.cssSelector("button.btn[type='submit']"));
		// Below Fails because of multiple btn classes
		// WebElement element = driver.findElement(By.className("btn"));

		try {
			System.out.println("Submit is enabled: " + element.isEnabled());
			element.click();
		} catch (WebDriverException e) {
			System.out.println("Caught exception: " + e.getClass().getName());
			//e.printStackTrace();
		}
		
		sleep(2); // Let the submission process

		// Take screenshot using selenium API.
		takeScreenshot(driver, "task2_1P/screenshots/culturekings-registration-screenshot.png");

		// Sleep a while
		sleep(2);

		// close chrome driver
		driver.close();
	}
}