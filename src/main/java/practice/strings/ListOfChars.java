package practice.strings;

/*
 * create a list of char values;
 * add to the list 10 different values (vowels, consonants).
 * write code that creates 2 additional lists and populates
 * the first one with all vowels from the initial list and
 * the second one with all consonants from the initial list
 */

import java.util.ArrayList;

public class ListOfChars {

    public static void main(String[] args) {

        ArrayList<String> chars = new ArrayList<>();

        chars.add("A");
        chars.add("l");
        chars.add("e");
        chars.add("x");
        chars.add("V");
        chars.add("a");
        chars.add("n");
        chars.add("c");
        chars.add("o");
        chars.add("u");
        chars.add("v");
        chars.add("e");
        chars.add("r");
        chars.add("C");
        chars.add("a");
        chars.add("n");
        chars.add("a");
        chars.add("d");
        chars.add("a");

        String allVowels = "aeiouAEIOU";
        String currentChar;

        ArrayList<String> vowels = new ArrayList<>();
        ArrayList<String> consonants = new ArrayList<>();

        for (int i=0; i < chars.size(); i++)
        {
            currentChar = chars.get(i);

            if(allVowels.contains(currentChar))
                vowels.add(currentChar);
            else
                consonants.add(currentChar);
        }

        System.out.println("original characters : " + chars );
        System.out.println("vowels : " + vowels );
        System.out.println("consonants : " + consonants );
    }
}
