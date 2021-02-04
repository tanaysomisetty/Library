/**
 * The container class that defines the abstract data type Library to hold library catalog and its operations.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

package library;

import java.util.Calendar;


public class Library {
    private Book[] books;
    private int numBooks;
    final static int INIT_CAPACITY = 4; //initial capacity of books
    final static int SORT_BY_NUMBER = 1;
    final static int SORT_BY_DATE = 2;

    /**
     * Default constructor to create an empty bag data structure.
     *
     * @param 'none'
     */
    public Library() {
        this.books = new Book[INIT_CAPACITY];
        numBooks = 0;
    }

    /**
     * Helper method to find a book in the bag.
     *
     * @param book object to find
     * @return index of the book to find, -1 if book can not be found
     */
    private int find(Book book) {
        int number = Integer.valueOf(book.getNumber());

        for (int i = 0; i < this.books.length && books[i] != null; i++) {
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
        Book[] newBooks = new Book[currCapacity + 4];
        for (int i = 0; i < currCapacity; i++) {
            Book currBook = this.books[i];
            Book newBook = new Book(currBook);
            newBooks[i] = newBook;
        }
        this.books = newBooks;
    }

    /**
     * Adds a book to the library's array of books.
     * If the array of books is already full, then calls the grow method to increase capacity.
     *
     * @param book to be added
     */
    public void add(Book book) {
        int emptyLoc = findEndOfArray(this.books);
        if (emptyLoc >= 0) {
            this.books[emptyLoc] = book;
            this.numBooks++;
        } else {
            grow();
            int newEmptyLoc = findEndOfArray(this.books);
            this.books[newEmptyLoc] = book;
            this.numBooks++;
        }

    }

    /**
     * Helper method to find the end of the array.
     *
     * @param 'array' of Book objects
     * @return the index of the first empty location in the array, -1 if there is no empty location
     */
    private int findEndOfArray(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            if (books[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Removes a book from the library's array of books.
     * Calls shift method to shift back all the books by one
     *
     * @param book to be removed
     * @return true if the book was able to be removed, false otherwise
     */
    public boolean remove(Book book) {
        int removeIndex = find(book);
        if (removeIndex >= 0) {
            books[removeIndex] = null;
            this.numBooks--;
            shift(removeIndex + 1);
            return true;
        } else {
            return false;
        }
    }

    /**
     * Helper method to shift all items of an array begin at index start to the end of the array back by 1
     *
     * @param 'starting' index
     */
    private void shift(int start) {

        for (int i = start; i < books.length; i++) {
            books[i - 1] = books[i];
        }
        books[books.length - 1] = null;

    }

    /**
     * Checks out a book from the library.
     *
     * @param book to be checked out
     * @return true if the book was able to be checked out, false otherwise
     */
    public boolean checkOut(Book book) {
        int checkOutIndex = find(book);
        if (checkOutIndex >= 0) {
            Book toBeChecked = books[checkOutIndex];
            if (toBeChecked.isCheckedOut() == true) {
                return false;
            } else {
                toBeChecked.setCheckoutStatus();
                return true;
            }
        } else {
            return false;

        }

    }

    /**
     * Returns a book to the library.
     *
     * @param book to be returned
     * @return true if able to be returned, false otherwise
     */
    public boolean returns(Book book) {
        int returnIndex = find(book);
        if (returnIndex >= 0) {
            Book toBeReturned = books[returnIndex];
            if (toBeReturned.isCheckedOut() == false) {
                return false;
            } else {
                toBeReturned.setCheckoutStatus();
                return true;
            }
        } else {
            return false;
        }


    }

    /**
     * Prints the list of books in the bag/library's catalog.
     * Prints the list of books with the current sequence.
     *
     * @param 'none'
     */
    public void print() {
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
        }
        for (int i = 0; i < numBooks; i++) {
            System.out.println(books[i].toString());
        }
    }

    /**
     * Implements selection sorting for two different purposes: sort by date and sort by
     * book serial number.
     *
     * @param 'sorting' type/method
     */
    private void selectionSort(final int sortBy) {

        if (sortBy == SORT_BY_NUMBER) {
            for (int i = 0; i < numBooks - 1; i++) {
                for (int j = i + 1; j < numBooks; j++) {
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
            for (int i = 0; i < numBooks - 1; i++) {
                for (int j = i + 1; j < numBooks; j++) {
                    Date dt1 = books[i].getDatePublished();
                    Calendar cal1 = Calendar.getInstance();
                    cal1.set(Calendar.DATE, dt1.getDay());
                    cal1.set(Calendar.MONTH, dt1.getMonth());
                    cal1.set(Calendar.YEAR, dt1.getYear());

                    Date dt2 = books[j].getDatePublished();
                    Calendar cal2 = Calendar.getInstance();
                    cal2.set(Calendar.DATE, dt2.getDay());
                    cal2.set(Calendar.MONTH, dt2.getMonth());
                    cal2.set(Calendar.YEAR, dt2.getYear());

                    if (cal1.getTime().compareTo(cal2.getTime()) > 0) {
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
        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
        } else {
            selectionSort(SORT_BY_DATE);
            for (int i = 0; i < numBooks; i++) {
                System.out.println(books[i].toString());
            }
        }
    }

    /**
     * Prints the list of books by number in ascending order contained in the bag/library's catalog
     *
     * @param 'none'
     */
    public void printByNumber() {

        if (numBooks == 0) {
            System.out.println("Library catalog is empty!");
        } else {

            selectionSort(SORT_BY_NUMBER);

            for (int i = 0; i < numBooks; i++) {
                System.out.println(books[i].toString());
            }
        }
    }

    public static void main(String[] args) {
        /*Library myLibrary = new Library();

        Date date1 = new Date("7/21/2007");
        Book book1 = new Book("Harry Potter", date1);
        myLibrary.add(book1);
        System.out.println(myLibrary.numBooks);

        Date date2 = new Date("2/28/2012");
        Book book2 = new Book("The Power of Habit", date2);
        myLibrary.add(book2);
        System.out.println(myLibrary.numBooks);

        Date date3 = new Date("9/15/1986");
        Book book3 = new Book("It", date3);
        myLibrary.add(book3);
        System.out.println(myLibrary.numBooks);

        Date date4 = new Date("5/24/2009");
        Book book4 = new Book("Rooftops of Tehran", date4);
        myLibrary.add(book4);
        System.out.println(myLibrary.numBooks);

        Date date5 = new Date("10/14/2005");
        Book book5 = new Book("Percy Jackson", date5);
        myLibrary.add(book5);
        System.out.println(myLibrary.numBooks);

        System.out.println("Print:");
        myLibrary.print();

        System.out.println("Print 2:");
        myLibrary.remove(book3);
        System.out.println(myLibrary.numBooks);
        myLibrary.print();

        System.out.println("Print 3:");
        System.out.println(myLibrary.checkOut(book3));
        myLibrary.print();

        System.out.println("Print 4:");
        System.out.println(myLibrary.returns(book3));
        myLibrary.print();*/


    }

}


