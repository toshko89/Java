package Classes.Google;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Person newPerson = new Person();
        Map<String, Person> allPeople = new LinkedHashMap<>();

        while (!input.equals("End")) {
            String[] command = input.split(" ");
            String name = command[0];
            if (!allPeople.containsKey(name)) {
                newPerson = new Person();
                newPerson.name = name;
                allPeople.put(name, newPerson);
            } else {
                newPerson = allPeople.get(name);
            }
            String currentInput = command[1];
            if (currentInput.equals("company")) {
                String companyName = command[2];
                String department = command[3];
                double salary = Double.parseDouble(command[4]);
                Person.Company newCompany = new Person.Company(companyName, department, salary);
                newPerson.company = newCompany;
            } else if (currentInput.equals("pokemon")) {
                String pokemonName = command[2];
                String pokemonType = command[3];
                Person.Pokemon newPokemon = new Person.Pokemon(pokemonName, pokemonType);
                newPerson.pokemon.add(newPokemon);
            } else if (currentInput.equals("parents")) {
                String parentName = command[2];
                String parentBirthday = command[3];
                Person.Parents newParent = new Person.Parents(parentName, parentBirthday);
                newPerson.parents.add(newParent);
            } else if (currentInput.equals("children")) {
                String childName = command[2];
                String childBirthday = command[3];
                Person.Children newChild = new Person.Children(childName, childBirthday);
                newPerson.children.add(newChild);
            } else if (currentInput.equals("car")) {
                String carModel = command[2];
                String carSpeed = command[3];
                Person.Car newCar = new Person.Car(carModel, carSpeed);
                newPerson.car = newCar;
            }
            allPeople.put(name, newPerson);
            input = scanner.nextLine();
        }

        input = scanner.nextLine();
        Person person = allPeople.get(input);
        print(person);

    }

    private static void print(Person person) {
        System.out.println(person.name);
        System.out.println("Company:");
        if (person.company != null) {
            System.out.printf("%s %s %.2f%n", person.company.companyName, person.company.department, person.company.salary);
        }
        System.out.println("Car:");
        if (person.car != null) {
            System.out.printf("%s %s%n", person.car.carModel, person.car.speed);
        }
        System.out.println("Pokemon:");
        if (person.pokemon.size() > 0) {
            for (Person.Pokemon pokemon : person.pokemon) {
                System.out.printf("%s %s%n", pokemon.pokemonName, pokemon.pokemonType);
            }
        }
        System.out.println("Parents:");
        if (person.parents.size() > 0) {
            for (Person.Parents parent : person.parents) {
                System.out.printf("%s %s%n", parent.parentName, parent.parentBirthday);
            }
        }
        System.out.println("Children:");
        if (person.children.size() > 0) {
            for (Person.Children child : person.children) {
                System.out.printf("%s %s%n", child.childName, child.childBirthday);
            }
        }
    }

}
