package Classes.Company.Roster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private List<Employee> employees;
    private String departmentName;

    public Department() {
        this.employees = new ArrayList<>();
    }

    public void addNewEmpoyee(Employee person) {
        employees.add(person);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public double getAverageSalary() {
        return employees.stream().mapToDouble(a -> a.salary)
                .average().getAsDouble();
    }

}
