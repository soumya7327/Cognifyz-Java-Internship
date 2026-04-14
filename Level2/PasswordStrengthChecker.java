package Level2;

import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a password to check its strength: ");
        String password = scanner.nextLine();
        
        String strength = checkPasswordStrength(password);
        System.out.println("Password strength: " + strength);
        
        scanner.close();
    }

    public static String checkPasswordStrength(String password) {
        int length = password.length();
        boolean hasUpper = false;
        boolean hasLower = false;
        boolean hasDigit = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isUpperCase(c)) hasUpper = true;
            else if (Character.isLowerCase(c)) hasLower = true;
            else if (Character.isDigit(c)) hasDigit = true;
            else if (!Character.isWhitespace(c)) hasSpecial = true;
        }

        if (length < 8) {
            return "Weak (too short)";
        } else if (!hasUpper || !hasLower || !hasDigit) {
            return "Medium (missing uppercase, lowercase, or digit)";
        } else if (!hasSpecial) {
            return "Strong (but consider adding special characters)";
        } else {
            return "Very Strong";
        }
    }
}
