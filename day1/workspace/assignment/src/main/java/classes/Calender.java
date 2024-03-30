package classes;

import utils.KeyboardUtil;


public class Calender {
    public static void main(String[] args) {
        int mo = KeyboardUtil.getInt("Enter the month:");
        int ye = KeyboardUtil.getInt("Enter the year:");
        printCalendar(mo, ye);
    }

    public static void printCalendar(int month, int year) {
        if (month < 1 || month > 12 || year < 1) {
            System.out.println("Invalid month or year");
            return;
        }

        String[] months = {"January", "February", "March",
                "April", "May", "June",
                "July", "August", "September",
                "October", "November", "December"
        };

        int[] days = { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        if (month == 2 && isLeapYear(year)) {
            days[month] = 29;
        }

        System.out.println("   " + months[month-1] + " " + year);
        System.out.println(" Su Mo Tu We Th Fr Sa");

        int d = day(month, 1, year);

        for (int i = 0; i < d; i++) {
            System.out.print("   ");
        }
        for (int i = 1; i <= days[month]; i++) {
            System.out.printf("%2d ", i);
            if (((i + d) % 7 == 0) || (i == days[month])) {
                System.out.println();
            }
        }
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 != 0) {
            return true;
        }
        return year % 400 == 0;
    }

    public static int day(int month, int day, int year) {
        int y = year - (14 - month) / 12;
        int x = y + y/4 - y/100 + y/400;
        int m = month + 12 * ((14 - month) / 12) - 2;
        return (day + x + (31*m)/12) % 7;
    }
}
