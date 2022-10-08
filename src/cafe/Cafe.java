package cafe;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Cafe {
    private List<Employee> employees;
    private String name;
    private int capacity;

    public Cafe(String name, int capacity) {
        this.employees = new ArrayList<>();
        this.name = name;
        this.capacity = capacity;
    }

    public void addEmployee(Employee employee) {
        if (this.employees.size() < this.capacity) {
            this.employees.add(employee);
        }
    }

    public boolean removeEmployee(String name) {
        boolean result = this.employees.removeIf(employee -> employee.getName().equals(name));
        return result;
    }

    public Employee getOldestEmployee() {
        return this.employees.stream().max(Comparator.comparing(Employee::getAge)).orElse(null);
    }

    public Employee getEmployee(String name) {
        return this.employees.stream().filter(em -> em.getName().equals(name)).findFirst().orElse(null);
    }

    public int getCount() {
        return this.employees.size();
    }

    public String report() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Employees working at Cafe ").append(this.name).append(System.lineSeparator());
        for (Employee employee : this.employees) {
            stringBuilder.append("Employee: ").append(employee.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString().trim();
    }
}
