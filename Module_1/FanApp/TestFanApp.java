    /* 	Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
	Comprehensive Version (12th ed.). Pearson Education, Inc.
 */
    // Write test code that creates two instances of the Fan class, one using the default constructor and the other using the argument constructor.
    // Write code that displays the functionality of the Fan class methods
    
    public class TestFanApp {
        public static final int STOPPED = 0;
        public static final int SLOW = 1;
        public static final int MEDIUM = 2;
        public static final int FAST = 3;
    public static void main(String args[]) {
        Fan f1 = new Fan();
        Fan f2 = new Fan(MEDIUM, true, 8, "Blue");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}