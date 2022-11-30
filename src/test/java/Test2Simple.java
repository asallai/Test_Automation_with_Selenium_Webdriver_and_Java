import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

/*
1. open www.vpl.ca
2. type java in the search textbox
3. click the search button
4. verify that the title and url of the result page are correct
5. verify that the search keyword is displayed on top of the page
6. click the Save Search link
7. confirm that the login page is displayed
 */

public class Test2Simple {

    public static void main(String[] args) {

        // 0. initiate
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        WebDriver driver;
        driver = new ChromeDriver();

        // 1. open www.vpl.ca
        driver.get("http://www.vpl.ca");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // 2. type "java" in the search textbox
        WebElement searchField ;
        searchField = driver.findElement(By.xpath("//input[@id='edit-search']"));
        searchField.click();

        String searchKeyWord = "java";
        searchField.sendKeys(searchKeyWord);

        // 3. click the search button
        WebElement searchButton;
        searchButton = driver.findElement(By.xpath("//input[@id='edit-submit']"));
        searchButton.click();

        // 4. verify that the title and url of the results page are correct

        // 4.1 verify the title of the result page
        String expectedPageTitle = "Search | Vancouver Public Library | BiblioCommons";
        String resultPageTitle;

        resultPageTitle = driver.getTitle();

        if ( expectedPageTitle.equals(resultPageTitle) )
            System.out.println("The title of the result page is CORRECT!");
        else {
            System.out.println("The expected page title is: " + expectedPageTitle);
            System.out.println("The result   page title is: " + resultPageTitle);
            System.out.println("The title of the result page is INCORRECT!");
        }

        // 4.2 verify the url of the result page
        String expectedPageUrl = "https://vpl.bibliocommons.com/search?q=java&t=keyword";
        String resultPageUrl;

        resultPageUrl = driver.getCurrentUrl();

        if ( expectedPageUrl.equals(resultPageUrl) )
            System.out.println("The url of the result page is correct!");
        else {
            System.out.println("The expected page url is: " + expectedPageUrl);
            System.out.println("The result   page url is: " + resultPageUrl);
            System.out.println("The url of the result page is NOT correct!");
        }

        // 5. verify that the search keyword is displayed on top of the page
        WebElement resultKeywordElement;
        resultKeywordElement = driver.findElement(By.xpath("//h1[@data-test-id='searchTitle']/strong"));

        String resultKeyword = resultKeywordElement.getText();
        if ( resultKeyword.equals(searchKeyWord) )
            System.out.println("The search keyword '" + searchKeyWord + "' is displayed!");
        else
            System.out.println("The search keyword '" + searchKeyWord + "' is NOT displayed!");

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

        // end
        driver.quit();
    }

}
