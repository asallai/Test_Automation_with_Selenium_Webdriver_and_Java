package task11;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LifeInsuranceCalculator {
    WebDriver driver;
    WebDriverWait wait;

    String url = "https://ia.ca/life-insurance-calculator";

    By manIconLocator = By.className("assVie-icone-homme");
    By singleIconLocator = By.className("assVie-icone-celibataire");
    By nonSmokerIconLocator = By.className("assVie-icone-non-fumeur");

    By ageTextBoxLocator = By.id("Formulaire_age");
    By incomeTextBoxLocator = By.id("Formulaire_revenu");
    By mortgageTextBoxLocator = By.id("Formulaire_detteMaison");
    By autoTextBoxLocator = By.id("Formulaire_detteAuto");
    By creditCardTextBoxLocator = By.id("Formulaire_detteCredits");
    By totalAmountTextBoxLocator = By.id("Formulaire_montantAutreAssuranceVie");

    By childrenSliderLocator = By.xpath("(//div[@class='slider-handle min-slider-handle'])[1]");

    By childrenNumSliderLocator = By.xpath("//div[@class='slider-handle min-slider-handle custom']");
    By childrenNumTextBoxLocator = By.id("Formulaire_nbrEnfant");
    By childrenPlusButtonLocator = By.id("nbrEnfantSliderPlus");

    By educationSliderLocator = By.xpath("(//div[@class='slider-handle min-slider-handle'])[2]");

    By insuranceSliderLocator = By.xpath("(//div[@class='slider-handle min-slider-handle'])[3]");
    By insuranceNoButtonLocator = By.id("autreAssuranceVieMinus");
    By insuranceYesButtonLocator = By.id("autreAssuranceViePlus");

    By calculateButtonLocator = By.id("clickMe");

    By situationAmountLocator = By.id("resultSlider");
    By situationSliderLocator = By.xpath("(//div[@class='slider-handle min-slider-handle custom'])[2]");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\BrowserDrivers\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void lifeInsuranceTestScript() throws InterruptedException {

        // 1. open the page
        openSite(url);

        // 2. make the following selections: your general situation: man, single, non-smoker
        click(manIconLocator);
        click(singleIconLocator);
        click(nonSmokerIconLocator);

        // how old are you? 50 years
        type(ageTextBoxLocator, "50");

        // do you have children? yes (drag and drop the slider to the right)
        WebElement childrenSlider = findIfClickable(childrenSliderLocator);
        String percent = childrenSlider.getAttribute("style");
        assertTrue(percent.contains("left: 0%"));

        Dimension sliderSize = childrenSlider.getSize();
        int sliderWidth = sliderSize.getWidth();
        int xCoord = childrenSlider.getLocation().getX();

        Actions builder = new Actions(driver);

        builder.moveToElement(childrenSlider)
                .click()
                .dragAndDropBy(childrenSlider, xCoord + sliderWidth, 0)
                .build()
                .perform();

        childrenSlider = findIfClickable(childrenSliderLocator);
        percent = childrenSlider.getAttribute("style");
        assertTrue(percent.contains("left: 100%"));

        // children 10 (click the plus button 10 times)
        WebElement childrenNumSlider = findIfClickable(childrenNumSliderLocator);
        percent = childrenNumSlider.getAttribute("style");
        assertTrue(percent.contains("left: 0%"));

        WebElement childrenNumTextBox = findIfClickable(childrenNumTextBoxLocator);
        String childrenValue = childrenNumTextBox.getAttribute("value");
        assertEquals(childrenValue, "0");

        WebElement childrenPlusButton = findIfClickable(childrenPlusButtonLocator);

        for (int i = 0; i < 10; i++) {
            childrenPlusButton.click();
        }

        childrenNumSlider = findIfClickable(childrenNumSliderLocator);
        percent = childrenNumSlider.getAttribute("style");
        assertTrue(percent.contains("left: 100%"));

        childrenNumTextBox = findIfClickable(childrenNumTextBoxLocator);
        childrenValue = childrenNumTextBox.getAttribute("value");
        assertEquals(childrenValue, "10");

        // do you wish to pay for their post secondary education? yes (drag and drop the slider to the right)
        WebElement educationSlider = findIfClickable(educationSliderLocator);
        percent = educationSlider.getAttribute("style");
        assertTrue(percent.contains("left: 0%"));

        sliderSize = educationSlider.getSize();
        sliderWidth = sliderSize.getWidth();
        xCoord = educationSlider.getLocation().getX();

        builder = new Actions(driver);

        builder.moveToElement(educationSlider)
                .click()
                .dragAndDropBy(educationSlider, xCoord + sliderWidth, 0)
                .build()
                .perform();

        educationSlider = findIfClickable(educationSliderLocator);
        percent = educationSlider.getAttribute("style");
        assertTrue(percent.contains("left: 100%"));

        // amount: 150000
        type(incomeTextBoxLocator, "150000");

        // home mortgage: 250000
        type(mortgageTextBoxLocator, "250000");

        // auto: 20000
        type(autoTextBoxLocator, "20000");

        // credit cards: 10000
        type(creditCardTextBoxLocator, "10000");

        // do you already have life insurance? yes
        WebElement insuranceSlider = findIfClickable(insuranceSliderLocator);
        percent = insuranceSlider.getAttribute("style");
        assertTrue(percent.contains("left: 0%"));

        WebElement insuranceYesButton = findIfClickable(insuranceYesButtonLocator);
        String classActive = insuranceYesButton.getAttribute("class");
        assertEquals(classActive, "");

        insuranceYesButton.click();

        insuranceYesButton = findIfClickable(insuranceYesButtonLocator);
        classActive = insuranceYesButton.getAttribute("class");
        assertEquals(classActive, "active");

        insuranceSlider = findIfClickable(insuranceSliderLocator);
        percent = insuranceSlider.getAttribute("style");
        assertTrue(percent.contains("left: 100%"));

        // total amount: 50000
        type(totalAmountTextBoxLocator, "50000");

        // 3. click calculate
        click(calculateButtonLocator);

        // 4. verify that your situation = $ 454.59/month
        WebElement situationAmount = findIfVisible(situationAmountLocator);
        String amount = situationAmount.getText();
        assertEquals(amount, "$ 454.59");

        // 5. drag and drop the slider to the end
        WebElement situationSlider = findIfClickable(situationSliderLocator);

        sliderSize = situationSlider.getSize();
        sliderWidth = sliderSize.getWidth();
        xCoord = situationSlider.getLocation().getX();

        builder = new Actions(driver);

        builder.moveToElement(situationSlider)
                .click()
                .dragAndDropBy(situationSlider, xCoord + sliderWidth, 0)
                .build()
                .perform();

        situationSlider = findIfClickable(situationSliderLocator);
        percent = situationSlider.getAttribute("style");
        assertTrue(percent.contains("left: 100%"));

        // 6. verify that your situation = $ 634.27/month
        situationAmount = findIfVisible(situationAmountLocator);
        amount = situationAmount.getText();
        assertEquals(amount, "$ 634.27");
    }


    public void openSite(String url) {
        driver.get(url);
    }

    public WebElement findIfClickable(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        return element;
    }

    public WebElement findIfVisible(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element;
    }

    public void click(By locator) {
        WebElement element = findIfClickable(locator);
        element.click();
    }

    public void type(By locator, String text) {
        WebElement textBox = findIfClickable(locator);
        textBox.click();
        textBox.clear();
        textBox.sendKeys(text);
    }

}