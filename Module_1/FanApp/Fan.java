/* 	Liang, Y.D. (2019). Introduction to Java Programming and Data Structures:
	Comprehensive Version (12th ed.). Pearson Education, Inc.
 */
public class Fan {
    // Four constants named STOPPED, SLOW, MEDIUM, and FAST.
    // The constants are to hold the values of 0, 1, 2, and 3 respectively.
    public static final int STOPPED = 0;
    public static final int SLOW = 1;
    public static final int MEDIUM = 2;
    public static final int FAST = 3;
    // A private int data field named speed that specifies the speed of the fan.
    // A private boolean data field named on that specifies whether the fan is on or off.
    // A private double data field named radius that specifies the radius of the fan.
    // A private String data field named color that specifies the color of the fan.
    private int speed;
    private boolean on;
    private double radius;
    private String color;

    // A no-argument constructor for defaults
    // Set default for speed to '0'(STOPPED)
    // Set default for on to 'false'
    // Set default for radius to '6'
    // Set default for color to 'white'
    public Fan() {
        speed = 0;
        on = false;
        radius = 6.0;
        color = "White";
    }
	//Provides setter and getter methods for the properties of the fan
    public Fan(int speed, boolean on, double radius, String color) {
        this.speed = speed;
        this.on = on;
        this.radius = radius;
        this.color = color;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isFanOn() {
        return on;
    }

    public double getRadius() {
        return radius;
    }

    public String getColor() {
        return color;
    }

	//Provides a toString() method to represent the state of the fan as a string

    public String toString() {
        if (isFanOn()) {
            return "The fan Speed is set to " + getSpeed() + " with a color of " + getColor() + " and a radius of " + getRadius();
        } else {
            return "The fan is " + getColor() + " with a radius of " + getRadius() + " and the fan is off";
        }
    }

    // Write test code that creates two instances of the Fan class, one using the default constructor and the other using the argument constructor.
    // Write code that displays the functionality of the Fan class methods
    public static void main(String args[]) {
        Fan f1 = new Fan();
        Fan f2 = new Fan(MEDIUM, true, 8, "Blue");
        System.out.println(f1.toString());
        System.out.println(f2.toString());
    }
}
