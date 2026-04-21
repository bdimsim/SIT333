package web.service;

import org.openqa.selenium.By;
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

	@BeforeAll
	public static void setup() {
		driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		driver.navigate().to(
			"file:///C:/Users/Brand/Documents/Uni/CS/SIT333/code/task7_1P/pages/login.html"
		);

		sleep(3);

		usernameField = driver.findElement(By.id("username"));
		passwordField = driver.findElement(By.id("passwd"));
		dobField = driver.findElement(By.id("dob"));
		submitButton = driver.findElement(By.cssSelector("[type=submit]"));
	}

	@BeforeEach
	public static void clearForm() {
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
		dobField.sendKeys("2002-02-03");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals(title, "success");
	}

	@Test
	public void testEmptyUsernameLoginFailure() {
		passwordField.sendKeys("bdim_pass");
		dobField.sendKeys("2002-02-03");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals(title, "fail");
	}

	@Test
	public void testEmptyPasswordLoginFailure() {
		usernameField.sendKeys("bdim");
		dobField.sendKeys("2002-02-03");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals(title, "fail");
	}

	@Test
	public void testEmptyDobLoginFailure() {
		usernameField.sendKeys("bdim");
		passwordField.sendKeys("bdim_pass");
		submitButton.submit();

		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals(title, "fail");
	}

	@Test
	public void testInvalidDobRangeLoginFailure() {
		usernameField.sendKeys("bdim"); 
		passwordField.sendKeys("bdim_pass");
		dobField.sendKeys("2002-02-29");
		submitButton.submit();
	
		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals(title, "fail");
	}

	@Test
	public void testInvalidDobFormatLoginFailure() {
		usernameField.sendKeys("bdim"); 
		passwordField.sendKeys("bdim_pass");
		dobField.sendKeys("abc");
		submitButton.submit();
	
		sleep(1);

		String title = driver.getTitle();
		System.out.println("Title: " + title);
		Assertions.assertEquals(title, "fail");
	}
}