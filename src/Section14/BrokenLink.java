package Section14;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class BrokenLink {
    public static void main(String[] args) throws IOException {
        //Object: Handle Broken Link
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver91.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        List<WebElement> links = driver.findElements(By.cssSelector("li[class='gf-li'] a"));
        SoftAssert a = new SoftAssert();

        for (WebElement link : links) {

            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection)new URL(url).openConnection();
            conn.setRequestMethod("HEAD"); //using HEAD to receive general method
            conn.connect();
            int respCode = conn.getResponseCode();
            System.out.println(respCode+ " with title "+ link.getText());
            a.assertTrue(respCode<400, "Link with title ["+link.getText()+"] and response code ["+respCode+"] is broken");
        }


        a.assertAll();

    }
}
