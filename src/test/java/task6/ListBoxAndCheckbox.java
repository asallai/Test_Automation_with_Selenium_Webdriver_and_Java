package task6;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class ListBoxAndCheckbox {

    static WebDriver driver;

    String url = "https://www-ssl.bestbuy.ca/en-CA/stores/store-locator.aspx";

    String provinceListXPath = "//select[@id='ctl00_CP_FindStoreUC1_StateContainer_ddlStates']";

    String firstCheckboxXPath = "//input[@id='ctl00_CP_FindStoreUC1_ServicesContainer_ctrl0_ctl00_chkService']";
    String secondCheckboxXPath = "//input[@id='ctl00_CP_FindStoreUC1_ServicesContainer_ctrl1_ctl01_chkService']";
    String thirdCheckboxXPath = "//input[@id='ctl00_CP_FindStoreUC1_ServicesContainer_ctrl3_ctl00_chkService']";

    @BeforeClass
    static public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @AfterClass
    static public void tearDown() {
        driver.quit();
    }

    @Test
    public void testListBoxes() {
        driver.get(url);

        WebElement province = driver.findElement(By.xpath(provinceListXPath));
        Select list = new Select(province);

        list.selectByValue("NS");
        WebElement selectedOption = list.getFirstSelectedOption();
        String name = selectedOption.getText().trim();
        assertTrue(name.equalsIgnoreCase("Nova Scotia"));

        list.selectByVisibleText("British Columbia");
        selectedOption = list.getFirstSelectedOption();
        name = selectedOption.getText().trim();
        assertTrue(name.equalsIgnoreCase("British Columbia"));

        list.selectByIndex(1);
        selectedOption = list.getFirstSelectedOption();
        name = selectedOption.getText().trim();
        assertTrue(name.equalsIgnoreCase("Alberta"));
    }

    @Test
    public void testCheckboxes() {
        driver.get(url);

        WebElement checkbox = driver.findElement(By.xpath(firstCheckboxXPath));
        checkbox.click();
        assertTrue(checkbox.isSelected());

        checkbox = driver.findElement(By.xpath(secondCheckboxXPath));
        checkbox.click();
        assertTrue(checkbox.isSelected());

        checkbox = driver.findElement(By.xpath(thirdCheckboxXPath));
        checkbox.click();
        assertTrue(checkbox.isSelected());
    }
}
