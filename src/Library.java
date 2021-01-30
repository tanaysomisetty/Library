import java.util.Calendar;
import java.util.Scanner;

/**
 * The container class that defines the abstract data type Library to hold library catalog and its operations.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */


public class Library {
    private Book[] books;
    private int numBooks;
    final static int initCapacity = 4; //initial capacity of books
    final static int SORT_BY_NUMBER = 1;
    final static int SORT_BY_DATE = 2;

    /**
     * Default constructor to create an empty bag data structure.
     *
     * @param 'none'
     */
    public Library() {
        this.books = new Book[initCapacity];
        numBooks = 0;
    }

    /**
     * Helper method to find a book in the bag.
     *
     * @param book object to find
     * @return index of the book to find
     */
    private int find(Book book) {
        int number = Integer.valueOf(book.getNumber());

        for (int i = 0; i < this.books.length; i++) {
            Book currBook = books[i];
            int currNum = Integer.valueOf(currBook.getNumber());
            if (currNum == number) {
                return i;
            }
        }

        return -1;
    }

    /**
     * Helper method to grow the capacity by 4.
     *
     * @param 'none'
     */
    private void grow() {
        int currCapacity = this.books.length;

    }

    /**
     * Adds a book to the library's array of books.
     *
     * @param book to be added
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
     * Prints the list of books in the bag/library's catalog.
     * Prints the list of books with the current sequence.
     *
     * @param 'none'
     */
    public void print() {
        for (Book book : books) {
            System.out.println(book.toString());
        }
    }

    private void selectionSort(final int sortBy) {
        Book[] sortedBooks = new Book[books.length];

        if (sortBy == SORT_BY_NUMBER) {
            for (int i = 0; i < books.length - 1; i++) {
                for (int j = i + 1; j < books.length; j++) {
                    int num1 = Integer.parseInt(books[i].getNumber());
                    int num2 = Integer.parseInt(books[j].getNumber());
                    if (num1 > num2) {
                        Book temp_city = books[i];
                        books[i] = books[j];
                        books[j] = temp_city;
                    }
                }
            }

        } else if (sortBy == SORT_BY_DATE) {
            for (int i = 0; i < books.length - 1; i++) {
                for (int j = i + 1; j < books.length; j++) {
                    Date dt1 = books[i].getDatePublished();
                    Calendar cal1 = Calendar.getInstance();
                    cal1.set(Calendar.DATE, dt1.getDay());
                    cal1.set(Calendar.MONTH, dt1.getMonth());
                    cal1.set(Calendar.YEAR, dt1.getYear());

                    System.out.println(cal1.getTime());

                    Date dt2 = books[j].getDatePublished();
                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(Calendar.DATE, dt2.getDay());
                    cal2.set(Calendar.MONTH, dt2.getMonth());
                    cal2.set(Calendar.YEAR, dt2.getYear());

                    if (cal1.compareTo(cal2) > 1) {
                        Book temp_city = books[i];
                        books[i] = books[j];
                        books[j] = temp_city;
                    }
                }
            }

        }

    }

    /**
     * Prints the list of books by datePublished in ascending order contained in the bag/library's catalog
     *
     * @param 'none'
     */
    public void printByDate() {
        selectionSort(SORT_BY_DATE);
        for (Book book: books) {
            System.out.println(book.toString());
        }
    }

    /**
     * Prints the list of books by number in ascending order contained in the bag/library's catalog
     *
     * @param 'none'
     */
    public void printByNumber() {

        selectionSort(SORT_BY_NUMBER);

        for (Book book: books) {
            System.out.println(book.toString());
        }
    }

    public static void main(String[] args) {
/*
        Calendar cal = Calendar.getInstance();
        Date dt1 = new Date((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR));
        Book book1 = new Book("A", dt1);

        cal.add(Calendar.DATE, -1);
        Date dt2 = new Date((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR));

        Book book2 = new Book(("B"), dt2);

        cal.add(Calendar.DATE, -1);
        Date dt3 = new Date((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR));

        Book book3 = new Book(("C"), dt3);

        cal.add(Calendar.DATE, -1);
        Date dt4 = new Date((cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DATE)+"/"+cal.get(Calendar.YEAR));

        Book book4 = new Book(("D"), dt4);

        Library library = new Library();
        library.add(book4);
        library.add(book3);
        library.add(book2);
        library.add(book1);

        //library.printByNumber();

        library.printByDate();


 */


    }

}


