package classroom;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Classroom {
    private List<Student> students;
    private int capacity;

    public Classroom(int capacity) {
        this.students = new ArrayList<>();
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return this.students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        Student studentExists = this.students.stream()
                .filter(e -> e.firstName.equals(student.firstName) && e.lastName.equals(student.lastName))
                .findFirst().orElse(null);
        if (studentExists != null) {
            return "Student is already in the classroom";
        } else if (this.students.size() < this.capacity && studentExists == null) {
            this.students.add(student);
            return "Added student " + student.firstName + " " + student.lastName;
        } else {
            return "No seats in the classroom";
        }
    }

    public String dismissStudent(Student student) {
        Student studentExists = this.students.stream()
                .filter(e -> e.firstName.equals(student.firstName) && e.lastName.equals(student.lastName))
                .findFirst().orElse(null);
        if (studentExists != null) {
            return "Removed student " + student.firstName + " " + student.lastName;
        } else {
            return "Student not found";
        }
    }

    public String getSubjectInfo(String subject) {
        StringBuilder stringBuilder = new StringBuilder();
        List<Student> studentsInSubject = this.students.stream()
                .filter(e -> e.getBestSubject().equals(subject)).collect(Collectors.toList());

        if (studentsInSubject.size() > 0) {
            stringBuilder.append("Subject: ").append(subject).append(System.lineSeparator());
            stringBuilder.append("Students: ").append(System.lineSeparator());

            for (Student student : studentsInSubject) {
                stringBuilder.append(student.getFirstName()).append(" ")
                        .append(student.getLastName()).append(System.lineSeparator());
            }
            return stringBuilder.toString().trim();
        } else {
            return "No students enrolled for the subject";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        return this.students.stream()
                .filter(e -> e.getFirstName().equals(firstName) && e.getLastName().equals(lastName))
                .findFirst().orElse(null);
    }

    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Classroom size: ").append(this.students.size()).append(System.lineSeparator());

        if (this.students.size() > 0) {
            for (Student student : this.students) {
                stringBuilder.append("==Student: ")
                        .append("First Name= ")
                        .append(student.getFirstName())
                        .append(", ").append("Last Name= ").append(student.getLastName())
                        .append(", Best Subject= ").append(student.getBestSubject())
                        .append(System.lineSeparator());
            }
        }
        return stringBuilder.toString().trim();
    }
}