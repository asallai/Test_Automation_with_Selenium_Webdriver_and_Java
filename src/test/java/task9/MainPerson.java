package task9;

public class MainPerson {

    public static void main(String[] args) {

        // person 1
        System.out.println("Person 1:");

        Person person1 = new Person("Anna", "Jones");

        person1.printFullName();

        person1.setFirstName("Annamarie");
        person1.setLastName("Williams");

        person1.setBirthYear(1988);

        System.out.println("Born as " + person1.getFullName());

        person1.printBirthYear();
        person1.printAge();

        System.out.println();


        // person 2
        System.out.println("Person 2:");

        Person person2 = new Person("John", "Smith");

        person2.printFullName();

        person2.setBirthYear(2002);

        person2.printBirthYear();
        person2.printAge();
    }
}
