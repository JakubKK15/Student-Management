import java.util.Scanner;

public class Student {
  private static final int costOfCourse = 600;
  private static int id = 1000;
  private final String firstName;
  private final String lastName;
  private int gradeYear;
  private String courses = "";
  private int studentID;
  private int tuitionBalance = 0;

  // Constructor: prompt to enter student's name and year

  public Student() {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter student first name: ");
    this.firstName = input.nextLine();

    System.out.print("Enter student last name: ");
    this.lastName = input.nextLine();

    getGradeYear();
    setStudentID();
  }

  private void getGradeYear() {
    Scanner input = new Scanner(System.in);
    System.out.print("""
        Enter the student's grade year:
        1) Freshman
        2) Sophomore
        3) Junior
        4) Senior
        Choice:\s""");
    int choice = input.nextInt();
    switch (choice) {
      case 1 -> this.gradeYear = 1;
      case 2 -> this.gradeYear = 2;
      case 3 -> this.gradeYear = 3;
      case 4 -> this.gradeYear = 4;
      default -> {
        System.out.print("Index out of range, enter a correct number.");
        getGradeYear();
      }
    }
  }

  // Generate an ID
  private void setStudentID() {
    // Grade Level + ID
    id++;
    studentID = Integer.parseInt(gradeYear + String.valueOf(id));
  }

  // Enroll in courses
  public void enroll() {
    // Get inside a loop, user hits 0 whet they're done enrolling
    do {
      System.out.print("Enter Course to enroll (Q to quit): ");
      Scanner input = new Scanner(System.in);
      String course = input.nextLine();
      if (!course.equalsIgnoreCase("Q")) {
        courses = courses + "\n" + course;
        tuitionBalance += costOfCourse;
      } else {
        break;
      }
    } while (1 != 0);
  }

  // View balance
  public void viewBalance() {
    System.out.println("Your balance is: " + tuitionBalance);
  }

  //Pay tuition
  public void payTuition() {
    viewBalance();
    Scanner input = new Scanner(System.in);
    System.out.print("How much would you like to pay? $");
    int payment = input.nextInt();
    tuitionBalance -= payment;
    System.out.println("Thank you for your payment of: $" + payment);
    viewBalance();
  }
  // Show status/Student info


  @Override
  public String toString() {
    return "Student{" +
        "firstName='" + firstName + '\'' +
        ", lastName='" + lastName + '\'' +
        ", gradeYear=" + gradeYear +
        ", courses='" + courses + '\'' +
        ", studentID=" + studentID +
        ", tuitionBalance=" + tuitionBalance +
        '}';
  }
}