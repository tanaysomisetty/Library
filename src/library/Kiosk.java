/**
 This class is the user-interface class that handles input and output.
 @ Sailokesh Mondi, Tanay Somisetty
 */

package library;

import java.util.IllegalFormatCodePointException;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Kiosk {

    Library myLibrary = null;
    Date myDate = null;

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

        String options = "A R O I PA PD PN";

        myLibrary = new Library();


        // Add some books to Library

        while (input != "Q"){
            StringTokenizer st = new StringTokenizer(input, ",");
            String commandType = st.nextToken();
            if (!options.contains(commandType)) {
                System.out.println("Invalid command!");
            }
            else if (commandType == "A") {
                String newName = st.nextToken();
                Date newDate = new Date(st.nextToken());
                Book newBook = new Book(newName, newDate);

                add(newBook);

            }
            else if (commandType == "R") {
                remove(st.nextToken());
            }
            else if (commandType == "O") {
                checkout(st.nextToken());
            }
            else if (commandType == "I") {
                returns(st.nextToken());
            }
            else if (commandType == "PA") {
                myLibrary.print();
            }
            else if (commandType == "PD") {
                myLibrary.printByDate();
            }
            else if (commandType == "PN"){
                myLibrary.printByNumber();
            }

        }
        System.out.println("Kiosk session ended");
    }

    private void add(Book book) {
       boolean isCheckedOut =  myLibrary.checkOut(book);
        boolean validDate = myDate.isValid();

        if (!validDate) {
            System.out.println("Invalid Date!");

        } else if(!isCheckedOut) {
          myLibrary.add(book);
          myLibrary.checkOut(book);
            System.out.println(book+ "added to the Library.");
       }

    }

        private void remove(String number) {
        // boolean remove = myLibrary.remove();

          //  if(!myLibrary.remove())

       // Book book = new Book();

        //myLibrary.remove(number);

    }

    private void checkout(String number) {

    }
    private void returns(String number) {

    }

}
