package practice;

public class Palindrome {

       String text = "radar";

       boolean isPalindrome(String text) {

            int length = text.length();
            int forward = 0;
            int backward = length - 1;

            while (backward > forward) {

                char forwardChar = text.charAt(forward);
                char backwardChar = text.charAt(backward);

                if (forwardChar != backwardChar)
                    return false;

                forward++;
                backward++;
            }
            return true;
       }
}
