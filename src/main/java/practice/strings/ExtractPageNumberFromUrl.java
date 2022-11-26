package practice.strings;

/*
Extract the page number from the following url using string methods.
The solution should work for any page number value.
https://vpl.bibliocommons.com/v2/search?page=5&query=java&type=keyword
 */

public class ExtractPageNumberFromUrl {

    public static void main(String[] args) {

        String url = "https://vpl.bibliocommons.com/v2/search?page=5&query=java&type=keyword";

        int beginIndex = url.indexOf("page=");
        beginIndex = beginIndex + 5;   //length of "page="

        int endIndex = url.indexOf("&");

        String pageNumber = url.substring(beginIndex, endIndex);

        System.out.println(pageNumber);
    }

}

