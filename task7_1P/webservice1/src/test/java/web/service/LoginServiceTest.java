package web.service;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

// Functional tests for login using selenium. 
// Also need a unit test class to test the login service logic without using Selenium.
public class LoginServiceTest {
	private static WebDriver driver;
	private static WebElement usernameField;
	private static WebElement passwordField;
	private static WebElement dobField;
	private static WebElement submitButton;

	private static void sleep(long sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void sendDobKeys(WebElement dobField, String dob) {
		((JavascriptExecutor) driver)
			.executeScript(
				"arguments[0].value = arguments[1]", dobField, dob
			);
	}

	@BeforeAll
	public static void setup() throws Exception{
		new web.MyServer().start();

		driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);
	}

	@BeforeEach
	public void readyFormState() {
		driver.navigate().to(
			"file:///C:/Users/Brand/Documents/Uni/CS/SIT333/code/task7_1P/pages/login.html"
		);

		sleep(1);

		usernameField = driver.findElement(By.id("username"));
		passwordField = driver.findElement(By.id("passwd"));
		dobField = driver.findElement(By.id("dob"));
		submitButton = driver.findElement(By.cssSelector("[type=submit]"));

		usernameField.clear();
		passwordField.clear();
		dobField.clear();
	}

	@AfterAll
	public static void cleanup() {
		driver.close();
	}

	@Test
	public void testLoginSuccess() {
		usernameField.sendKeys("bdim");
		passwordField.sendKeys("bdim_pass");
		sendDobKeys(dobField, "2002-02-03");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals("success", title);
	}

	@Test
	public void testEmptyUsernameLoginFailure() {
		passwordField.sendKeys("bdim_pass");
		sendDobKeys(dobField, "2002-02-03");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals("fail", title);
	}

	@Test
	public void testEmptyPasswordLoginFailure() {
		usernameField.sendKeys("bdim");
		sendDobKeys(dobField, "2002-02-03");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals("fail", title);
	}

	@Test
	public void testEmptyDobLoginFailure() {
		usernameField.sendKeys("bdim");
		passwordField.sendKeys("bdim_pass");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals("fail", title);
	}

	@Test
	public void testInvalidDobRangeLoginFailure() {
		usernameField.sendKeys("bdim"); 
		passwordField.sendKeys("bdim_pass");
		sendDobKeys(dobField, "2002-02-29");
		submitButton.submit();
	
		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals("fail", title);
	}

	@Test
	public void testInvalidDobFormatLoginFailure() {
		usernameField.sendKeys("bdim"); 
		passwordField.sendKeys("bdim_pass");
		sendDobKeys(dobField, "abc");;
		submitButton.submit();
	
		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals("fail", title);
	}
}