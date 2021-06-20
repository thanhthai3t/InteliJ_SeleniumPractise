package Section14;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;

public class HandleTakeScreenshot {
    public static void main(String[] args) throws IOException {
        // Object: Handle Cookie
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver91.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://google.com");
        driver.manage().window().maximize();
        File scr = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scr,new File("C:\\Users\\trant\\OneDrive\\Pictures\\SeleniumScreenshot\\test.png"));

    }
}
