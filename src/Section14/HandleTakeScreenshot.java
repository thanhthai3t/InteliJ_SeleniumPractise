package Section14;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleTakeScreenshot {
    public static void main(String[] args) {
        // Object: Handle Cookie
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver91.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();
    }
}