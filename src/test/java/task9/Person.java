package task9;

import java.util.Calendar;

public class Person {

    String firstName, lastName;
    int birthYear;
    int currentYear = Calendar.getInstance().get(Calendar.YEAR);
    int MONTHS_IN_ONE_YEAR = 12;

    // constructor
    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // methods
    // name
    public void setFirstName(String firstName)  {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFullName() {
        return getFirstName() + " " + getLastName();
    }

    public void printFullName() {
        System.out.println("Name: " + getFullName());
    }

    // birthdate
    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void printBirthYear() {
        System.out.println("Date of birth: " + getBirthYear());
    }

    // age
    public int getAgeInYears() {
        return currentYear - getBirthYear();
    }

    public int getAgeInMonth() {
        return getAgeInYears() * MONTHS_IN_ONE_YEAR;
    }

    public void printAge() {
        System.out.println("Age: " + getAgeInYears() + " years (" + getAgeInMonth() + " month)");
    }

}
