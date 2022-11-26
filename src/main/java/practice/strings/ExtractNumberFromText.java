package practice.strings;

/*
Extract the number of results from the next text using string methods.
Increase the number by 1.
The solution should work for any results number value.
"Found 797 items"
 */

public class ExtractNumberFromText {

    public static void main(String[] args) {

        String text = "Found 797 items";

        int firstSpace =  text.indexOf(" ");
        int secondSpace = text.lastIndexOf(" ");
        String extractedNumber = text.substring(firstSpace+1, secondSpace);

        int increasedNumber = Integer.parseInt(extractedNumber) + 1;

        System.out.println(increasedNumber);
    }
    
}