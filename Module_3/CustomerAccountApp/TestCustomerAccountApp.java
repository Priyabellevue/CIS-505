/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_3.CustomerAccountApp;

import java.util.Scanner;

public class TestCustomerAccountApp {

    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        System.out.println("\n  Welcome to the Customer Account App");
        
        // Prompt user to enter a customer ID between 1007 and 1009
        System.out.println("\n  Enter a Customer ID:");
        System.out.print("    ex: 1007, 1008, 1009>: ");
        int id = input.nextInt();
        
        // Retrieve customer information from CustomerDB
        Customer customer = CustomerDB.getCustomer(id);

        // Display account menu
        Account account = new Account();
                
        char option;
        do {
            // Prompt user to select an option
            System.out.println(" ");
            account.displayMenu();
            option = input.next().charAt(0);
            
            switch (option) {
                case 'd':
                case 'D':
                    // Deposit
                    System.out.print("\n  Enter deposit amount: ");
                    double depositAmt = input.nextDouble();
                    account.deposit(depositAmt);
                    break;
                case 'w':
                case 'W':
                    // Withdraw
                    System.out.print("\n  Enter withdraw amount: ");
                    double withdrawAmt = input.nextDouble();
                    account.withdraw(withdrawAmt);
                    break;
                case 'b':
                case 'B':
                    // Balance
                    System.out.printf("\n  Account balance: $%,6.2f\n", account.getBalance());
                    break;
                default:
                    // Invalid option
                    System.out.println("\n  Error: Invalid option");
                    break;
            }
            
            // Prompt user to continue or exit the menu
            System.out.print("\n  Continue? (y/n): ");
            option = input.next().charAt(0);
            
        } while (option == 'y' || option == 'Y');
        
        // Display customer details and account balance
        System.out.println("\n  --Customer Details--");
        System.out.println(customer.toString());
        System.out.printf("\n  Balance as of %s is $%,6.2f\n", account.getTransactionDate(), account.getBalance());
        System.out.println("\n  End of line...");
        // Close Scanner
        input.close();
        
    }

}