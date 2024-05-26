package Random.Password;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the desired length of the password
        System.out.print("Enter the desired length of the password: ");
        int length = 0;
        try {
            length = Integer.parseInt(scanner.nextLine());
            if (length <= 0) {
                System.out.println("Length must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        // Prompt the user to specify whether the password should include numbers, lowercase letters, uppercase letters, and special characters
        System.out.print("Should the password include numbers? (y/n): ");
        boolean includeNumbers = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Should the password include lowercase letters? (y/n): ");
        boolean includeLowercaseLetters = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Should the password include uppercase letters? (y/n): ");
        boolean includeUppercaseLetters = scanner.nextLine().equalsIgnoreCase("y");

        System.out.print("Should the password include special characters? (y/n): ");
        boolean includeSpecialCharacters = scanner.nextLine().equalsIgnoreCase("y");

        // Ensure at least one character type is selected
        if (!includeNumbers && !includeLowercaseLetters && !includeUppercaseLetters && !includeSpecialCharacters) {
            System.out.println("At least one character type must be selected.");
            return;
        }

        // Generate the password accordingly
        String password = generatePassword(length, includeNumbers, includeLowercaseLetters, includeUppercaseLetters, includeSpecialCharacters);

        // Display the password to the user
        System.out.println("Your password is: " + password);
    }

    private static String generatePassword(int length, boolean includeNumbers, boolean includeLowercaseLetters, boolean includeUppercaseLetters, boolean includeSpecialCharacters) {
        // Create a string containing all of the possible characters for the password
        StringBuilder allCharacters = new StringBuilder();
        if (includeNumbers) {
            allCharacters.append("0123456789");
        }
        if (includeLowercaseLetters) {
            allCharacters.append("abcdefghijklmnopqrstuvwxyz");
        }
        if (includeUppercaseLetters) {
            allCharacters.append("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        }
        if (includeSpecialCharacters) {
            allCharacters.append("!@#$%^&*()_+-=");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(allCharacters.length());
            password.append(allCharacters.charAt(index));
        }

        return password.toString();
    }
}
