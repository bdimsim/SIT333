package web.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.JavascriptExecutor;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

public class RegistrationServiceFunctionalTest {
    private static WebDriver driver;

    private static WebElement fNameField;
    private static WebElement lNameField;
	private static WebElement emailField;
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

    @AfterAll
    public static void cleanup() {
        driver.close();
    }

	@BeforeAll
	public static void setup() throws Exception {
		new MyServer().start();
		driver = new ChromeDriver();
	}

    @BeforeEach
    public void cleanForm() {
        driver.navigate().to(
            "C://Users//Brand//Documents//Uni//CS//SIT333//code//task7_2D//pages//register.html"
        );

        sleep(1);

        fNameField = driver.findElement(By.id("fname"));
        lNameField = driver.findElement(By.id("lname"));
        emailField = driver.findElement(By.id("email"));
        passwordField = driver.findElement(By.id("passwd"));
        dobField = driver.findElement(By.id("dob"));
        submitButton = driver.findElement(By.cssSelector("[type=submit]"));

        fNameField.clear();
        lNameField.clear();
        emailField.clear();
        passwordField.clear();
        dobField.clear();
    }

    @Test
    public void testEmptyFirstNameFailure() {
        lNameField.sendKeys("dimoski");
        emailField.sendKeys("bdimoski@deakin.edu.au");
        passwordField.sendKeys("bdim_pass");
        sendDobKeys(dobField, "2002-02-03");

        submitButton.submit();

        sleep(1);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
		Assertions.assertEquals("fail", title);
    }

    @Test
    public void testEmptyLastNameFailure() {
        fNameField.sendKeys("brandon");
        emailField.sendKeys("bdimoski@deakin.edu.au");
        passwordField.sendKeys("bdim_pass");
        sendDobKeys(dobField, "2002-02-03");

        submitButton.submit();

        sleep(1);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assertions.assertEquals("fail", title);
    }

    @Test
    public void testEmptyEmailFailure() {
        fNameField.sendKeys("brandon");
        lNameField.sendKeys("dimoski");
        passwordField.sendKeys("bdim_pass");
        sendDobKeys(dobField, "2002-02-03");

        submitButton.submit();

        sleep(1);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assertions.assertEquals("fail", title);
    }

    @Test
    public void testEmptyPasswordFailure() {
        fNameField.sendKeys("brandon");
        lNameField.sendKeys("dimoski");
        emailField.sendKeys("bdimoski@deakin.edu.au");
        sendDobKeys(dobField, "2002-02-03");

        submitButton.submit();

        sleep(1);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assertions.assertEquals("fail", title);
    }

    @Test
    public void testEmptyDoBFailure() {
        fNameField.sendKeys("brandon");
        lNameField.sendKeys("dimoski");
        emailField.sendKeys("bdimoski@deakin.edu.au");
        passwordField.sendKeys("bdim_pass");

        submitButton.submit();

        sleep(1);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assertions.assertEquals("fail", title);
    }

    @Test
    public void testValidRegistrationSuccessul() {
        fNameField.sendKeys("brandon");
        lNameField.sendKeys("dimoski");
        emailField.sendKeys("bdimoski@deakin.edu.au");
        passwordField.sendKeys("bdim_pass");
        sendDobKeys(dobField, "2002-02-03");

        submitButton.submit();

        sleep(1);

        String title = driver.getTitle();
        System.out.println("Title: " + title);
        Assertions.assertEquals("success", title);
    }
}