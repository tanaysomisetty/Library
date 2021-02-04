/**
 This class is a driver class to run Project1.
 @author Sailokesh Mondi, Tanay Somisetty
 */

package library;

public class RunProject1 {
    /**
     Main method for driver class that calls the run method in the Kiosk class
     @param 'array' of string arguments
     */
    public static void main(String[] args) {
        Kiosk kiosk = new Kiosk();
        kiosk.run();
    }
}
