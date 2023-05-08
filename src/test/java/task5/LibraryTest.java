package task5;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LibraryTest {

    WebDriver driver;
    WebDriverWait wait;

    WebElement searchTextBox;
    WebElement searchButton;
    WebElement pageTwo;
    WebElement pageTwoResult;

    By searchTextBoxLocator = By.id("globalQuery");
    By searchButtonLocator = By.id("search_button");
    By pageTwoLocator = By.xpath("//a[@testid='link_page2']");
    By pageTwoResultLocator = By.xpath("//span[@class='items_showing_count']");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 25);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLibrary() {
        driver.get("http://www.library.com");
        driver.manage().window().maximize();

        findIfClickable(searchTextBoxLocator);
        searchTextBox.click();
        searchTextBox.sendKeys("java");

        findIfClickable(searchButtonLocator);
        searchButton.click();

        findIfClickable(pageTwoLocator);
        pageTwo.click();

        findIfVisible(pageTwoResultLocator);
        assertTrue ("Page 2 results number is not correct", pageTwoResult.getText().contains("10-19"));
    }

    private WebElement findIfVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement findIfClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
