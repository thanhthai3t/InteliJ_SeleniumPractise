package Section15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class SortingStream {
        public static void main(String[] args) {
            System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver91.exe");
            WebDriver driver = new ChromeDriver();
            driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
            //click on column header
            driver.findElement(By.xpath("//tr/th[1]")).click();
            //select all elements in first column
            List<WebElement> valuesList = driver.findElements(By.xpath("//tr/td[1]"));
            //get the list using Stream
            List<String> originalList = valuesList.stream().map(WebElement::getText).collect(Collectors.toList());
            System.out.println(originalList);
            //sort the list via Stream
            List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());
            System.out.println(sortedList);
            //compare
            Assert.assertNotEquals(sortedList, originalList);
        }
    }
