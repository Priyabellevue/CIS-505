/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_3.CustomerAccountApp;

public class Customer {
    private String name;
    private String address;
    private String city;
    private String zip;

    // no-argument constructor for default customer
    public Customer() {
        this.name = "Default";
        this.address = "";
        this.city = "";
        this.zip = "";
    }

    // argument constructor for to create a new customer
    public Customer(String name, String address, String city, String zip) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.zip = zip;
    }

    // accessor methods to accept the data fields
    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getCity() {
        return this.city;
    }

    public String getZip() {
        return this.zip;
    }

    // override the toString() method
    @Override
    public String toString() {
        return "  Name: " + this.name + "\n" +
                "  Address: " + this.address + "\n" +
                "  City: " + this.city + "\n" +
                "  Zip: " + this.zip;
    }
}