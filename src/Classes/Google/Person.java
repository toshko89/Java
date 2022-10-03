package Classes.Google;

import java.util.ArrayList;
import java.util.List;

public class Person {
    String name;
    Company company;
    List<Pokemon> pokemon = new ArrayList<>();
    List<Parents> parents = new ArrayList<>();
    List<Children> children = new ArrayList<>();
    Car car;

    static class Company{
        String companyName;
        String department;
        double salary;

        public Company(String companyName, String department, double salary) {
            this.companyName = companyName;
            this.department = department;
            this.salary = salary;
        }
    }

    static class Pokemon{
        String pokemonName;
        String pokemonType;

        public Pokemon(String pokemonName, String pokemonType) {
            this.pokemonName = pokemonName;
            this.pokemonType = pokemonType;
        }
    }

    static class Parents{
        String parentName;
        String parentBirthday;

        public Parents(String parentName, String parentBirthday) {
            this.parentName = parentName;
            this.parentBirthday = parentBirthday;
        }
    }

    static class Children{
        String childName;
        String childBirthday;

        public Children(String childName, String childBirthday) {
            this.childName = childName;
            this.childBirthday = childBirthday;
        }
    }

    static class Car{
        String carModel;
        String speed;

        public Car(String carModel, String speed) {
            this.carModel = carModel;
            this.speed = speed;
        }
    }

//    public Person(String name, Company company, Pokemon pokemon, Parents parents, Children children, Car car) {
//        this.name = name;
//        this.company = company;
//        this.pokemon.add(pokemon);
//        this.parents.add(parents);
//        this.children.add(children);
//        this.car = car;
//    }
}
