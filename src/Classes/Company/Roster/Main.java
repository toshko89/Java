package Classes.Company.Roster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> allEmp = new LinkedHashMap();

        while (input-- > 0) {
            String[] newEmployee = scanner.nextLine().split("\\s+");
            String name = newEmployee[0];
            double salary = Double.parseDouble(newEmployee[1]);
            String position = newEmployee[2];
            String department = newEmployee[3];
            if (newEmployee.length == 4) {
                Employee employee = new Employee(name, salary, position, department);
                allEmp.putIfAbsent(department, new ArrayList<>());
                allEmp.get(department).add(employee);
            } else if (newEmployee.length == 5) {
                try {
                    int age = Integer.parseInt(newEmployee[4]);
                    Employee employee = new Employee(name, salary, position, department, "n/a", age);
                    allEmp.putIfAbsent(department, new ArrayList<>());
                    allEmp.get(department).add(employee);
                } catch (Exception e) {
                    String email = newEmployee[4];
                    Employee employee = new Employee(name, salary, position, department, email, -1);
                    allEmp.putIfAbsent(department, new ArrayList<>());
                    allEmp.get(department).add(employee);
                }
            } else if (newEmployee.length == 6) {
                String email = newEmployee[4];
                int age = Integer.parseInt(newEmployee[5]);
                Employee employee = new Employee(name, salary, position, department, email, age);
                allEmp.putIfAbsent(department, new ArrayList<>());
                allEmp.get(department).add(employee);
            }

        }

        String maxDep = null;
        double max = 0;

        for (Map.Entry<String, List<Employee>> entry : allEmp.entrySet()) {
            double currentMax = entry.getValue().stream().mapToDouble(a -> a.salary)
                    .average().getAsDouble();
            if (currentMax > max) {
                max = currentMax;
                maxDep = entry.getKey();
            }
        }

        List<Employee> allSorted = allEmp.get(maxDep).stream()
                .sorted((a, b) -> Double.compare(b.salary, a.salary)).collect(Collectors.toList());
        System.out.println("Highest Average Salary: " + maxDep);

        for (int i = 0; i < allSorted.size(); i++) {
            Employee employees = allSorted.get(i);
            System.out.printf("%s %.2f %s %d%n", employees.name, employees.salary, employees.email, employees.age);
        }
    }

}
