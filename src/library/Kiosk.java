/**
 This class is the user-interface class that handles input and output.
 @ Sailokesh Mondi, Tanay Somisetty
 */

package library;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    private static Library myLibrary = null;

    /**
     The method that handles the input and output of the program.
     @param "none"
     */
    public void run() {

        /* for ADD you must look to see if the book already exists in the library, if it doesn't
            then run ADD method */

        /* for REMOVE you will receive a true if item has been removed and a false if item could not be found*/

        /* for CHECKOUT you will receive a true if item has been successfully checked out and a false if item has
        already been checked out or if item is not in the library
         */

        /* for RETURNS you will receive true if item is successfully returned and a false if item is not checked out
        or does not belong to the library
         */
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        String options = "A R O I PA PD PN Q";

        myLibrary = new Library();


        // Add some books to Library

        while (input != "Q"){
            StringTokenizer st = new StringTokenizer(input, ",");
            String commandType = st.nextToken();
            if (!options.contains(commandType)) {
                System.out.println("Invalid command!");
            }
            else if (commandType.equals("A")) {
                String newName = st.nextToken();
                String newDate = st.nextToken();
                add(newName, newDate);
            }
            else if (commandType.equals("R")) {
                remove(st.nextToken());
            }
            else if (commandType.equals("O")) {
                checkout(st.nextToken());
            }
            else if (commandType.equals("I")) {
                returns(st.nextToken());
            }
            else if (commandType.equals("PA")) {
                myLibrary.print();
            }
            else if (commandType.equals("PD")) {
                myLibrary.printByDate();
            }
            else if (commandType.equals("PN")){
                myLibrary.printByNumber();
            }
            else if(commandType.equals("Q")) {
                System.out.println("Kiosk session ended");
                System.exit(1);
            }

            input = sc.nextLine();

        }
        System.out.println("Kiosk session ended");
        System.exit(1);
    }


    /**
     Helper method to be called when user inputs Add (A) command.
     Calls the add method from the Library class
     @param 'String' for the name of the book, and String for the publish date
     */
    private void add(String name, String date) {
        Date newDate = new Date(date);
        boolean validDate = newDate.isValid();

        if (!validDate){
            System.out.println("Invalid Date!");
        }
        else {
            Book newBook = new Book(name, newDate);
            myLibrary.add(newBook);
            System.out.println(newBook.getName() + " added to the library.");
        }
    }

    /**
     Helper method to be called when user inputs Remove (R) command.
     Calls the remove method from the Library class
     @param 'String' for the book's serial number
     */
    private void remove(String number) {
        Book toBeDeleted = new Book(number);
        boolean removed = myLibrary.remove(toBeDeleted);
        if (removed) {
            System.out.println("Book#" + number + "removed.");
        }
        else {
            System.out.println("Unable to remove, the library does not have this book");
        }
    }

    /**
     Helper method to be called when user inputs Checking out a Book (O) command.
     Calls the checkOut method from the Library class
     @param 'String' for the book's serial number
     */
    private void checkout(String number) {
        Book toBeCheckedOut = new Book(number);
        boolean checkedOut = myLibrary.checkOut(toBeCheckedOut);
        if (checkedOut) {
            System.out.println("You've checked out Book#" + number + ". Enjoy!");
        }
        else {
            System.out.println("Book#" + number + " is not available.");
        }

    }

    /**
     Helper method to be called when user inputs Returning a book (I) command.
     Calls the returns method from the Library class
     @param 'String' for the book's serial number
     */
    private void returns(String number) {
        Book toBeReturned = new Book(number);
        boolean returned = myLibrary.returns(toBeReturned);
        if (returned) {
            System.out.println("Book#" + number + " return has completed. Thanks!");
        }
        else {
            System.out.println("Unable to return Book#" + number + ".");
        }
    }

}
