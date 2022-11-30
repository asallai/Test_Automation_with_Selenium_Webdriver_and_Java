import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
0.Open the browser
1.Open site (www.vpl.ca)
2.Search for a keyword
3.Click on the first result
4.In the details page, verify that the book name is displayed
5.Close the browser
 */

public class Test1Simple {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDriver\\chromedriver.exe");

        // 0.Open the browser
        WebDriver driver;
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        // 1.Open site (www.vpl.ca)

        driver.get("https://www.vpl.ca");

        System.out.println("Web page:" + driver.getCurrentUrl() + " Title:" + driver.getTitle());

        // 2.Search for a keyword

        WebElement searchField;
        searchField = driver.findElement(By.xpath("//input[@id='edit-search']"));
        searchField.click();
        searchField.sendKeys("java");

        WebElement searchButton;
        searchButton = driver.findElement(By.xpath("//input[@id='edit-submit']"));
        searchButton.click();

        Thread.sleep(1000);
        System.out.println("Result page:" + driver.getCurrentUrl() + " Title:" + driver.getTitle());

        // 3.Click on the first result

        WebElement firstResultLink;
        firstResultLink = driver.findElement(By.xpath("(//a[@data-key='bib-title'])[1]"));
        firstResultLink.click();

        // 4.In the details page, verify that the book name is displayed

        Thread.sleep(1000);
        System.out.println("Details page:" + driver.getCurrentUrl() + " Title:" + driver.getTitle());

        WebElement bookTitleElement;
        bookTitleElement = driver.findElement(By.xpath("//div[@class = 'sub-title']"));

        String bookTitle = bookTitleElement.getText();

        if(bookTitleElement.isDisplayed() == true)
            System.out.println("Book title is displayed on the details page: " + bookTitle);
        else
            System.out.println("Book title is NOT displayed on the details page");

        // 5.Close the browser
        driver.quit();
    }
}