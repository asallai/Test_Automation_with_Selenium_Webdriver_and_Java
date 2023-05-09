package task5;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.Assert.assertTrue;

public class LibraryTest0 {

    /*
     1. open the Library web page
     2. type java in the search textbox
     3. click the search button
     4. click on page 2
     5. validate that page 2 is correct
     */

    @Test
    public void testLibrary() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://www.library.com");
        driver.manage().window().maximize();

        WebElement searchTextBox = driver.findElement(By.id("globalQuery"));
        searchTextBox.click();
        searchTextBox.sendKeys("java");

        WebElement searchButton = driver.findElement(By.id("search_button"));
        searchButton.click();

        WebElement pageTwoLink = driver.findElement(By.xpath("//a[@testid='link_page2']"));
        pageTwoLink.click();

        WebElement pageTwoResult = driver.findElement(By.xpath("//span[@class='items_showing_count']"));
        assertTrue ("Page 2 results number is not correct", pageTwoResult.getText().contains("10-19"));

        driver.quit();
    }

}
