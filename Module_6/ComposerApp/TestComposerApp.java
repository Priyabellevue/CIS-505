import java.util.Scanner;

public class TestComposerApp { /* Begin TestComposerApp class. */
    public static void displayMenu(){ /* This method displays a menu to the user. */
        System.out.println("  MENU OPTIONS");
        System.out.println("    1. View Composers");
        System.out.println("    2. Find Composer");
        System.out.println("    3. Add Composer");
        System.out.println("    4. Exit");
        System.out.println("");
        System.out.print("  Please choose an option: ");
    }

    @SuppressWarnings("resource")
    public static void main(String[] args){ /* This is the main method. */
        MemComposerDao composers = new MemComposerDao(); /* This establishes a new instance of the MemComposerDao class which allows us to use the methods in the class. */

        System.out.println("  Welcome to the Composer App");
        System.out.println("");
        do{ /* Begin do... while loop to allow the user to continue as much as they want. */
            displayMenu(); /* This displays the menu. */
            Scanner input = new Scanner(System.in);
            int userInput = input.nextInt();

            /* This allows the input to select what code will run. */
            if (userInput == 1){ /* This allows the user to see all the composers in the composer list. */
                System.out.println("");
                composers.findAll().forEach(System.out::println);
            }
            else if (userInput == 2){ /* This allows the user to find one composer based on the input ID. */
                System.out.println("");
                System.out.print("  Enter an id: ");
                Scanner userID = new Scanner(System.in);
                int id = userID.nextInt();
                System.out.println("");
                System.out.println(composers.findBy(id));
            }
            else if (userInput == 3){ /* This allows the user to input a composer or many composers and it adds those composer(s) to the composer list. */
                String cont = "y";

                while (cont.equalsIgnoreCase("y")){ /* This allows the user to continuously add composers until they decide to stop. */
                    System.out.println(""); /* This inputs the ID. */
                    System.out.print("  Enter an ID: ");
                    Scanner userID = new Scanner(System.in);
                    int id = userID.nextInt();

                    System.out.print("  Enter a name: "); /*This inputs the name. */
                    Scanner userName = new Scanner(System.in);
                    String name = userName.nextLine();

                    System.out.print("  Enter a genre: "); /* This inputs the genre. */
                    Scanner userGenre = new Scanner(System.in);
                    String genre = userGenre.nextLine();

                    Composer newComposer = new Composer(id, name, genre); /* This builds a new composer based on the input above. */
                    composers.insert(newComposer); /* This inserts the new composer into the composer list. */
            
                    System.out.println(""); /* This asks the user if they want to continue. */
                    System.out.print("  Add another composer? (y/n): ");
                    Scanner userCont = new Scanner(System.in);
                    cont = userCont.nextLine();
                }
            }
            else if (userInput == 4){ /* This allows the user to terminate the session. */
                System.out.println("");
                System.out.println("  Session terminated by user...");
                System.out.println("");
                break;
            }
            else if (userInput != 1 || userInput !=2 || userInput !=3 || userInput != 4){ /* This accounts for if the user enters an invalid input. */
                System.out.println("  Error! Invalid input.");
            }
            System.out.println("");
            System.out.print("  Continue? y/n: "); /* This allows the user to continue the program. */
            Scanner userContinue = new Scanner(System.in);
            System.out.print("");
            String continueChoice = userContinue.nextLine();
            System.out.println("");
            if (continueChoice.equalsIgnoreCase("n")){ /* This if... else if statement allows the user to continue or break the loop.*/
                System.out.println("");
                System.out.println("  Session terminated by user...");
                System.out.println("");
                break;
            } else if (continueChoice.equalsIgnoreCase("y")){
                continue;
            }
        } while (true); /* End do... while loop. */
    } /* End main method. */
} /* End TestComposerApp class. */