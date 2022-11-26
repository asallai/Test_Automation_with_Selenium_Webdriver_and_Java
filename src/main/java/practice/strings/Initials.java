package practice.strings;

/*
  Write code that computes the initials from the full name and displays them
*/

public class Initials {

    public static void main(String[] args) {

        String name = "John Doe";

        int index = name.indexOf(' ');

        String firstName = name.substring(0, index);
        String lastName = name.substring(index+1);

        char firstNameInitial = firstName.charAt(0);
        char lastNameInitial = lastName.charAt(0);

        System.out.println(name);
        System.out.println(firstNameInitial + " " + lastNameInitial);
    }

}