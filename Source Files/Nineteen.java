
/**
 * Write a description of class Nineteen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nineteen
{
    public static int day = 1;
    public static int month = 1;
    public static int year = 1900;
    public static int weekday = 1;

    public static void advanceDay()
    {
        boolean isLeapYear = (year % 4 == 0) || (year % 400 == 0);
        day++;
        if(month == 2 && day > 28 && !isLeapYear) {
            day = 1;
            month++;
        }
        else if(month == 2 && day > 29 && isLeapYear) {
            day = 1;
            month++;
        }
        else if((month == 4 || month == 6 || month == 9 || month == 11) && day > 30) {
            day = 1;
            month++;
        }
        else if(day > 31) {
            day = 1;
            month++;
        }
        
        if(month > 12) {
            month = 1;
            year++;
        }
        weekday++;
        if(weekday > 7)
            weekday = 1;
    }

    public static void main(String[] args) {
        int count = 0;
        for(int i = 0; day != 31 || month != 12 || year != 2000; i++) {
            if(year > 1900 && weekday == 7 && day == 1)
                count++;
            advanceDay();
        }
        System.out.println(count);
    }
}
