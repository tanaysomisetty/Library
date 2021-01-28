/**
This class defines the properties of a Date object.
 @author Sailokesh Mondi, Tanay Somisetty
 */

import java.util.Calendar;
import java.util.StringTokenizer;


public class Date {
    private int year;
    private int month;
    private int day;

    /**
     * This is the constructor to take mm/dd/yyyy and create a Date object
     *
     * @param date of the book
     */
    public Date(String date) {



    }

    /**
     * This constructor returns today's date
     */
    public Date() {
        Calendar today = Calendar.getInstance();

        this.year = today.get(today.YEAR);
        this.month = today.get(today.MONTH) + 1;
        this.day = today.get(today.DAY_OF_MONTH);

    }


    /**
     Getter method for the date class.
     @param "none"
     @return String in the format mm/dd/yyyy
     */
    public String getDate(){

    }

    /**
     This method checks to see whether a given date is valid or  not
     @param 'none'
     @return true if the date is valid, false otherwise
     */
    public boolean isValid() {

        if (year < 1900 || year > 2021) {
            return false;
            //} else if ()

        }
        return false;
    }

    private boolean isLeapYear() {
        if(year % 4 != 0 ) {
            return false;
        } else if( year % 100 ==0 && year % 400 == 0 ) {
            return true;
        }

        return true;
    }

    public static void main(String[] args) {
      Date date = new Date();
      System.out.println(date.year);
      System.out.println(date.month);
      System.out.println(date.day);


    }


}

