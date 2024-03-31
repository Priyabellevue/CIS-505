/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_3.CustomerAccountApp;

import java.text.SimpleDateFormat;
import java.util.Date;
//import java.util.Scanner;

public class Account {
    private double balance = 200.0;

    public double getBalance() {
        return balance;
    }

    public void deposit(double amt) {
        balance += amt;
        }

    public void withdraw(double amt) {
        if (balance >= amt) {
            balance -= amt;
            }
        }

    public void displayMenu() {
        System.out.println("  Account Menu");
        System.out.println("  Enter <D/d> for deposit");
        System.out.println("  Enter <W/w> for withdraw");
        System.out.println("  Enter <B/b> for balance");
        System.out.print("      Enter option>: ");
    }

    public String getTransactionDate() {
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("MM-dd-yyyy");
        return formatter.format(date);
    }
    
}
