package Level2;

import java.io.*;
import java.util.Scanner;

public class FileEncryptionDecryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

       
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        System.out.print("Choose option (1/2): ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter input file name  (with .txt): ");
        String inputFile = scanner.nextLine();

        System.out.print("Enter output file name: ");
        String outputFile = scanner.nextLine();

        int shift = 3;

        try {
           
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String result = "";
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);

                    if (Character.isLetter(c)) {
                        char base = Character.isUpperCase(c) ? 'A' : 'a';
                        if (choice == 1) {
                            // Encrypt
                            c = (char) ((c - base + shift) % 26 + base);
                        } else {
                            // Decrypt
                            c = (char) ((c - base - shift + 26) % 26 + base);
                        }
                    }
                    result += c;
                }
                writer.write(result);
                writer.newLine();
            }

            reader.close();
            writer.close();

            if (choice == 1) {
                System.out.println("\n File Encrypted Successfully!");
            } else {
                System.out.println("\n File Decrypted Successfully!");
            }
            System.out.println("Output saved to: " + outputFile);

        } catch (FileNotFoundException e) {
            System.out.println(" File not found: " + inputFile);
        } catch (IOException e) {
            System.out.println(" Error: " + e.getMessage());
        }

        scanner.close();
    }
}