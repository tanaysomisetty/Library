/**
 * This class defines the properties of a Date object.
 *
 * @author Sailokesh Mondi, Tanay Somisetty
 */

import java.util.Calendar;
import java.util.StringTokenizer;


public class Date {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int InvalidDateOne = 1900;
    public static final int InvalidDateTwo = 2021;


    /**
     * This is the constructor to take mm/dd/yyyy and create a Date object.
     * Tokenizes the string with '/' as a deliminator.
     *
     * @param date of the book
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/", false);

        this.month = Integer.parseInt(st.nextToken());
        this.day = Integer.parseInt(st.nextToken());
        this.year = Integer.parseInt(st.nextToken());
    }

    /**
     * This constructor returns today's date.
     * Uses the Calendar class.
     *
     * @param 'none'
     */
    public Date() {
        Calendar today = Calendar.getInstance();

        this.year = today.get(today.YEAR);
        this.month = today.get(today.MONTH) + 1;
        this.day = today.get(today.DAY_OF_MONTH);
    }


    /**
     * Getter method for the date class.
     *
     * @param 'none'
     * @return String in the format mm/dd/yyyy
     */
    public String getDate() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    /**
     * This method checks to see whether a given date is valid or  not
     *
     * @param 'none'
     * @return true if the date is valid, false otherwise
     */
    public boolean isValid() {

        // year Validation
        if (year < InvalidDateOne || year > InvalidDateTwo) {
            return false;
        }

        // Day Validation
        if ((month == Calendar.JANUARY || month == Calendar.MARCH || month == Calendar.MAY || month == Calendar.JULY
                || month == Calendar.AUGUST || month == Calendar.OCTOBER || month == Calendar.DECEMBER) && day != 31) {
            return false;
        }

        if ((month == Calendar.APRIL || month == Calendar.JUNE || month == Calendar.SEPTEMBER
                || month == Calendar.NOVEMBER) && day != 30) {
            return false;
        }

        if (month == Calendar.FEBRUARY && isLeapYear() && day != 29) {
            return false;

        }

        if (month == Calendar.FEBRUARY && !isLeapYear() && day != 28) {
            return false;

        }

        // Month Validation
        if (month < Calendar.JANUARY || month > Calendar.DECEMBER) {
            return false;
        }

        return true;
    }

    private boolean isLeapYear() {
        if (year % QUADRENNIAL != 0) {
            return false;
        } else if (year % CENTENNIAL == 0 && year % QUATERCENTENNIAL == 0) {
            return true;
        }

        return true;
    }

    public static void main(String[] args) {
        Date date = new Date("5/18/2000");

        System.out.println(date.year);
        System.out.println(date.month);
        System.out.println(date.day);
        System.out.println(date.getDate());

    }


}

