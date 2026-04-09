import java.util.*;

// Course class
class Course {
    String courseId;
    String courseName;

    Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }
}

// Student class
class Student {
    String studentId;
    String name;
    List<Course> enrolledCourses;

    Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.enrolledCourses = new ArrayList<>();
    }

    void enrollCourse(Course course) {
        enrolledCourses.add(course);
        System.out.println(name + " enrolled in " + course.courseName);
    }

    void viewCourses() {
        System.out.println("Courses for " + name + ":");
        if (enrolledCourses.isEmpty()) {
            System.out.println("No courses enrolled.");
        } else {
            for (Course c : enrolledCourses) {
                System.out.println(c.courseId + " - " + c.courseName);
            }
        }
    }
}

// Main system class
public class CollegeSystem {
    static Map<String, Student> students = new HashMap<>();
    static Map<String, Course> courses = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- College Registration System ---");
            System.out.println("1. Add Student");
            System.out.println("2. Add Course");
            System.out.println("3. Enroll Student in Course");
            System.out.println("4. View Student Courses");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    addCourse();
                    break;
                case 3:
                    enrollStudent();
                    break;
                case 4:
                    viewStudentCourses();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }

    static void addStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        students.put(id, new Student(id, name));
        System.out.println("Student added successfully.");
    }

    static void addCourse() {
        System.out.print("Enter Course ID: ");
        String id = sc.nextLine();
        System.out.print("Enter Course Name: ");
        String name = sc.nextLine();

        courses.put(id, new Course(id, name));
        System.out.println("Course added successfully.");
    }

    static void enrollStudent() {
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();
        System.out.print("Enter Course ID: ");
        String cid = sc.nextLine();

        Student student = students.get(sid);
        Course course = courses.get(cid);

        if (student != null && course != null) {
            student.enrollCourse(course);
        } else {
            System.out.println("Invalid Student ID or Course ID.");
        }
    }

    static void viewStudentCourses() {
        System.out.print("Enter Student ID: ");
        String sid = sc.nextLine();

        Student student = students.get(sid);

        if (student != null) {
            student.viewCourses();
        } else {
            System.out.println("Student not found.");
        }
    }
}