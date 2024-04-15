/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_5.ExpenseTracker;

import java.util.Scanner;

public class ValidatorIO {

    // Static method to get an integer from user input
    public static int getInt(Scanner sc, String prompt) {
        int input = 0;
        boolean isValid = false;
        while (!isValid)
        {
            System.out.print(prompt);
            if (sc.hasNextInt())
            {
                input = sc.nextInt();
                isValid = true;
            } else
            {
                System.out.println("\nError! Invalid integer value.\n");
            }
            sc.nextLine(); // Clear the scanner buffer
        }
        return input;
    }

    // Static method to get a double from user input
    public static double getDouble(Scanner sc, String prompt) {
        double input = 0;
        boolean isValid = false;
        while (!isValid) {
            System.out.print(prompt);
            if (sc.hasNextDouble()) {
                input = sc.nextDouble();
                isValid = true;
            } else {
                System.out.println("\nError! Invalid double value.\n");
            }
            sc.nextLine(); // Clear the scanner buffer
        }
        return input;
    }

    // Static method to get a string from user input
    public static String getString(Scanner sc, String prompt) {
        String input = "0";
        boolean isValid = false;
        while(!isValid) {
            System.out.print(prompt);
            if (sc.hasNext()) {
                input = sc.next();
                isValid = true;
            } else
            {
                System.out.println("\n  Error! Invalid input.\n");
            }
            sc.nextLine(); // Clear the scanner buffer
        }
        return input;
    }
}