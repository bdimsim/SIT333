package sit333_week4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver; // WebDriver interface
import org.openqa.selenium.chrome.ChromeDriver; // Specific implementation of WebDriver for Chrome
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BunningsLoginFormTest {
	private static final String URL = "https://www.bunnings.com.au/login";

	private static WebDriver driver;
	private static WebDriverWait wait;
	private static WebElement emailField;
	private static WebElement passwordField;
	private static WebElement submitButton;
	private static boolean skipClearForm = false;

	@Test
	public void testStudentIdentity() {
		String studentId = "220250896";
		Assertions.assertNotNull("Student ID is null", studentId);
	}

	@Test
	public void testStudentName() {
		String studentName = "Brandon";
		Assertions.assertNotNull("Student name is null", studentName);
	}

	@BeforeAll
	public static void setup() {
		System.out.println("+++ setup +++");
		System.out.println("Opening chrome instance.");
		driver = new ChromeDriver();
		System.out.println("Driver info: " + driver);

		System.out.println("Loading Bunnings login page.");
		driver.get(URL);

		wait = new WebDriverWait(driver, Duration.ofSeconds(20));

		emailField = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("username"))
		);

		passwordField = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("password"))
		);
		
		submitButton = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("login-submit"))
		);
	}

	@AfterAll
	public static void cleanup() {
		System.out.println("+++ cleanup +++");
		System.out.println("Closing chrome instance.");
		driver.quit();
	}

	@AfterEach
	public void clearForm() {
		if (skipClearForm) return;

		emailField.clear();
		passwordField.clear();
	}

	// #####################################################################
	// #							Test Cases							   #
	// #####################################################################
	@Test
	public void testEmptyEmailEmptyPassword_BothFieldsRequired() {
		emailField.sendKeys("");
		passwordField.sendKeys("");
		submitButton.click();

		WebElement emailErrorMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("username-error-message"))
		);

		WebElement passwordErrorMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("password-error-message"))
		);

		Assertions.assertEquals("This field is required", emailErrorMsg.getText());
		Assertions.assertEquals("This field is required", passwordErrorMsg.getText());
	}

	@Test
	public void testEmptyEmailDontCarePassword_EmailFieldRequired() {
		emailField.sendKeys("");
		passwordField.sendKeys("dontcarepassword");
		submitButton.click();

		WebElement emailErrorMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("username-error-message"))
		);

		Assertions.assertEquals("This field is required", emailErrorMsg.getText());
	}

	@Test
	public void testDontCareEmailEmptyPassword_PasswordFieldRequired() {
		emailField.sendKeys("dontcare@email.com");
		passwordField.sendKeys("");
		submitButton.click();

		WebElement passwordErrorMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.id("password-error-message"))
		);

		Assertions.assertEquals("This field is required", passwordErrorMsg.getText());
	}

	@Test
	public void testDontCareEmailDontCarePassword_IncorrectEmailOrPassword() {
		emailField.sendKeys("dontcare@email.com");
		passwordField.sendKeys("dontcarepassword");
		submitButton.click();

		WebElement formErrorMsg = wait.until(
			ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[data-locator='form-error-alert'] div span"))
		);

		Assertions.assertEquals("Your email address or password is incorrect", formErrorMsg.getText());
	}

	// @Test
	// public void testCorrectEmailCorrectPassword_Login() {
	// 	skipClearForm = true;

	// 	final String CORRECT_EMAIL = "";
	// 	final String CORRECT_PASSWORD = "";
	// 	final String EXPECTED_URL = "https://www.bunnings.com.au/";

	// 	emailField.sendKeys(CORRECT_EMAIL);
	// 	passwordField.sendKeys(CORRECT_PASSWORD);
	// 	submitButton.click();
	// 	wait.until(ExpectedConditions.urlToBe(EXPECTED_URL));

	// 	String link = driver.getCurrentUrl();
	// 	Assertions.assertEquals("https://www.bunnings.com.au/", link);
	// }
}