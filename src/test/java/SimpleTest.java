import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
0. open the browser
1. open site (www.vpl.ca)
2. search for a keyword
3. click on the first result
4. in the details page, verify that the book name and author are displayed
5. close the browser
 */

public class SimpleTest {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();



     //   driver.quit();
    }
}