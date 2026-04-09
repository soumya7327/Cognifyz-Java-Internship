
 import java.util.Scanner;
public class TemperatureConverter {
       public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter temperature value: ");
        double temperature = scanner.nextDouble();

        System.out.println("Select unit to convert FROM:");
        System.out.println("1. Celsius (C)");
        System.out.println("2. Fahrenheit (F)");
        System.out.print("Enter choice (C/F): ");
        String unit = scanner.next().toUpperCase();

        if (unit.equals("C")) {
            double fahrenheit = (temperature * 9 / 5) + 32;
            System.out.println(temperature + "°C = " + fahrenheit + "°F");
        } else if (unit.equals("F")) {
            double celsius = (temperature - 32) * 5 / 9;
            System.out.println(temperature + "°F = " + celsius + "°C");
        } else {
            System.out.println("Invalid unit entered!");
        }

        scanner.close();
    }
}

