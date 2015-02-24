package com.cj.interview.prep;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/*

Goal:
* Demonstrate knowledge of refactoring, architecture, design patterns, object oriented concepts

Requirements:
* Try to refactor away the need for the duplicate switch statements
* Feel free to add new classes and/or enums
* You should not need to modify the tests

If you need inspiration:
* See page 255 of "Refactoring: Improving the Design of Existing Code", by Martin Fowler

*/
public class DateRangeApplication {
    public static void main(String[] args) throws IOException {
        new DateRangeApplication().testSuite();
    }

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

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

    private String generateQuery(int userSelection, ZonedDateTime now) {
        switch (userSelection) {
            case 0:
                return "select * from interesting_data where last_updated > sysdate() - 7";
            case 1:
                return "select * from interesting_data where last_updated > sysdate() - 30";
            case 2: {
                int month = now.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                ZonedDateTime endQuarter = now.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                ZonedDateTime beginQuarter = endQuarter.minusMonths(3);
                return String.format(
                        "select * from interesting_data where last_updated between '%s' and '%s'",
                        formatter.format(beginQuarter),
                        formatter.format(endQuarter));
            }
            case 3: {
                int year = now.getYear();
                ZonedDateTime lastYear = now.withYear(year - 1).withDayOfYear(1);
                ZonedDateTime thisYear = now.withYear(year).withDayOfYear(1);
                return String.format(
                        "select * from interesting_data where last_updated between '%s' and '%s'",
                        formatter.format(lastYear),
                        formatter.format(thisYear));
            }
            case 4: {
                ZonedDateTime beginningOfYear = now.withDayOfYear(1);
                return String.format(
                        "select * from interesting_data where last_updated > '%s'",
                        formatter.format(beginningOfYear));
            }
            case 5: {
                int month = now.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                ZonedDateTime beginQuarter = now.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                return String.format(
                        "select * from interesting_data where last_updated > '%s'",
                        formatter.format(beginQuarter));
            }
            default:
                throw new RuntimeException(String.format("Invalid id %d", userSelection));
        }
    }

    private String queryForOption(String option, ZonedDateTime now) {
        int optionId = -1;
        for (int i = 0; i < DateRangeUtil.timeRangeCount; i++) {
            if (DateRangeUtil.getDisplayString(i).equals(option)) {
                optionId = i;
                break;
            }
        }
        String query = generateQuery(optionId, now);
        return query;
    }

    private List<String> getDateRangesForUser() {
        List<String> dateRanges = new ArrayList<>();
        for (int i = 0; i < DateRangeUtil.timeRangeCount; i++) {
            String dateRange = DateRangeUtil.getDisplayString(i);
            dateRanges.add(dateRange);
        }
        return dateRanges;
    }

    private void testSuite() {
        testOptionsDisplayedToUser();
        testGeneratedDatabaseQueries();

        System.out.println("ALL TESTS PASSED!");
    }

    private void testOptionsDisplayedToUser() {
        List<String> optionsVisibleToUser = getDateRangesForUser();

        intsEqual(optionsVisibleToUser.size(), 6);

        stringsEqual(optionsVisibleToUser.get(0), "Last 7 Days");
        stringsEqual(optionsVisibleToUser.get(1), "Last 30 Days");
        stringsEqual(optionsVisibleToUser.get(2), "Last Quarter");
        stringsEqual(optionsVisibleToUser.get(3), "Last Year");
        stringsEqual(optionsVisibleToUser.get(4), "Year to Date");
        stringsEqual(optionsVisibleToUser.get(5), "Quarter to Date");
    }

    private void testGeneratedDatabaseQueries() {
        LocalDate date = LocalDate.of(2014, 8, 23);
        LocalTime time = LocalTime.of(3, 15, 20);
        ZoneId zone = ZoneId.of("UTC");
        ZonedDateTime now = ZonedDateTime.of(date, time, zone);

        stringsEqual(queryForOption("Last 7 Days", now), "select * from interesting_data where last_updated > sysdate() - 7");
        stringsEqual(queryForOption("Last 30 Days", now), "select * from interesting_data where last_updated > sysdate() - 30");
        stringsEqual(queryForOption("Last Quarter", now), "select * from interesting_data where last_updated between '2014-04-01' and '2014-07-01'");
        stringsEqual(queryForOption("Last Year", now), "select * from interesting_data where last_updated between '2013-01-01' and '2014-01-01'");
        stringsEqual(queryForOption("Year to Date", now), "select * from interesting_data where last_updated > '2014-01-01'");
        stringsEqual(queryForOption("Quarter to Date", now), "select * from interesting_data where last_updated > '2014-07-01'");
    }

    private void intsEqual(int actual, int expected) {
        if (actual != expected) {
            String message = String.format("FAILURE: expected '%d', but got '%d'", expected, actual);
            throw new RuntimeException(message);
        }
    }

    private void stringsEqual(String actual, String expected) {
        if (!actual.equals(expected)) {
            String message = String.format("FAILURE: expected '%s', but got '%s'", expected, actual);
            throw new RuntimeException(message);
        }
    }
}
