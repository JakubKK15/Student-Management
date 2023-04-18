import java.util.Scanner;

public class StudentManagement {
  public static void main(String[] args) {


    // Ask how many users we want to add
    System.out.print("Enter number of students to enroll: ");
    Scanner input = new Scanner(System.in);
    int numOfStudents = input.nextInt();
    Student[] students = new Student[numOfStudents];

    // Create n number of new students
    for (int i = 0; i < numOfStudents; i++) {
      students[i] = new Student();
      students[i].enroll();
      students[i].payTuition();
      System.out.println("----------------------------");
    }
    System.out.println(students[0]);
    System.out.println(students[1]);
  }
}
