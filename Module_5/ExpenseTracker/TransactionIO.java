/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_5.ExpenseTracker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class TransactionIO {

    private static final String FILE_NAME = "expenses.txt";
    private static File file = new File(FILE_NAME);

    // Method to bulk insert transactions to the text file
    public static void bulkInsert(ArrayList<Transaction> transactions) throws IOException {
        PrintWriter output = null;
        /* Begin if/else statement based on check of file exists or not. */
        if (file.exists())
        {
            output = new PrintWriter(new FileOutputStream(new File(FILE_NAME), true));
        }
        else
        {
            output = new PrintWriter(FILE_NAME);
        }
        for (Transaction tran : transactions)
        {
            output.print(tran.getDate() + " ");
            output.print(tran.getDescription() + " ");
            output.println(tran.getAmount());
        }
        /* closing the output stream. */
        output.close();
    }

    // Method to find all transactions from the text file
    public static ArrayList<Transaction> findAll() throws IOException {
        ArrayList<Transaction> transactions = new ArrayList<>();
        @SuppressWarnings("resource")
        Scanner input = new Scanner (new File(FILE_NAME));
            while (input.hasNext()) {
                Transaction transaction = new Transaction();
                transaction.setDate(input.next());
                transaction.setDescription(input.next());
                transaction.setAmount(input.nextDouble());
                transactions.add(transaction);
            }
            return transactions;
    }
}