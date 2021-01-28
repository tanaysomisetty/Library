
/**
 The container class that defines the abstract data type Library to hold library catalog and its operations.
 @author Sailokesh Mondi, Tanay Somisetty
 */


public class Library {
    private Book[] books;
    private int numBooks;
    final static int bagCapacity = 4;

    /**
     Default constructor to create an empty bag data structure.
     @param 'none'
     */
    public Library() {
        this.books = new Book[bagCapacity];
        numBooks = 0;

    }

    /**
     Helper method to find a book in the bag.
     @param book object to find
     @return index of the book to find
     */
    /*private int find(Book book) {

    }*/

    /**
     Helper method to grow the capacity by 4.
     @param none
     */
    private void grow() {

    }

    /**
     Adds a book to the library's array of books.
     @param book to be added
     */
    public void add(Book book) {

    }

    /**
     Removes a book from the library's array of books
     @param book to be removed
     @return true if the book was able to be removed, false otherwise
     */
    /*public boolean remove(Book book) {

    }*/

    /**
     Checks out a book from the library.
     @param book to be checked out
     @return true if the book was able to be checked out, false otherwise
     */
    /*public boolean checkOut(Book book) {

    }*/

    /**
     Returns a book to the library.
     @param book to be returned
     @return true if able to be returned, false otherwise
     */
    /*public boolean returns(Book book) {

    }*/

    /**
     Prints the list of books in the bag/library's catalog.
     Prints the list of books with the current sequence.
     @param none
     */
    public void print() {

    }

    /**
     Prints the list of books by datePublished in ascending order contained in the bag/library's catalog
     @param none
     */
    public void printByDate() {

    }

    /**
     Prints the list of books by number in ascending order contained in the bag/library's catalog
     @param none
     */
    public void printByNumber() {

    }
}

