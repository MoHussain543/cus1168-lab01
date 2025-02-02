
import java.util.*;
import java.util.stream.*;

public class StudentStreamLab {
    public static void main(String[] args) {
        // Creating a list of students
        List<Student> students = Arrays.asList(
                new Student("Alice", 3.5, "Junior"),
                new Student("Bob", 3.8, "Senior"),
                new Student("Charlie", 2.9, "Sophomore"),
                new Student("David", 3.1, "Freshman"),
                new Student("Eve", 3.9, "Junior")
        );

        // Filtering: Students with GPA > 3.0
        List<Student> highGPAStudents = students.stream()
                .filter(student -> student.getGPA() > 3.0)
                .collect(Collectors.toList());

        System.out.println("Students with GPA > 3.0:");
        highGPAStudents.forEach(student -> 
            System.out.println(student.getName() + " (" + student.getYear() + ") - GPA: " + student.getGPA())
        );

        // Mapping: Extract names of students with GPA > 3.0
        List<String> highGPAStudentNames = students.stream()
                .filter(student -> student.getGPA() > 3.0)
                .map(Student::getName)
                .collect(Collectors.toList());

        System.out.println("\nHigh GPA student names:");
        highGPAStudentNames.forEach(System.out::println);

        // Reducing: Calculate the average GPA of all students
        OptionalDouble averageGPA = students.stream()
                .mapToDouble(Student::getGPA)
                .average();

        System.out.println("\nAverage GPA: " + (averageGPA.isPresent() ? averageGPA.getAsDouble() : "N/A"));

        // Collecting: Collect all "Junior" students into a list
        List<Student> juniors = students.stream()
                .filter(student -> "Junior".equals(student.getYear()))
                .collect(Collectors.toList());

        System.out.println("\nJuniors:");
        juniors.forEach(student -> 
            System.out.println(student.getName() + " (" + student.getYear() + ") - GPA: " + student.getGPA())
        );
    }
}

class Student {
    private String name;
    private double gpa;
    private String year;

    public Student(String name, double gpa, String year) {
        this.name = name;
        this.gpa = gpa;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public double getGPA() {
        return gpa;
    }

    public String getYear() {
        return year;
    }
}
