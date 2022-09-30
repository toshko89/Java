package Classes.Person;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Person> allPeople = new ArrayList<>();

        while (n-- > 0) {
            String[] newPerson = scanner.nextLine().split(" ");
            String name = newPerson[0];
            int age = Integer.parseInt(newPerson[1]);
            Person newRecord = new Person(name, age);
            allPeople.add(newRecord);
        }

        allPeople =
                allPeople.stream().sorted((x1, x2) -> x1.name.compareTo(x2.name))
                        .filter(person -> person.age > 30).collect(Collectors.toList());
        for (Person person : allPeople) {
            System.out.println(person.name + " - " + person.age);
        }
    }
}
