/*
Krasso, R., (2021). CIS 505 Intermediate Java Programming. Bellevue University, all rights reserved
*/
package Module_4.BowlingShopApp;

public class ProductDB{

    public static GenericQueue<Product> getProducts(String code){ /*Begin getProducts method. */
        if (code.equalsIgnoreCase("b"))/* If code is b for ball. */
        {
            /* These create 5 balls and set the instance for each ball with unique attributes. */
            
            Ball ball1 = new Ball();
            ball1.setCode("B100");
            ball1.setDescription("Black Widow 2.0");
            ball1.setPrice(144.95);
            ball1.setColor("Black and Red");

            Ball ball2 = new Ball();
            ball2.setCode("B200");
            ball2.setDescription("Axiom Pearl");
            ball2.setPrice(154.95);
            ball2.setColor("Blue and Red");

            Ball ball3 = new Ball();
            ball3.setCode("B300");
            ball3.setDescription("Proton Physix");
            ball3.setPrice(174.95);
            ball3.setColor("Pink and Purple");

            Ball ball4 = new Ball();
            ball4.setCode("B400");
            ball4.setDescription("Force Unleashed");
            ball4.setPrice(139.99);
            ball4.setColor("Red and White");

            Ball ball5 = new Ball();
            ball5.setCode("B500");
            ball5.setDescription("Phase III");
            ball5.setPrice(154.99);
            ball5.setColor("Purple and Green");

            /* This queues up each ball. */
            GenericQueue<Product> balls = new GenericQueue<Product>();
            balls.enqueue(ball1);
            balls.enqueue(ball2);
            balls.enqueue(ball3);
            balls.enqueue(ball4);
            balls.enqueue(ball5);
            /* This returns the ball queue. */
            return balls;
        }
        else if (code.equalsIgnoreCase("a")) /* If code is a for bag. */
        {
            /* These create 3 bags and set the instance for each bag with unique attributes. */
            
            Bag bag1 = new Bag();
            bag1.setCode("A100");
            bag1.setDescription("Path Pro Deluxe");
            bag1.setPrice(34.99);
            bag1.setType("Single");

            Bag bag2 = new Bag();
            bag2.setCode("A200");
            bag2.setDescription("Prime Roller Black/Royal Blue");
            bag2.setPrice(54.99);
            bag2.setType("Double");

            Bag bag3 = new Bag();
            bag3.setCode("A300");
            bag3.setDescription("Silver/Royal Blue");
            bag3.setPrice(74.99);
            bag3.setType("Triple");

            /* This queues up each bag. */
            GenericQueue<Product> bags = new GenericQueue<Product>();
            bags.enqueue(bag1);
            bags.enqueue(bag2);
            bags.enqueue(bag3);
            /* This returns the bag queue. */
            return bags;
        }
        else if (code.equalsIgnoreCase("s"))/* If code is s for shoe. */
        {
            /* These create 5 shoes and set the instance for each shoe with unique attributes. */
            
            Shoe shoe1 = new Shoe();
            shoe1.setCode("S100");
            shoe1.setDescription("Men's Ram Black");
            shoe1.setPrice(39.99);
            shoe1.setSize(10.5);

            Shoe shoe2 = new Shoe();
            shoe2.setCode("S200");
            shoe2.setDescription("Women's Rise Black/Hot Pink");
            shoe2.setPrice(39.99);
            shoe2.setSize(7.0);

            Shoe shoe3 = new Shoe();
            shoe3.setCode("S300");
            shoe3.setDescription("Women's Path Lite Seamless Mesh");
            shoe3.setPrice(54.99);
            shoe3.setSize(6.0);

            Shoe shoe4 = new Shoe();
            shoe4.setCode("S400");
            shoe4.setDescription("Men's Tribal White");
            shoe4.setPrice(56.99);
            shoe4.setSize(8.5);

            Shoe shoe5 = new Shoe();
            shoe5.setCode("S500");
            shoe5.setDescription("Youth Skull Green/Black");
            shoe5.setPrice(39.99);
            shoe5.setSize(3.0);

            /* This queues up each shoe. */
            GenericQueue<Product> shoes = new GenericQueue<Product>();
            shoes.enqueue(shoe1);
            shoes.enqueue(shoe2);
            shoes.enqueue(shoe3);
            shoes.enqueue(shoe4);
            shoes.enqueue(shoe5);
            /* This returns the shoe queue. */
            return shoes;
        }
        else{
            /* This creates an empty queue and returns it. */
            GenericQueue<Product> empty = new GenericQueue<Product>();
            return empty;
        }
    }/* End getProducts method. */
}/* End ProductDB class. */
