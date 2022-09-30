package Classes.Company.Roster;

public class Employee {
    String name;
    double salary;
    String position;
    String department;
    String email;
    int age;

    public Employee(String name, double salary, String position, String department, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.department = department;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String department){
        this(name,salary,position,department,"n/a",-1);
    }

}
