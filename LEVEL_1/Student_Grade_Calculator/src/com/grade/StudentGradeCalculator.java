package com.grade;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of grades
        System.out.print("Enter the number of grades to be entered: ");
        int numberOfGrades = 0;
        
        try {
            numberOfGrades = Integer.parseInt(scanner.nextLine());
            if (numberOfGrades <= 0) {
                System.out.println("The number of grades must be a positive integer.");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return;
        }

        // Create an array to store the grades
        double[] grades = new double[numberOfGrades];
        double sum = 0.0;

        // Input each grade
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            try {
                grades[i] = Double.parseDouble(scanner.nextLine());
                if (grades[i] < 0 || grades[i] > 100) {
                    System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
                    i--; // Decrement i to repeat the input for the current grade
                } else {
                    sum += grades[i];
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid grade.");
                i--; // Decrement i to repeat the input for the current grade
            }
        }

        // Calculate the average grade
        double average = sum / numberOfGrades;

        // Display the average grade
        System.out.printf("The average grade is: %.2f%n", average);

        scanner.close();
    }
}
