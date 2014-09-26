package com.cj.interview.prep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Goal:
Demonstrate knowledge of refactoring, architecture, design patterns, object oriented concepts

Requirements:
This code has issues you should find irritating
Refactor this code and be prepared to explain your changes
You do not have to split this code into multiple files, that part of the design is not what we will be focusing on
*/
public class DateRangeApplication {
    public static void main(String[] args) throws IOException {
        new DateRangeApplication().run();
    }

    private void run() throws IOException {
        System.out.println("Choose the date range to report on: ");
        for (int i = 0; i < DateRangeUtil.timeRangeCount; i++) {
            System.out.println(String.format("(%d) %s", i, DateRangeUtil.getDisplayString(i)));
        }
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int userSelection = Integer.parseInt(in.readLine());
        switch (userSelection) {
            case 0:
                DatabaseUtil.runSql("select * from interesting_data where last_updated > sysdate() - 7");
                break;
            case 1:
                DatabaseUtil.runSql("select * from interesting_data where last_updated > sysdate() - 30");
                break;
            case 2: {
                LocalDate now = LocalDate.now();
                int month = now.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                LocalDate endQuarter = now.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                LocalDate beginQuarter = endQuarter.minusMonths(3);
                DatabaseUtil.runSql(String.format(
                        "select * from interesting_data where last_updated between '%s' and '%s'",
                        formatter.format(beginQuarter),
                        formatter.format(endQuarter)));
            }
            break;
            case 3: {
                LocalDate today = LocalDate.now();
                int year = today.getYear();
                LocalDate lastYear = today.withYear(year - 1).withDayOfYear(1);
                LocalDate thisYear = today.withYear(year).withDayOfYear(1);
                DatabaseUtil.runSql(String.format(
                        "select * from interesting_data where last_updated between '%s' and '%s'",
                        formatter.format(lastYear),
                        formatter.format(thisYear)));
            }
            break;
            case 4: {
                LocalDate today = LocalDate.now();
                LocalDate beginningOfYear = today.withDayOfYear(1);
                DatabaseUtil.runSql(String.format(
                        "select * from interesting_data where last_updated > '%s'",
                        formatter.format(beginningOfYear)));
            }
            break;
            case 5: {
                LocalDate today = LocalDate.now();
                int month = today.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                LocalDate beginQuarter = today.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                DatabaseUtil.runSql(String.format(
                        "select * from interesting_data where last_updated > '%s'",
                        formatter.format(beginQuarter)));
            }
            break;
        }
    }

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    static class DatabaseUtil {
        static void runSql(String sql) {
            //we are not worried about hooking up the database yet
            System.out.println("sending to database: " + sql);
        }
    }

    static class DateRangeUtil {
        static int timeRangeCount = 6;

        static String getDisplayString(Integer x) {
            switch (x) {
                case 0:
                    return "Last 7 Days";
                case 1:
                    return "Last 30 Days";
                case 2:
                    return "Last Quarter";
                case 3:
                    return "Last Year";
                case 4:
                    return "Year to Date";
                case 5:
                    return "Quarter to Date";
                default:
                    return null;
            }
        }
    }
}
