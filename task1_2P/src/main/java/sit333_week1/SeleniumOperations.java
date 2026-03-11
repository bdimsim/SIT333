package sit333_week1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 
import org.openqa.selenium.Dimension; // For window resizing

public class SeleniumOperations {

	public static void sleep(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void open_chrome_and_close() {
		// Open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		driver.close();

	}

	public static void open_chrome_maximize_close() {
		// Open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		// Maximize chrome driver
		driver.manage().window().maximize();

		sleep(5);

		// close chrome driver.
		driver.close();
	}

	public static void load_web_page_close() {
		// Open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(5);

		// Open the URL in chromium browser.
		driver.get("https://selenium.dev");

		sleep(5);

		// close chrome driver.
		driver.close();
	}

	public static void open_chrome_loadpage_resize_close() {
		System.out.println("Hello from 220250896, Brandon Dimoski");

		// Open up a chromium browser.
		System.out.println("Fire up chrome browser.");
		WebDriver driver = new ChromeDriver();

		System.out.println("Driver info: " + driver);

		sleep(2);

		// Load google page.
		driver.get("https://google.com");

		/*
		 * Set window size manually to 640x480 and wait 2 second.
		 * Hint: Explore Selenium window functions to select one which allows to pass
		 * window size in WxH.
		 */
		int x = 640;
		int y = 480;
		driver.manage().window().setSize(new Dimension(x, y));

		sleep(2);

		//Double window size manually to 1280x960 and wait 2 second.
		x *= 2;
		y *= 2;
		driver.manage().window().setSize(new Dimension(x, y));

		sleep(2);

		driver.close();
	}
}