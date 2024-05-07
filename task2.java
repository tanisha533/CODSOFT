import java.util.Scanner;

public class task2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("STUDENT GRADE CALCULATOR");

        System.out.print("Enter the number of subjects (between 4 and 7): ");
        int numOfSubjects = sc.nextInt();
        if (numOfSubjects < 4 || numOfSubjects > 7) {
            System.out.println("Number of subjects should be between 4 and 7. Please run the program again.");
            return;
        }

        int totalMarks = 0;
        for (int i = 1; i <= numOfSubjects; i++) {
            int marks;
            do {
                System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
                marks = sc.nextInt();
                if (marks < 0 || marks > 100) {
                    System.out.println("Marks should be between 0 and 100. Please try again.");
                }
            } while (marks < 0 || marks > 100);
            totalMarks += marks;
        }

        double averagePercentage = (double) totalMarks / numOfSubjects;

        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + averagePercentage + "%");

        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 80) {
            grade = "B";
        } else if (averagePercentage >= 70) {
            grade = "C";
        } else if (averagePercentage >= 60) {
            grade = "D";
        } else {
            grade = "F";
        }

        System.out.println("Grade: " + grade);
    }
}
