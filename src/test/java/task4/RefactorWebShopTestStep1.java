package task4;

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

// REFACTOR STEP 1: CHANGE THE TEST SCRIPT NAMES

public class RefactorWebShopTestStep1 {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("http://www.webshop.com");
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 25);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLoginWithEmptyEmailAndPwd() {
        WebElement signInLink;
        WebElement signInBtn;
        WebElement noEmailPwdMsg;

        signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-link")));
        signInLink.click();

        signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-btn")));
        signInBtn.click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@testid='no-email-pwd-msg']")));

        assertTrue(noEmailPwdMsg.isDisplayed());
    }

    @Test
    public void testLoginWithValidEmailAndInvalidPwd() {
        WebElement signInLink;
        WebElement emailField;
        WebElement passwordField;
        WebElement signInBtn;
        WebElement noEmailPwdMsg;

        String validEmail = "test1@yahoo.com";
        String notExistPwd = "notexist";

        signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-link")));
        signInLink.click();

        emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email-input")));
        emailField.click();
        emailField.sendKeys(validEmail);

        passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("pwd-input")));
        passwordField.click();
        passwordField.sendKeys(notExistPwd);

        signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-btn")));
        signInBtn.click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//div[@testid='no-email-pwd-msg'])")));

        assertTrue(noEmailPwdMsg.getText().contains("No match for these e-mail and/or password"));
    }

    @Test
    public void testLoginWithValidPwdAndInvalidEmail() {
        WebElement signInLink;
        WebElement emailField;
        WebElement passwordField;
        WebElement signInBtn;
        WebElement noEmailPwdMsg;
        String invalidEmail = "test1.g.com";
        String validPassword = "Pass123";

        signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-link")));
        signInLink.click();

        emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email-input")));
        emailField.click();
        emailField.sendKeys(invalidEmail);

        passwordField = wait.until(ExpectedConditions.elementToBeClickable(By.id("pwd-input")));
        passwordField.click();
        passwordField.sendKeys(validPassword);

        signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-btn")));
        signInBtn.click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@testid='no-email-pwd-msg']")));

        assertTrue(noEmailPwdMsg.getText().contains("Wrong email format! Please use this format: email@domain.com"));
    }

    @Test
    public void testLoginWithValidEmailAndEmptyPwd() {
        WebElement signInLink;
        WebElement emailField;
        WebElement signInBtn;
        WebElement noEmailPwdMsg;
        String validEmail = "test1@gmail.com";

        signInLink = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-link")));
        signInLink.click();

        emailField = wait.until(ExpectedConditions.elementToBeClickable(By.id("email-input")));
        emailField.click();
        emailField.sendKeys(validEmail);

        signInBtn = wait.until(ExpectedConditions.elementToBeClickable(By.id("sign-in-btn")));
        signInBtn.click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@testid='no-email-pwd-msg'")));

        assertTrue(noEmailPwdMsg.getText().contains("Please enter your password"));
    }
}
