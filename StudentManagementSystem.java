import java.util.Scanner;

//Student Management System
// ================= ABSTRACT CLASS (Abstraction) =================
abstract class Person {

    protected String name;

    public Person(String name) {
        this.name = name;
    }

    public abstract void displayDetails();
}


// ================= COURSE CLASS =================
class Course {

    private String courseName;

    public Course(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}


// ================= STUDENT CLASS =================
class Student extends Person {

    private int studentId;
    private int marks;
    private Course course;   // Composition (Student HAS-A Course)

    public Student(int studentId, String name, Course course, int marks) {
        super(name);
        this.studentId = studentId;
        this.course = course;
        this.marks = marks;
    }

    // Encapsulation getters/setters
    public int getStudentId() {
        return studentId;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    // Grade calculation
    public String calculateGrade() {
        if (marks >= 70)
            return "A";
        else if (marks >= 60)
            return "B";
        else if (marks >= 50)
            return "C";
        else
            return "Fail";
    }

    // Polymorphism (method overriding)
    @Override
    public void displayDetails() {
        System.out.println("\n===== Student Details =====");
        System.out.println("Student ID: " + studentId);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course.getCourseName());
        System.out.println("Marks: " + marks);
        System.out.println("Grade: " + calculateGrade());
    }
}


// ================= MAIN CLASS =================
public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("===== Student Management System =====");

        // Input details
        System.out.print("Enter Student ID: ");
        int id = input.nextInt();
        input.nextLine();

        System.out.print("Enter Student Name: ");
        String name = input.nextLine();

        System.out.print("Enter Course Name: ");
        String courseName = input.nextLine();

        System.out.print("Enter Marks: ");
        int marks = input.nextInt();

        // Create Course object
        Course course = new Course(courseName);

        // Create Student object
        Student student = new Student(id, name, course, marks);

        // Display
        student.displayDetails();

        input.close();
    }
}
