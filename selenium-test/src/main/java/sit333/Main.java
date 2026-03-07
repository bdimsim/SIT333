package sit333;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Main {
    public static void main(String[] args) {
        // System.setProperty(
        //     "webdriver.chrome.driver",
        //     "C:/Users/Brand/Downloads/installers/chromedriver-win64/chromedriver-win64/chromedriver.exe"
        // );

        WebDriver driver = new ChromeDriver();
        System.out.println(driver);

        // Open url in browser
        driver.get("https://www.google.com");

        // Pause 5s
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // Close browser
        driver.close();
        // System.out.println("Hello world!");
    }
}