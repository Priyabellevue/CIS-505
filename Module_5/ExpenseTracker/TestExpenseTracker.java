/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_5.ExpenseTracker;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class TestExpenseTracker {

    /* Display the menu. */
    public static String menu(){
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. View Transactions");
        System.out.println("    2. Add Transactions");
        System.out.println("    3. View Expense");
        System.out.print("\n  Please choose an option: ");
        return " ";
    }
    /* main method that allows the program to run & throws an IO Exception. */
    public static void main(String[] args) throws IOException{
        /* This is an attribute defined outside the if/else if/else... statements to simplify code. */
        ArrayList<Transaction> transactions = new ArrayList<>();

        System.out.println("");
        System.out.println("  Welcome to the Expense Tracker");
        System.out.println("");
        do{ /* Begin do... while loop to allow user to continue for as long as they like. */
            Scanner sc = new Scanner(System.in);
            int input = ValidatorIO.getInt(sc, menu()); /* This validates user input. */
            /* Begin if... else if... statement to attest to the three possibilities in the menu. */
            if (input == 1){
                System.out.println("\n  MONTHLY EXPENSES\n");
                ArrayList<Transaction> trans = TransactionIO.findAll();
                for (Transaction t:trans){
                    System.out.println(t);
                    System.out.println();
                }  /* This should show all transactions in file. */
            } else if (input == 2){ /* This allows the user to enter any number of transactions. */
                String c = "y";

                while (c.equalsIgnoreCase("y")){
                    SimpleDateFormat simpleDate = new SimpleDateFormat("MM-dd-yyyy");
                    String date = simpleDate.format(new Date());

                    String description = ValidatorIO.getString(sc, "\n  Enter the description: ");
                    double amount = ValidatorIO.getDouble(sc, "  Enter the amount: ");

                    Transaction transaction = new Transaction();
                    transaction.setDate(date);
                    transaction.setDescription(description);
                    transaction.setAmount(amount);

                    transactions.add(transaction);

                    c = ValidatorIO.getString(sc, "\n  Add another transaction? (y/n): ");
                }try{ /* This tries the add those transactions to the file. */
                    TransactionIO.bulkInsert(transactions);
                } catch (IOException e){ /* This catches an exception if its made. */
                    System.out.println("\n  Exception: " + e.getMessage());
                }
            } else if (input == 3){ /* This displays monthly expenses. */
                double monthlyExpense = 0;
                transactions = TransactionIO.findAll();
                for (Transaction transaction : transactions){
                    monthlyExpense += transaction.getAmount();
                }
                System.out.println("\n  Your total monthly expense is "+ String.format("$%6.2f", monthlyExpense));
            } else if (input != 1|| input !=2||input !=3){ /* This throws an error if the user does not input 1, 2, or 3. */
                System.out.print("  Error! Invalid option.");
            } /* This allows the user to choose to continue if they wish. */
            System.out.print("  Continue? (y/n): ");
            @SuppressWarnings("resource")
            Scanner userContinue = new Scanner(System.in);
            String continueChoice = userContinue.next();
            System.out.println("");
            if (continueChoice.equalsIgnoreCase("n")){
                System.out.println("");
                System.out.println("  Program terminated by user...");
                System.out.println("");
                break;
            } else if (continueChoice.equalsIgnoreCase("y")){
                continue;
            }
        } while (true); /* This continues the loop if the conditions are met. */
    }
}/* End TestExpenseTrackerApp. */