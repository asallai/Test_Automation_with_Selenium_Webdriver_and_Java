package practice.strings;

/*
Write code that removes all spaces from a string.
The text may have leading and trailing spaces like this:
text = " aaaa bb cc dddd "
result: "aaaabbccdddd"
 */

public class ConcatString {

    public static void main(String[] args) {

        String text = " aaaa bb cc dddd ";

        String resultText = "";

        for(int i=0; i < text.length(); i++) {
            String str = text.substring(i, i+1);
            if( !str.equals(" ") ) {
                resultText = resultText.concat(str);
            }
        }
        System.out.println(resultText);
    }

}
