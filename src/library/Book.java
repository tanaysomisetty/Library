/**
 This class defines the abstract data type Book, which encapsulates the data fields and methods of a book.
 @author Sailokesh Mondi, Tanay Somisetty
 */

package library;

public class Book {

    private String number;
    private String name;
    private boolean checkedOut;
    private Date datePublished;
    private static int currentNum = 10001;


    /**
     This is the constructor to take the name and datePublished for a book and create a date object
     @param name of the book and the date object for the date it was published
     */

    public Book(String name, Date datePublished){
        this.number = String.valueOf(this.currentNum);
        this.name = name;
        this.checkedOut = false;
        this.datePublished = datePublished;

        this.currentNum++;
    }


    /**
     Copy constructor used to clone a Book object
     @param 'Book' object to be cloned
     */
    public Book(Book book){
        this.number = book.number;
        this.name = book.name;
        this.checkedOut = book.checkedOut;
        this.datePublished = book.datePublished;

    }

    /**
     Used to compare two book objects to see if they are equal based on their serial numbers
     @param obj
     @return true if the serial numbers for the 2 book objects are the same, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if(obj == this){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (obj instanceof Book){
            Book other = (Book)obj;
            return this.number.equals(other.number);
        }
        else {
            return false;
        }
    }

    /**
     This method takes the book object and represents it as a string.
     Returns a textual representation of a book.
     @param 'none'
     @return a string in the following format: Book#10007::Design Patterns::5/30/1996::is available
     */
   @Override
    public String toString() {

       String number = this.number;
       String name = this.name;
       String date = this.datePublished.getDate();
       String availability = (checkedOut) ? "is checked out." : "is available.";

       return "Book#" + number + "::" + name + "::" + date + "::" + availability;

    }

    /**
     Accessor method that gets a book's serial number.
     @param 'none'
     @return a string which is the book's serial number
     */
    public String getNumber(){
       return this.number;
    }


    /**
     Accessor method that gets a book's Name.
     @param 'none'
     @return a string which is the name of the book
     */
    public String getName() {
        return name;
    }

    /**
     Modifer method that sets the checkout status as true if false and false if true.
     @param 'none'
     */
    public void setCheckoutStatus(){
        this.checkedOut = !this.checkedOut;
    }


    /**
     Accessor method that gets book checked out or not
     @param 'none'
     @return a boolean value book checked out or not
     */
    public boolean isCheckedOut() {
        return this.checkedOut;
    }


    /**
     Accessor method that gets a Date Published.
     @param 'none'
     @return a Date which is the published date
     */
    public Date getDatePublished() {
        return datePublished;
    }




    /*public static void main(String[] args) {
        String bookName = "Harry Potter";
        Date bookDate = new Date();

        Book newBook = new Book(bookName, bookDate);
        System.out.println(newBook.toString());
        System.out.println(newBook.number);
        System.out.println(newBook.name);
        System.out.println(newBook.checkedOut);
        System.out.println(newBook.datePublished);
        System.out.println(newBook.currentNum);

        Book secondBook = newBook;

        Book diffBook = new Book("Sherlok Holmes", bookDate);

        System.out.println(diffBook.toString());

        System.out.println(newBook.equals(secondBook));
        System.out.println(newBook.equals(diffBook));

        System.out.println(diffBook.number);


    }*/





}


