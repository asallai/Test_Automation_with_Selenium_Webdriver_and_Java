package task8;

import static org.testng.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class Lesson8Londondrugs {

    WebDriver driver;
    WebDriverWait wait;

    ChromeOptions options;

    String keyword = "iphone";
    String text = "Price - High to Low";

    String baseUrl = "http://www.londondrugs.com/";
    String concatUrl = "http://www.londondrugs.com/on/demandware.store/Sites-LondonDrugs-Site/default/Search-Show?q=" + keyword + "&simplesearch=Go";

    By searchButtonLocator = By.xpath("//div[@id='search-cta']/span");
    By searchTextBoxLocator = By.xpath("//div//input[@id='searchinput']");
    By simpleSearchButtonLocator = By.xpath("//button[@name='simplesearch'])");
    By resultsHitsLocator = By.xpath("(//div[@class='resultshits'])[1]/strong");
    By dropdownBoxLocator = By.xpath("(//select)[1]");
    By itemsPerPageLocator = By.xpath("(//div[@class='itemsperpage'])[1]/a[@class='active']");
    By productTilesLocator = By.xpath("//div[@class='productresultarea']//div[contains(@class,'producttile')]");
    By productTilesImagesLocator = By.xpath("//div[@class='productresultarea']//div[contains(@class,'producttile')]/div[@class='image']");
    By productTilesPricesLocator = By.xpath("//div[@class='productresultarea']//div[contains(@class,'producttile')]/div[@class='pricing']");
    By productTilesNamesLocator = By.xpath("//div[@class='productresultarea']//div[contains(@class,'producttile')]/div[@class='name']");

    String searchedKeywordXPath = "//a[@title='" + keyword + "']";
    By searchedKeywordLocator = By.xpath(searchedKeywordXPath);

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        options = new ChromeOptions();
        options.addArguments("--disable-extensions");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testResultPage() throws InterruptedException {
        // 1. Open the site
        // --- 1st page ---
        driver.get(baseUrl);

        // 2. Click the search button
        WebElement searchButton = findIfClickable(searchButtonLocator);
        searchButton.click();

        // 3. Click the search text box + type the keyword into the text box
        WebElement searchTextBox = findIfClickable(searchTextBoxLocator);
        searchTextBox.click();
        searchTextBox.sendKeys(keyword);

        // 4. Click the simple search button
        WebElement simpleSearchButton = findIfClickable(simpleSearchButtonLocator);
        simpleSearchButton.click();

        // 5. Check the url of the result page + check the keyword
        // --- 2nd page ---
        assertTrue(wait.until(ExpectedConditions.urlToBe(concatUrl)), "2nd page is not visible");

        // 6. Check the keyword is displayed
        WebElement searchedKeyword = findIfVisible(searchedKeywordLocator);
        assertTrue(searchedKeyword.isDisplayed(), "Searched keyword is NOT displayed");

        // 7. Check that the number of results is greater than 0
        WebElement resultsHits = findIfVisible(resultsHitsLocator);
        String resultsHitsSTR = resultsHits.getText();

        int resultsHitsIndex = resultsHitsSTR.indexOf("- ") + 2;
        String resultsHitsNumberStr = resultsHitsSTR.substring(resultsHitsIndex);
        int resultsHitsNumber = Integer.parseInt(resultsHitsNumberStr);

        assertTrue(resultsHitsNumber > 0, "No results!");

        // 8. Select "Price High to Low" for Sorting
        WebElement dropdownBox = findIfClickable(dropdownBoxLocator);
        Select dropdownList = new Select(dropdownBox);
        dropdownList.selectByVisibleText(text);

        //--- after reloading the page!
        dropdownBox = findIfClickable(dropdownBoxLocator);
        dropdownList = new Select(dropdownBox);
        WebElement dropdownSelected = dropdownList.getFirstSelectedOption();
        String dropdownVisibleText = dropdownSelected.getText().trim();

        assertTrue(dropdownVisibleText.equalsIgnoreCase(text), "Dropdown result is not OK");

        // 9. Check that the number of results in the page is equal with the selected results count (20 or 40 or 60)
        // --- selected items per page
        WebElement itemsPerPage = findIfVisible(itemsPerPageLocator);

        String itemsPerPageStr = itemsPerPage.getText();
        int itemsPerPageNumber = Integer.parseInt(itemsPerPageStr);

        // --- number of the product tiles
        ArrayList<WebElement> productTiles = (ArrayList<WebElement>)driver.findElements(productTilesLocator);
        assertEquals(itemsPerPageNumber, productTiles.size(), "Product tiles are not OK");

        // 10. Check that all results have photos, prices and title
        ArrayList<WebElement> productTilesImages = (ArrayList<WebElement>)driver.findElements(productTilesImagesLocator);
        ArrayList<WebElement> productTilesPrices = (ArrayList<WebElement>)driver.findElements(productTilesPricesLocator);
        ArrayList<WebElement> productTilesNames = (ArrayList<WebElement>)driver.findElements(productTilesNamesLocator);

        assertEquals(itemsPerPageNumber, productTilesImages.size(), "Product tiles images are not OK");
        assertEquals(itemsPerPageNumber, productTilesPrices.size(), "Product tiles prices are not OK");
        assertEquals(itemsPerPageNumber, productTilesNames.size(), "Product tiles names are not OK");
    }

    private WebElement findIfVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private WebElement findIfClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
