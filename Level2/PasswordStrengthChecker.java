package Level2;

import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        if (password.trim().isEmpty()) {
            System.out.println("Please enter a valid password!");
            return;
        }

        int score = 0;
        String feedback = "";

        if (password.length() >= 8) {
            score++;
        } else {
            feedback += "Password should be at least 8 characters\n";
        }

        if (password.matches(".*[A-Z].*")) {
            score++;
        } else {
            feedback += "Add uppercase letters (A-Z)\n";
        }

        if (password.matches(".*[a-z].*")) {
            score++;
        } else {
            feedback += "Add lowercase letters (a-z)\n";
        }

        if (password.matches(".*[0-9].*")) {
            score++;
        } else {
            feedback += "Add numbers (0-9)\n";
        }

        if (password.matches(".*[@#$%^&*!].*")) {
            score++;
        } else {
            feedback += "Add special characters (@#$%^&*!)\n";
        }

        System.out.println("\n--- Result ---");
        if (score == 5) {
            System.out.println("Strength: Very Strong ");
        } else if (score == 4) {
            System.out.println("Strength: Strong ");
        } else if (score == 3) {
            System.out.println("Strength: Medium ");
        } else if (score == 2) {
            System.out.println("Strength: Weak ");
        } else {
            System.out.println("Strength: Very Weak ");
        }

        System.out.println("Score: " + score + "/5");
        System.out.println("\nFeedback:");
        if (feedback.isEmpty()) {
            System.out.println(" Perfect password!");
        } else {
            System.out.println(feedback);
        }

        scanner.close();
    }
}
