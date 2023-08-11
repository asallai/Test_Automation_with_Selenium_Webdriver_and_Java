package practice.strings;

/*
Write code that removes all spaces from a string.
The text may have leading and trailing spaces like this:
text = " aaaa bb cc dddd "
result: "aaaabbccdddd"
 */

public class ConcatString2 {

    public static void main(String[] args) {

        String text = "  ab cd efgh";
        String result = "";
        String str;

        for(int i=0; i < text.length(); i++) {

            str = text.substring(i, i+1);
            if(!str.equals(" ")) {
                result = result.concat(str);
            }
        }
        System.out.println(result);
    }
}
