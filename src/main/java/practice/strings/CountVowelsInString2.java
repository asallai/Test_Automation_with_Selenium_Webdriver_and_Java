package practice.strings;

/*
Write code that displays the vowels in a string and count them
 */

public class CountVowelsInString2 {

    public static void main(String[] args) {

        String[] vowels = {"A", "a", "E", "e", "I", "i", "O", "o", "U", "u"};

        String inputString = "Test Automation";
        int numberOfVowels = 0;
        String str;

        for(int i=0; i<inputString.length(); i++) {
            str = inputString.substring(i, i+1);
            for(String v : vowels) {
                if(str.equals(v)) {
                    numberOfVowels++;
                    break;
                }
            }
        }
        System.out.println(numberOfVowels);
    }
}
