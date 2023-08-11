package practice.strings;

/*
Write code that displays the vowels in a string and count them
 */

public class CountVowelsInString {

    public static void main(String[] args) {

        String text = "Apple computer";
        System.out.println(text);

        String[] vowels = { "A", "a", "E", "e", "I", "i", "O", "o", "U", "u"};

        int numberOfVowels = 0;

        for(int i=0;i < text.length(); i++) {
            String str = text.substring(i, i+1);
            for(String v: vowels) {
                if(str.equals(v)) {
                    System.out.print(v + " ");
                    numberOfVowels++;
                    break;
                }
            }
        }
        System.out.println("\nNumber of vowels = " + numberOfVowels);
    }
}