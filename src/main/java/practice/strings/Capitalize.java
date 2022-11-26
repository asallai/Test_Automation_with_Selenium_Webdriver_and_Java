package practice.strings;

/*
  Write code that capitalize the first letter of first and last name
*/

public class Capitalize {

    public static void main(String[] args) {

        String name = "john doe";

        int index = name.indexOf(' ');

        String firstInitial = name.substring(0, 1);
        firstInitial = firstInitial.toUpperCase();
        String changedFirstName = firstInitial + name.substring(1, index);

        String lastInitial = name.substring(index+1, index+2);
        lastInitial = lastInitial.toUpperCase();
        String changedLastName = lastInitial + name.substring(index+2);

        System.out.println(name);
        System.out.println(changedFirstName + " " + changedLastName);
    }

}
