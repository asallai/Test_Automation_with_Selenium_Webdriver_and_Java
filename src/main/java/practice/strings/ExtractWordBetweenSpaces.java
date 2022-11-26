package practice.strings;

/*
Having a text with 5 words, extract the word between the second and third spaces.
The solution should work for any text with 5 words.
"Java for Dummies Quick Reference"
Result: Dummies
 */

public class ExtractWordBetweenSpaces {

    public static void main(String[] args) {

        String text = "Java for Dummies Quick Reference";
        char separator = ' ';

        int firstSpace = text.indexOf(separator);
        int secondSpace = text.indexOf(separator, firstSpace+1);
        int thirdSpace = text.indexOf(separator, secondSpace+1);

        System.out.println(text.substring(secondSpace+1, thirdSpace));
    }

}
