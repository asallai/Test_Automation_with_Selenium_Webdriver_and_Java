import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.Assert.assertTrue;

/*
2. USE ASSERTIONS FOR TEST CASE VERIFICATIONS
 */

public class RefactorTest1Step2 {

    // TEST CASE 1: book title and author are displayed and not empty

    @Test
    public void testResultDetails() {

        WebDriver driver = new FirefoxDriver();

        // open the home page and check that the home page title is correct
        driver.get("http://www.vpl.ca");

        assertTrue("incorrect home page title",
                driver.getTitle().equalsIgnoreCase("Vancouver Public Library - Home") == true);

        // search with a keyword, the result page is opened as result of the search
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='globalQuery']"));
        searchTextBox.click();
        searchTextBox.sendKeys("java");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
        searchButton.click();

        // check that the result page title is correct
        assertTrue("result page title incorrect",
                driver.getTitle().equalsIgnoreCase("Search | Vancouver Public Library | BiblioCommons") == true);

        // click on the first result, the details page is opened as a result
        WebElement firstResult = driver.findElement(By.xpath("(//a[@testid='bib_link'])[1]"));
        firstResult.click();

        // check that the title of details page is correct
        assertTrue ("the details page title is incorrect",
                driver.getTitle().indexOf("Vancouver Public Library | BiblioCommons") >= 0);

        // check that the book title is displayed and not empty
        WebElement bookTitle = driver.findElement(By.xpath("//h1[@id='item_bib_title']"));

        assertTrue ("the book title is not displayed", bookTitle.isDisplayed() == true);
        assertTrue ("the book title is empty", bookTitle.getText().length() > 0);

        // check that the book author is displayed and not empty
        WebElement bookAuthor = driver.findElement(By.xpath("//a[@testid='author_search']"));

        assertTrue ("the book author is not displayed", bookAuthor.isDisplayed() == true);
        assertTrue ("the book author is empty", bookAuthor.getText().length() > 0);

        //close the browser
        driver.quit();
    }


    // TEST CASE 2: browsing through results pages works

    @Test
    public void testPaging() {

        WebDriver driver = new FirefoxDriver();

        // open the home page and check that the home page title is correct
        driver.get("http://www.vpl.ca");

        assertTrue ("the home page title is incorrect",
                driver.getTitle().equalsIgnoreCase("Vancouver Public Library - Home") == true);

        // search with a keyword, the result page is opened as result of the search
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='globalQuery']"));
        searchTextBox.click();
        searchTextBox.sendKeys("java");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
        searchButton.click();

        // check that the result page title is correct
        assertTrue ("result page title incorrect",
                driver.getTitle().equalsIgnoreCase("Search | Vancouver Public Library | BiblioCommons") == true);

        //check that the number of results is displayed and correct
        WebElement numberResultPageOne = driver.findElement(By.xpath("//span[@class='items_showing_count']"));

        assertTrue ("page 1 results number is not displayed", numberResultPageOne.isDisplayed() == true);
        assertTrue ("page 1 results number is incorrect", numberResultPageOne.getText().indexOf("1 - 25") >=0);

        // navigating to page 2 of results
        WebElement pageTwo = driver.findElement(By.xpath("//a[@testid='link_page2']"));
        pageTwo.click();

        // check that the number of results is displayed and correct
        WebElement numberResultPageTwo = driver.findElement(By.xpath("//span[@class='items_showing_count']"));

        assertTrue ("page 2 results number is not displayed", numberResultPageTwo.isDisplayed() == true);
        assertTrue ("page 2 results number is not correct", numberResultPageTwo.getText().indexOf("26 - 50") >=0);

        //close the browser
        driver.quit();
    }

}

