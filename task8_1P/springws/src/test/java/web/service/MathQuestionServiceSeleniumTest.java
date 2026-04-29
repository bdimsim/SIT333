package web.service;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class MathQuestionServiceSeleniumTest {
    private static WebDriver driver;
    private static WebDriverWait wait;

    // Login form variables
    private static WebElement usernameField;
    private static WebElement passwordField;
    private static WebElement dobField;
    private static WebElement loginSubmitBtn;

    // Math question form variables
    private static WebElement num1Field;
    private static WebElement num2Field;
    private static WebElement usrResult;
    private static WebElement mathSubmitBtn;
    private static WebElement msgText;

    @BeforeAll
    public static void login() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(1));
    }

    @BeforeEach
    public void readyFormState() {
        driver.get("http://localhost:8080/login");

        usernameField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("username")
            )
        );

        passwordField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("passwd")
            )
        );
        
        dobField = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("dob")
            )
        );

        loginSubmitBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='submit'][value='Login']")
            )
        );

        usernameField.sendKeys("bdim");
        passwordField.sendKeys("bdim_pass");
        dobField.sendKeys("2002-02-03");
        loginSubmitBtn.click();


        num1Field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("number1")
            )
        );

        num2Field = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("number2")
            )
        );

        usrResult = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.id("result")
            )
        );

        mathSubmitBtn = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("[type='submit'][value='Submit']")
            )
        );

        num1Field.clear();
        num2Field.clear();
        usrResult.clear();
    }

    @AfterAll
    public static void cleanup() {
        driver.close();
    }

    @Test
    public void testQ1EmptyNumber1StayQ1() {
        num2Field.sendKeys("2.3");
        usrResult.sendKeys("2.3");
        mathSubmitBtn.click();

        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1EmptyNumber1StayQ1 message: " + msg);
        Assertions.assertEquals("Q1 incorrect. Try again.", msg);
    }

    @Test
    public void testQ1EmptyNumber2StayQ1() {
        num1Field.sendKeys("2.3");
        usrResult.sendKeys("2.3");
        mathSubmitBtn.click();
        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1EmptyNumber2StayQ1 message: " + msg);
        Assertions.assertEquals("Q1 incorrect. Try again.", msg);
    }

    @Test
    public void testQ1EmptyAnswerStayQ1() {
        num1Field.sendKeys("2.3");
        num2Field.sendKeys("2.3");
        mathSubmitBtn.click();
        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1EmptyAnswerStayQ1 message: " + msg);
        Assertions.assertEquals("Q1 incorrect. Try again.", msg);
    }

    @Test
    public void testQ1NonNumericNumber1StayQ1() {
        num1Field.sendKeys("abc");
        num2Field.sendKeys("2.3");
        usrResult.sendKeys("2.3");
        mathSubmitBtn.click();
        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1NonNumericNumber1StayQ1 message: " + msg);
        Assertions.assertEquals("Q1 incorrect. Try again.", msg);
    }

    @Test
    public void testQ1NonNumericNumber2StayQ1() {
        num1Field.sendKeys("2.3");
        num2Field.sendKeys("abc");
        usrResult.sendKeys("2.3");
        mathSubmitBtn.click();
        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1NonNumericNumber2StayQ1 message: " + msg);
        Assertions.assertEquals("Q1 incorrect. Try again.", msg);
    }

    @Test
    public void testQ1NonNumericAnswerStayQ1() {
        num1Field.sendKeys("2.3");
        num2Field.sendKeys("2.3");
        usrResult.sendKeys("abc");
        mathSubmitBtn.click();
        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1NonNumericAnswerStayQ1 message: " + msg);
        Assertions.assertEquals("Q1 incorrect. Try again.", msg);
    }

    @Test
    public void testQ1CorrectAnswerQ2() {
        num1Field.sendKeys("2.3");
        num2Field.sendKeys("2.3");
        usrResult.sendKeys("4.6");
        mathSubmitBtn.click();
        msgText = wait.until(
            ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("div")
            )
        );
        String msg = msgText.getText();
        System.out.println("testQ1CorrectAnswerQ2 message: " + msg);
        Assertions.assertEquals("Q1 correct. Proceed to Q2.", msg);
    }
}