/**
 This class defines the properties of a Date object.
 @author Sailokesh Mondi, Tanay Somisetty
 */

package library;

import java.util.Calendar;
import java.util.StringTokenizer;


public class Date {
    private int year;
    private int month;
    private int day;
    public static final int QUADRENNIAL = 4;
    public static final int CENTENNIAL = 100;
    public static final int QUATERCENTENNIAL = 400;
    public static final int YearThresholdOne = 1900;
    public static final int YearThresholdTwo = 2021;


    /**
     This is the constructor to take mm/dd/yyyy and create a Date object.
     Tokenizes the string with '/' as a deliminator.
     @param date of the book
     */
    public Date(String date) {
        StringTokenizer st = new StringTokenizer(date, "/", false);

        this.month = Integer.parseInt(st.nextToken());
        this.day = Integer.parseInt(st.nextToken());
        this.year = Integer.parseInt(st.nextToken());
    }

    /**
     This constructor returns today's date.
     Uses the Calendar class.
     @param 'none'
     */
    public Date() {
        Calendar today = Calendar.getInstance();

        this.year = today.get(today.YEAR);
        this.month = today.get(today.MONTH) + 1;
        this.day = today.get(today.DAY_OF_MONTH);
    }


    /**
     Getter method for the date class.
     @param 'none'
     @return String in the format mm/dd/yyyy
     */
    public String getDate() {
        return this.month + "/" + this.day + "/" + this.year;
    }

    /**
     This method checks to see whether a given date is valid or  not
     @param 'none'
     @return true if the date is valid, false otherwise
     */
    public boolean isValid() {

        int longMonth = 31;
        int shortMonth = 30;
        int longFeb = 29;
        int shortFeb = 28;


        Date todayDate = new Date();

        int currentDay = todayDate.day;
        int currentMonth = todayDate.month;

        // year Validation
        if (year < YearThresholdOne || year >= YearThresholdTwo) {
            if((year == YearThresholdTwo) && (month <= currentMonth && month >= 1) && (day <= currentDay && day >= 1)) {
                return true;
            }
            return false;
        }


        // Day Validation
        if ((month == Calendar.JANUARY + 1 || month == Calendar.MARCH + 1 || month == Calendar.MAY + 1 || month == Calendar.JULY + 1
                || month == Calendar.AUGUST + 1 || month == Calendar.OCTOBER + 1 || month == Calendar.DECEMBER + 1) && day > longMonth) {
            return false;
        }

        if ((month == Calendar.APRIL + 1 || month == Calendar.JUNE + 1 || month == Calendar.SEPTEMBER + 1
                || month == Calendar.NOVEMBER + 1) && day > shortMonth) {
            return false;
        }

        if (month == Calendar.FEBRUARY + 1 && isLeapYear() && day > longFeb) {
            return false;

        }

        if (month == Calendar.FEBRUARY + 1 && !isLeapYear() && day > shortFeb) {

            return false;

        }

        // Month Validation
        if (month < Calendar.JANUARY + 1 || month > Calendar.DECEMBER + 1) {
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

    public int getYear() {
        return year;
    }



    public int getMonth() {
        return month;
    }



    public int getDay() {
        return day;
    }



    public static void main(String[] args) {
        Date test1 = new Date("1/1/1860");
        System.out.println(test1.getDate());
        System.out.println(test1.isValid());

        Date test2 = new Date("1/1/2022");
        System.out.println(test2.getDate());
        System.out.println(test2.isValid());

        Date test3 = new Date("13/1/2021");
        System.out.println(test3.getDate());
        System.out.println(test3.isValid());

        Date test4 = new Date("0/1/2021");
        System.out.println(test4.getDate());
        System.out.println(test4.isValid());

        Date test5 = new Date("1/33/2021");
        System.out.println(test5.getDate());
        System.out.println(test5.isValid());

        Date test6 = new Date("4/30/2021");
        System.out.println(test6.getDate());
        System.out.println(test6.isValid());

        Date test7 = new Date("2/29/2020");
        System.out.println(test7.getDate());
        System.out.println(test7.isValid());

        Date test8 = new Date("12/1/2005");
        System.out.println(test8.getDate());
        System.out.println(test8.isValid());

        Date test9 = new Date("1/31/2020");
        System.out.println(test9.getDate());
        System.out.println(test9.isValid());

        Date test10 = new Date("3/29/2021");
        System.out.println(test10.getDate());
        System.out.println(test10.isValid());

        Date test11 = new Date();
        System.out.println(test11.getDate());
        System.out.println(test11.isValid());

    }
}

