/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/

package Module_3.CustomerAccountApp;

public class CustomerDB {
    public static Customer getCustomer(Integer id) {
        Customer customer;
        if (id == 1007) {
            customer = new Customer("Jennifer Patterson", "8422 Grover Ave.", "Bellevue", "68123");
        } else if (id == 1008) {
            customer = new Customer("Shiru Jackson", "93625 Poppleton Plz", "Omaha", "68106");
        } else if (id == 1009) {
            customer = new Customer("Chris Atherton", "2814 Ridgewood St", "Olathe", "44124");
        } else {
            customer = new Customer("Default", "", "", "");
        }
        return customer;
    }
}
