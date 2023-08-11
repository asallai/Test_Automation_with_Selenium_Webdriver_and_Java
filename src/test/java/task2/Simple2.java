package task2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Simple2 {

    public static void main(String[] args) {

        // 0. initiate
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");
        WebDriver driver;
        driver = new ChromeDriver();

        // 1. open www.vpl.ca
        driver.get("https://www.wpl.ca");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. type "java" in the search textbox
        WebElement textbox;
        textbox = driver.findElement(By.xpath("//input[@id='edit-search']"));
        textbox.click();
        textbox.sendKeys("java");

        // 3. click the search button
        WebElement searchButton;
        searchButton = driver.findElement(By.xpath("//input[@id='edit-submit']"));
        searchButton.click();

        // 4. verify that the title and url of the results page are correct

        // 4.1 verify the title of the result page
        String expectedTitle = "Search | Vancouver Public Library | BiblioCommons";
        String resultPageTitle;
        resultPageTitle = driver.getTitle();

        if(resultPageTitle.equals(expectedTitle))
            System.out.println("Page title OK");
        else
            System.out.println("Page title not OK");

        // 4.2 verify the url of the result page
        String expectedResultPageUrl = "https://vpl.bibliocommons.com/search?q=java&t=keyword";;
        String resultPageUrl;
        resultPageUrl = driver.getCurrentUrl();

        if(resultPageUrl.equals(expectedResultPageUrl))
            System.out.println("URL ok");
        else
            System.out.println("URL not ok");

        // 5. verify that the search keyword is displayed on top of the page
        WebElement resultKeywordElement;
        resultKeywordElement = driver.findElement(By.xpath("//h1[@data-test-id='searchTitle']/strong"));

        String resultKeyword = resultKeywordElement.getText();
        if ( resultKeyword.equals("java") )
            System.out.println("The search keyword '" + "java" + "' is displayed!");
        else
            System.out.println("The search keyword '" + "java" + "' is NOT displayed!");

        // 6. click the Save Search link
        WebElement saveSearchLink;
        saveSearchLink = driver.findElement(By.xpath("//button[@data-test-id='save-search-link']"));
        saveSearchLink.click();

        // 7. confirm that the login page is displayed
        String expectedLoginUrl = "https://vpl.bibliocommons.com/user/login";
        String resultLoginUrl = driver.getCurrentUrl();

        if ( expectedLoginUrl.equals(resultLoginUrl) )
            System.out.println("The login page is displayed");
        else {
            System.out.println("The expected login url is: " + expectedLoginUrl);
            System.out.println("The result   login url is: " + resultLoginUrl);
            System.out.println("The login page is NOT displayed");
        }

        driver.quit();
    }

}
