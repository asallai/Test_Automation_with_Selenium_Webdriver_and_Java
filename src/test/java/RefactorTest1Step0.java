import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

/*
0. CODE WITHOUT REFACTORING
 */

public class RefactorTest1Step0 {

    public static void main(String[] args) {

        WebDriver driver = new FirefoxDriver();

        // TEST CASE 1: book title and author are displayed and not empty

        // open the home page and check that the home page title is correct
        driver.get("http://www.vpl.ca");

        if (driver.getTitle().equalsIgnoreCase("Vancouver Public Library - Home") == true)
            System.out.println("correct home page title");
        else {
            System.out.println("incorrect home page title, stop application");
            System.exit(0);
        }

        // search with a keyword, the result page is opened as result of the search
        WebElement searchTextBox;
        searchTextBox = driver.findElement(By.xpath("//input[@id='globalQuery']"));

        searchTextBox.click();
        searchTextBox.sendKeys("java");

        WebElement searchButton;
        searchButton = driver.findElement(By.xpath("//input[@class='search_button']"));
        searchButton.click();

        // check that the results page title is correct
        if (driver.getTitle().equalsIgnoreCase("Search | Vancouver Public Library | BiblioCommons") == true)
            System.out.println("correct results page title");
        else {
            System.out.println("incorrect results page title, stop application");
            System.exit(0);
        }

        // click on the first result, the details page is opened as a result
        WebElement firstResult;
        firstResult = driver.findElement(By.xpath("(//a[@testid='bib_link'])[1]"));
        firstResult.click();

        // check that the title of details page is correct
        if (driver.getTitle().indexOf("Vancouver Public Library | BiblioCommons") >= 0)
            System.out.println("correct details page title");
        else {
            System.out.println("incorrect details page title, stop the application");
            System.exit(0);
        }

        // check that the book title is displayed and not empty
        WebElement bookTitle = driver.findElement(By.xpath("//h1[@id='item_bib_title']"));

        if (bookTitle.isDisplayed() == true)
            System.out.println("book title displayed");
        else {
            System.out.println("book title not displayed, stop application");
            System.exit(0);
        }

        if (bookTitle.getText().length() > 0)
            System.out.println("the book title not empty");
        else {
            System.out.println("book title empty, stop application");
            System.exit(0);
        }

        // check that the book author is displayed and not empty
        WebElement bookAuthor;
        bookAuthor = driver.findElement(By.xpath("//a[@testid='author_search']"));

        if (bookAuthor.isDisplayed() == true)
            System.out.println("book author displayed");
        else {
            System.out.println("book author not displayed, stop application");
            System.exit(0);
        }

        if (bookAuthor.getText().length() > 0)
            System.out.println("book author not empty");
        else {
            System.out.println("book author empty, stop application");
            System.exit(0);
        }


        // TEST CASE 2: browsing through results pages works

        // go back to result page
        driver.navigate().back();

        // check that the number of results is displayed and correct
        WebElement numberResultPageOne;
        numberResultPageOne = driver.findElement(By.xpath("//span[@class='items_showing_count']"));

        if (numberResultPageOne.isDisplayed() == true)
            System.out.println("Results number on page 1 - displayed");
        else {
            System.out.println("Results number on page 1 - not displayed, stop app");
            System.exit(0);
        }

        if (numberResultPageOne.getText().indexOf("1 - 25") >=0 )
            System.out.println("Results number on page 1 - correct");
        else {
            System.out.println("Results number on page 1 - not correct, stop app");
            System.exit(0);
        }

        // navigating to page 2 of results
        WebElement pageTwo = driver.findElement(By.xpath("//a[@testid='link_page2']"));
        pageTwo.click();

        // check that the number of results is displayed and correct
        WebElement numberResultPageTwo;
        numberResultPageTwo  = driver.findElement(By.xpath("//span[@class='items_showing_count']"));

        if (numberResultPageTwo.isDisplayed() == true)
            System.out.println("Results number on page 2 - displayed");
        else {
            System.out.println("Results number on page 2 - not displayed, stop app");
            System.exit(0);
        }

        if (numberResultPageTwo.getText().indexOf("26 - 50") >=0)
            System.out.println("Results number on page 2 - correct");
        else {
            System.out.println("Results number on page 2 - not correct, stop app");
            System.exit(0);
        }

        // close the browser
        driver.quit();
    }

}
