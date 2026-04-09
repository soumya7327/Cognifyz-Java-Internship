
    import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

       
        System.out.print("Enter password length: ");
        int length = scanner.nextInt();

        System.out.print("Include numbers? (y/n): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include lowercase letters? (y/n): ");
        boolean includeLower = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include uppercase letters? (y/n): ");
        boolean includeUpper = scanner.next().equalsIgnoreCase("y");

        System.out.print("Include special characters? (y/n): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("y");

        String pool = "";
        if (includeNumbers) pool += "0123456789";
        if (includeLower)   pool += "abcdefghijklmnopqrstuvwxyz";
        if (includeUpper)   pool += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (includeSpecial) pool += "@#$%^&*!";

        if (pool.isEmpty()) {
            System.out.println("No characters selected! Please try again.");
            return;
        }

        String password = "";
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(pool.length());
            password += pool.charAt(index);
        }

        System.out.println("\n Generated Password: " + password);
        scanner.close();
    }
}

