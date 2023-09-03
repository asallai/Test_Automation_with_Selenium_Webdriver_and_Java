package practice.strings;

public class CountSpecialInitial {

    public static void main(String[] args) {

        String[] strings = {"apple", "Word", "word", "dog", "World"};

        char initial = 'W';
        int numberOfInitials = 0;

        for(String s: strings) {
            if(s.charAt(0) == initial)
                numberOfInitials++;

            System.out.println(s + " " + numberOfInitials);
        }

        System.out.println("Number of W initials: " + numberOfInitials);
    }
}
