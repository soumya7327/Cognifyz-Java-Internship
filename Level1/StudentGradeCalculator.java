
    import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Enter number of grades: ");
        int count = scanner.nextInt();

        double total = 0;

        for (int i = 1; i <= count; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = scanner.nextDouble();
            total = total + grade;
        }

        double average = total / count;

        System.out.println("\n--- Result ---");
        System.out.println("Total Marks : " + total);
        System.out.println("Average     : " + average);

        // Letter grade
        if (average >= 90) {
            System.out.println("Letter Grade: A ");
        } else if (average >= 80) {
            System.out.println("Letter Grade: B ");
        } else if (average >= 70) {
            System.out.println("Letter Grade: C ");
        } else if (average >= 60) {
            System.out.println("Letter Grade: D ");
        } else {
            System.out.println("Letter Grade: F ");
        }

        scanner.close();
    }

}
