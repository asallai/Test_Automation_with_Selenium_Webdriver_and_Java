package practice.strings;

public class Capitalize2 {

    public static void main(String[] args) {

        String name = "john doe";

        int index = name.indexOf(" ");

        String firstInitial = name.substring(0, 1);
        firstInitial = firstInitial.toUpperCase();
        String changedFirstName = firstInitial + name.substring(1, index);

        String lastInitial = name.substring(index+1, index+2);
        lastInitial = lastInitial.toUpperCase();
        String changedLastName = lastInitial + name.substring(index+2);

        System.out.println(changedFirstName + " " + changedLastName);

    }
}
