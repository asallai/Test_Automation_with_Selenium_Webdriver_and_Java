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

// REFACTOR STEP 5: REMOVE VARIABLES THAT ARE USED ONLY ONCE

public class RefactorWebShopTestStep5 {
    WebElement emailField;
    WebElement passwordField;
    WebElement noEmailPwdMsg;

    By signInLinkLocator = By.id("sign-in-link");
    By emailFieldLocator = By.id("email-input");
    By passwordFieldLocator = By.id("pwd-input");
    By signInBtnLocator = By.id("sign-in-btn");
    By noEmailPwdMsgLocator = By.xpath("//div[@testid='no-email-pwd-msg']");

    WebDriver driver;
    WebDriverWait wait;

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
    public void testLoginWithEmptyEmailAndPwd() {
        driver.get("http://www.webshop.com");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator)).click();
        wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator)).click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(noEmailPwdMsgLocator));
        assertTrue(noEmailPwdMsg.isDisplayed());
    }

    @Test
    public void testLoginWithValidEmailAndInvalidPwd() {
        String validEmail = "test1@yahoo.com";
        String notExistPwd = "notexist";

        driver.get("http://www.webshop.com");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator)).click();

        emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailField.click();
        emailField.sendKeys(validEmail);

        passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        passwordField.click();
        passwordField.sendKeys(notExistPwd);

        wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator)).click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(noEmailPwdMsgLocator));
        assertTrue(noEmailPwdMsg.getText().contains("No match for these e-mail and/or password"));
    }

    @Test
    public void testLoginWithValidPwdAndInvalidEmail() {
        String invalidEmail = "test1.g.com";
        String validPassword = "Pass123";

        driver.get("http://www.webshop.com");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator)).click();

        emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailField.click();
        emailField.sendKeys(invalidEmail);

        passwordField = wait.until(ExpectedConditions.elementToBeClickable(passwordFieldLocator));
        passwordField.click();
        passwordField.sendKeys(validPassword);

        wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator)).click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(noEmailPwdMsgLocator));
        assertTrue(noEmailPwdMsg.getText().contains("Please use the correct email format: email@domain.com"));
    }

    @Test
    public void testLoginWithValidEmailAndEmptyPwd() {
        String validEmail = "test1@gmail.com";

        driver.get("http://www.webshop.com");
        driver.manage().window().maximize();

        wait.until(ExpectedConditions.elementToBeClickable(signInLinkLocator)).click();

        emailField = wait.until(ExpectedConditions.elementToBeClickable(emailFieldLocator));
        emailField.click();
        emailField.sendKeys(validEmail);

        wait.until(ExpectedConditions.elementToBeClickable(signInBtnLocator)).click();

        noEmailPwdMsg = wait.until(ExpectedConditions.visibilityOfElementLocated(noEmailPwdMsgLocator));
        assertTrue(noEmailPwdMsg.getText().contains("Please enter your password"));
    }
}
