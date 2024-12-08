import java.util.Scanner;

/**
 * TemperatureConverter - A Java program to convert temperatures
 * between Celsius and Fahrenheit with replay option.
 *
 * @author Derrick Oware
 */
public class TemperatureConvertor {
    public static void main(String[] args) {
        // Create a Scanner object for user input
        Scanner scanner = new Scanner(System.in);

        // Flag to control the game loop
        boolean playAgain = true;

        // Main game loop
        while (playAgain) {
            // Welcome message
            System.out.println("Welcome to the Temperature Converter!");

            // Display conversion options
            System.out.println("Please select a conversion option:");
            System.out.println("1. Convert Celsius to Fahrenheit ℉");
            System.out.println("2. Convert Fahrenheit to Celsius ℃");
            System.out.println("\n");

            // Variable to store user's choice
            int choice = 0;

            // Input validation for conversion choice
            while (true) {
                System.out.print("Enter your choice (1 or 2): \n");

                // Check if the input is an integer
                if (scanner.hasNextInt()) {
                    choice = scanner.nextInt();

                    // Validate choice is either 1 or 2
                    if (choice == 1 || choice == 2) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please enter 1 or 2.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.\n");
                    scanner.next(); // Clear the invalid input
                }
            }

            // Variable to store temperature
            double temperature = 0.0;

            // Input validation for temperature
            while (true) {
                System.out.print("Enter the temperature: \n");

                // Check if the input is a number
                if (scanner.hasNextDouble()) {
                    temperature = scanner.nextDouble();

                    // Optional: Add reasonable temperature range validation
                    if (choice == 1 && temperature < -273.15) {
                        System.out.println("Temperature below absolute zero for Celsius is invalid.\n");
                        continue;
                    } else if (choice == 2 && temperature < -459.67) {
                        System.out.println("Temperature below absolute zero for Fahrenheit is invalid.\n");
                        continue;
                    }

                    break;
                } else {
                    System.out.println("Invalid input. Please enter a valid number.\n");
                    scanner.next(); // Clear the invalid input
                }
            }

            // Perform temperature conversion
            double result;
            String fromUnit, toUnit;

            if (choice == 1) {
                // Celsius to Fahrenheit
                result = (temperature * 9.0/5.0) + 32;
                fromUnit = "Celsius";
                toUnit = "Fahrenheit";
            } else {
                // Fahrenheit to Celsius
                result = (temperature - 32) * 5.0/9.0;
                fromUnit = "Fahrenheit";
                toUnit = "Celsius";
            }

            // Display the result with formatting
            System.out.printf("%.2f %s is equal to %.2f %s%n",
                    temperature, fromUnit, result, toUnit);

            // Ask if user wants to play again
            while (true) {
                System.out.print("Do you want to convert another temperature? (yes/no): \n");
                String playResponse = scanner.next().toLowerCase();

                if (playResponse.equals("yes") || playResponse.equals("y")) {
                    break; // Continue the outer loop
                } else if (playResponse.equals("no") || playResponse.equals("n")) {
                    playAgain = false;
                    System.out.println("Thank you for using the Temperature Converter. Goodbye!");
                    break; // Exit the outer loop
                } else {
                    System.out.println("Invalid input. Please enter 'yes' or 'no'.\n");
                }
            }
        }

        // Close the scanner
        scanner.close();
    }
}
