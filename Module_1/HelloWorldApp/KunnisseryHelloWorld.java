/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
public class KunnisseryHelloWorld {
    /**
     * Method with two arguments, which are used to print the user's first and last name.
     * @param firstName String
     * @param lastName String
     * @return prints the results to the console window.
     */
    public static void myName(String firstName, String lastName) {
        System.out.println(String.format("Hello World from %s %s", firstName, lastName));
    } // end myName
    public static void main(String[] args) {
        myName("Priya Chandran", "Kunnissery"); // Call the myName() method with the values "Priya Chardran" and "Kunnissery"
    } // end main
} // end HelloWorld