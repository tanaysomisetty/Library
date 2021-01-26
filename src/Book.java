/**
 This class defines the abstract data type Book, which encapsulates the data fields and methods of a book.
 @author Sailokesh Mondi, Tanay Somisetty
 */

public class Book {

    private String number;
    private String name;
    private boolean checkedOut;
    private Date datePublished;

    /**
     Used to compare two book objects to see if they are equal based on their serial numbers
     @param obj
     @return true if the serial numbers for the 2 book objects are the same, false otherwise
     */
    @override
    public boolean equals(Object obj) {

    }

    /**
     This method takes the book object and represents it as a string.
     Returns a textual representation of a book.
     @param none
     @return a string in the following format: Book#10007::Design Patterns::5/30/1996::is available
     */
    @override
    public String toString() {

    }

}


