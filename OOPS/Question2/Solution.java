public class Solution{
    public static void main(String[] args) {

        System.out.println("=== UNIVERSITY STUDENT MANAGEMENT SYSTEM ===\n");

        University.displayUniversityInfo();

        Student alice = new Student("Alice Johnson", "Computer Science");
        Student bob = new Student("Bob Smith", "Mathematics", 3.2);
        Student carol = new Student("Carol Davis", "Physics", 3.8);

        alice.enrollCourse(3);
        alice.updateGPA(3.7, 3);

        bob.enrollCourse(4);
        bob.updateGPA(3.9, 4);

        carol.enrollCourse(3);
        carol.updateGPA(3.6, 3);

        alice.displayStudentInfo();
        bob.displayStudentInfo();
        carol.displayStudentInfo();

        University.updateAcademicYear("2025-2026");

        System.out.println("Is GPA 1.5 passing? " + University.isPassingGrade(1.5));
        System.out.println("Is GPA 2.5 passing? " + University.isPassingGrade(2.5));
        System.out.println();

        System.out.println("University Total Students : " + University.getTotalStudents());
        System.out.println("Student 1 Courses : " + alice.getCoursesEnrolled());
        System.out.println("Student 2 Courses : " + bob.getCoursesEnrolled());
        System.out.println();

        University.displayUniversityInfo();
    }
}
 class University {

    public static int totalStudents = 0;
    public static final String UNIVERSITY_CODE = "UNI-2024";
    public static String currentAcademicYear = "2024-2025";
    public static double minPassingGrade = 2.0;

    static {
        System.out.print("University class loaded and initialized ");
        System.out.println("Setting up university system...");
    }

    public static void displayUniversityInfo() {
        System.out.println();
        System.out.println("=== UNIVERSITY INFORMATION ===");
        System.out.println("University Code: " + UNIVERSITY_CODE);
        System.out.println("Academic Year: " + currentAcademicYear);
        System.out.println("Total Students: " + totalStudents);
        System.out.println("Minimum Passing Grade: " + minPassingGrade);
        System.out.println();
    }

    public static void updateAcademicYear(String newAcademicYear) {
        currentAcademicYear = newAcademicYear;
        System.out.println("Academic year updated to: " + currentAcademicYear);
        System.out.println();
    }

    public static boolean isPassingGrade(double gpa) {
        return gpa >= minPassingGrade;
    }

    public static int getTotalStudents() {
        return totalStudents;
    }
}

class Student {

    static {
        System.out.println("Student class loaded and initialized");
    }

    private static int nextStudentNumber = 1000;

    private String studentId;
    private String name;
    private String major;
    private double gpa;
    private int coursesEnrolled;

    {
        System.out.println();
        System.out.println("Creating a new student object...");
        this.coursesEnrolled = 0;
        this.gpa = 0.0;
    }

    public Student(String name, String major) {
        this.name = name;
        this.major = major;
        this.studentId = "STU-" + nextStudentNumber++;
        University.totalStudents++;
        System.out.println("Student created: " + this.studentId);
    }

    public Student(String name, String major, double initialGpa) {
        this(name, major);
        this.gpa = initialGpa;
    }

    public void displayStudentInfo() {
        System.out.println();
        System.out.println("=== STUDENT INFORMATION ===");
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Name: " + this.name);
        System.out.println("Major: " + this.major);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Courses Enrolled: " + this.coursesEnrolled);
        System.out.println("Passing Status: " + (University.isPassingGrade(this.gpa) ? "PASSING" : "FAILING"));
        System.out.println("Dean's List: " + (this.isOnDeansList() ? "YES" : "NO"));
        System.out.println();
    }

    public void updateGPA(double newGrade, int creditHours) {
        this.gpa = newGrade;
        System.out.println(this.name + "'s GPA updated to: " + this.gpa);
        System.out.println();
    }

    public void enrollCourse(int creditHours) {
        this.coursesEnrolled += creditHours;
        System.out.println(this.name + " enrolled in a " + creditHours + " credit hour course");
        System.out.println();
    }

    public boolean isOnDeansList() {
        return this.gpa >= 3.5;
    }

    public int getCoursesEnrolled() {
        return this.coursesEnrolled;
    }
}

