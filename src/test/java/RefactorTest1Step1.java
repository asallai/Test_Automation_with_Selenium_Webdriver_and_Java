import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
1. BREAK THE CODE IN UNIT TEST SCRIPT
 */

public class RefactorTest1Step1 {

    // TEST CASE 1: book title and author are displayed and not empty

    @Test
    public void testResultDetails() {

        WebDriver driver = new FirefoxDriver();

        // open the home page and check that the home page title is correct
        driver.get("http://www.vpl.ca");

        if (driver.getTitle().equalsIgnoreCase("Vancouver Public Library - Home") == true)
            System.out.println("the home page title is correct");
        else {
            System.out.println("the home page title is incorrect, stop the application");
            System.exit(0);
        }

        // search with a keyword, the result page is opened as result of the search
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='globalQuery']"));
        searchTextBox.click();
        searchTextBox.sendKeys("java");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
        searchButton.click();

        // check that the results page title is correct
        if (driver.getTitle().equalsIgnoreCase("Search | Vancouver Public Library | BiblioCommons") == true)
            System.out.println("the results page title is correct");
        else {
            System.out.println("the results page title is incorrect, stop the application");
            System.exit(0);
        }

        // click on the first result, the details page is opened as a result
        WebElement firstResult = driver.findElement(By.xpath("(//a[@testid='bib_link'])[1]"));
        firstResult.click();

        // check that the title of details page is correct
        if (driver.getTitle().indexOf("Vancouver Public Library | BiblioCommons") >= 0)
            System.out.println("the details page title is correct");
        else {
            System.out.println("the details page title is incorrect, stop the application");
            System.exit(0);
        }

        // check that the book title is displayed and not empty
        WebElement bookTitle = driver.findElement(By.xpath("//h1[@id='item_bib_title']"));

        if (bookTitle.isDisplayed() == true)
            System.out.println("the book title is displayed");
        else {
            System.out.println("the book title is not displayed, stop the application");
            System.exit(0);
        }

        if (bookTitle.getText().length() > 0)
            System.out.println("the book title is not empty");
        else {
            System.out.println("the book title is empty, stop the application");
            System.exit(0);
        }

        // check that the book author is displayed and not empty
        WebElement bookAuthor = driver.findElement(By.xpath("//a[@testid='author_search']"));

        if (bookAuthor.isDisplayed() == true)
            System.out.println("the book author is displayed");
        else {
            System.out.println("the book author is not displayed, stop the application");
            System.exit(0);
        }

        if (bookAuthor.getText().length() > 0)
            System.out.println("the book author is not empty");
        else {
            System.out.println("the book author is empty, stop the application");
            System.exit(0);
        }

        // close the browser
        driver.quit();
    }


    //TEST CASE 2: browsing through result page works

    @Test
    public void testPaging() {

        WebDriver driver = new FirefoxDriver();

        // open the home page and check that the home page title is correct
        driver.get("http://www.vpl.ca");

        if (driver.getTitle().equalsIgnoreCase("Vancouver Public Library - Home") == true)
            System.out.println("the home page title is correct");
        else {
            System.out.println("the home page title is incorrect, stop the application");
            System.exit(0);
        }

        // search with a keyword, the result page is opened as result of the search
        WebElement searchTextBox = driver.findElement(By.xpath("//input[@id='globalQuery']"));
        searchTextBox.click();
        searchTextBox.sendKeys("java");

        WebElement searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
        searchButton.click();

        // check that the result page title is correct
        if (driver.getTitle().equalsIgnoreCase("Search | Vancouver Public Library | BiblioCommons") == true)
            System.out.println("the results page title is correct");
        else {
            System.out.println("the results page title is incorrect, stop the application");
            System.exit(0);
        }

        // check that the number of results is displayed and correct
        WebElement numberResultPageOne = driver.findElement(By.xpath("//span[@class='items_showing_count']"));

        if (numberResultPageOne.isDisplayed() == true)
            System.out.println("The number of the results on the page 1 is displayed");
        else {
            System.out.println("The number of the results on the page 1 is not displayed, stop the application");
            System.exit(0);
        }

        if (numberResultPageOne.getText().indexOf("1 - 25") >=0)
            System.out.println("The number of the results on the page 1 is correct");
        else {
            System.out.println("The number of the results on the page 1 is not correct, stop the application");
            System.exit(0);
        }

        // navigating to page 2 of results
        WebElement pageTwo = driver.findElement(By.xpath("//a[@testid='link_page2']"));
        pageTwo.click();

        // check that the number of results is displayed and correct
        WebElement numberResultPageTwo = driver.findElement(By.xpath("//span[@class='items_showing_count']"));

        if (numberResultPageTwo.isDisplayed() == true)
            System.out.println("The number of the results on the page 2 is displayed");
        else {
            System.out.println("The number of the results on the page 2 is not displayed, stop the application");
            System.exit(0);
        }

        if (numberResultPageTwo.getText().indexOf("26 - 50") >=0)
            System.out.println("The number of the results on the page 2 is correct");
        else {
            System.out.println("The number of the results on the page 2 is not correct, stop the application");
            System.exit(0);
        }

        // close the browser
        driver.quit();
    }

}

