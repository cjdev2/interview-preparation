package com.cj.interview.preparation;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TimePeriodsA implements TimePeriods {
    final int TIME_PERIOD_LAST_7_DAYS = 0;
    final int TIME_PERIOD_LAST_30_DAYS = 1;
    final int TIME_PERIOD_LAST_QUARTER = 2;
    final int TIME_PERIOD_LAST_YEAR = 3;
    final int TIME_PERIOD_YEAR_TO_DATE = 4;
    final int TIME_PERIOD_QUARTER_TO_DATE = 5;
    final int TIME_PERIOD_COUNT = 6;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public List<String> debugTimePeriods(Instant now, ZoneId zoneId) {
        List<String> lines = new ArrayList<>();
        for (int i = 0; i < TIME_PERIOD_COUNT; i++) {
            ZonedDateTime start = timePeriodStart(i, now, zoneId);
            ZonedDateTime end = timePeriodEnd(i, now, zoneId);
            String formattedStart = dateTimeFormatter.format(start);
            String formattedEnd = dateTimeFormatter.format(end);
            String apiParameters = String.format("start=%s&end=%s", formattedStart, formattedEnd);
            String timePeriodName = timePeriodDisplayName(i);
            String debugLine = String.format("%-15s -> %s", timePeriodName, apiParameters);
            lines.add(debugLine);
        }
        return lines;
    }

    public String timePeriodDisplayName(int index) {
        switch (index) {
            case TIME_PERIOD_LAST_7_DAYS:
                return "Last 7 Days";
            case TIME_PERIOD_LAST_30_DAYS:
                return "Last 30 Days";
            case TIME_PERIOD_LAST_QUARTER:
                return "Last Quarter";
            case TIME_PERIOD_LAST_YEAR:
                return "Last Year";
            case TIME_PERIOD_YEAR_TO_DATE:
                return "Year to Date";
            case TIME_PERIOD_QUARTER_TO_DATE:
                return "Quarter to Date";
            default:
                String message = String.format("Invalid index %d for time period", index);
                throw new RuntimeException(message);
        }
    }

    public ZonedDateTime timePeriodStart(int index, Instant now, ZoneId zoneId) {
        ZonedDateTime today = truncateToDay(now, zoneId);
        switch (index) {
            case TIME_PERIOD_LAST_7_DAYS:
                return today.minusDays(7);
            case TIME_PERIOD_LAST_30_DAYS:
                return today.minusDays(30);
            case TIME_PERIOD_LAST_QUARTER: {
                int month = today.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                ZonedDateTime endQuarter = today.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                return endQuarter.minusMonths(3);
            }
            case TIME_PERIOD_LAST_YEAR:
                int year = today.getYear();
                return today.withYear(year - 1).withDayOfYear(1);
            case TIME_PERIOD_YEAR_TO_DATE:
                return today.withDayOfYear(1);
            case TIME_PERIOD_QUARTER_TO_DATE: {
                int month = today.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                return today.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
            }
            default:
                String message = String.format("Invalid index %d for time period", index);
                throw new RuntimeException(message);
        }
    }

    public ZonedDateTime timePeriodEnd(int index, Instant now, ZoneId zoneId) {
        ZonedDateTime today = truncateToDay(now, zoneId);
        switch (index) {
            case TIME_PERIOD_LAST_7_DAYS:
            case TIME_PERIOD_LAST_30_DAYS:
            case TIME_PERIOD_YEAR_TO_DATE:
            case TIME_PERIOD_QUARTER_TO_DATE:
                return today;
            case TIME_PERIOD_LAST_QUARTER: {
                int month = today.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                return today.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
            }
            case TIME_PERIOD_LAST_YEAR:
                int year = today.getYear();
                return today.withYear(year).withDayOfYear(1);
            default:
                String message = String.format("Invalid index %d for time period", index);
                throw new RuntimeException(message);
        }
    }

    ZonedDateTime truncateToDay(Instant now, ZoneId zoneId) {
        return ZonedDateTime.ofInstant(now, zoneId).truncatedTo(ChronoUnit.DAYS);
    }
}
