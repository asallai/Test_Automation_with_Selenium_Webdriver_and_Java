package practice.strings;

/*
Write code that reverses a string
text = "abcdefghij"
result = "jihgfedcba"
 */

public class ReverseString {

    public static void main(String[] args) {

        String text = "abcdefghij";

        for(int i=text.length()-1; i>=0; i--) {
            System.out.print(text.charAt(i));
        }
    }

}
