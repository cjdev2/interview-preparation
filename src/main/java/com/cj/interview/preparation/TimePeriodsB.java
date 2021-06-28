package com.cj.interview.preparation;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class TimePeriodsB implements TimePeriods {
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE;

    @Override
    public List<String> debugTimePeriods(Instant now, ZoneId zoneId) {
        List<String> lines = new ArrayList<>();
        for (TimePeriod timePeriod : TimePeriod.values()) {
            DateRange dateRange = timePeriod.toDateRange(now, zoneId);
            String formattedStart = dateTimeFormatter.format(dateRange.start);
            String formattedEnd = dateTimeFormatter.format(dateRange.end);
            String apiParameters = String.format("start=%s&end=%s", formattedStart, formattedEnd);
            String timePeriodName = timePeriod.displayName;
            String debugLine = String.format("%-15s -> %s", timePeriodName, apiParameters);
            lines.add(debugLine);
        }
        return lines;
    }

    static class DateRange {
        public final ZonedDateTime start;
        public final ZonedDateTime end;

        public DateRange(ZonedDateTime start, ZonedDateTime end) {
            this.start = start;
            this.end = end;
        }
    }

    enum TimePeriod {
        LAST_7_DAYS("Last 7 days") {
            @Override
            public DateRange toDateRange(ZonedDateTime today) {
                ZonedDateTime start = today.minusDays(7);
                return new DateRange(start, today);
            }
        },
        LAST_30_DAYS("Last 30 Days") {
            @Override
            public DateRange toDateRange(ZonedDateTime today) {
                ZonedDateTime start = today.minusDays(30);
                return new DateRange(start, today);
            }

        },
        LAST_QUARTER("Last Quarter") {
            @Override
            public DateRange toDateRange(ZonedDateTime today) {
                int month = today.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                ZonedDateTime endQuarter = today.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                ZonedDateTime beginQuarter = endQuarter.minusMonths(3);
                return new DateRange(beginQuarter, endQuarter);
            }
        },
        LAST_YEAR("Last Year") {
            @Override
            public DateRange toDateRange(ZonedDateTime today) {
                int year = today.getYear();
                ZonedDateTime lastYear = today.withYear(year - 1).withDayOfYear(1);
                ZonedDateTime thisYear = today.withYear(year).withDayOfYear(1);
                return new DateRange(lastYear, thisYear);
            }
        },
        YEAR_TO_DATE("Year to Date") {
            @Override
            public DateRange toDateRange(ZonedDateTime today) {
                ZonedDateTime beginningOfYear = today.withDayOfYear(1);
                return new DateRange(beginningOfYear, today);
            }
        },
        QUARTER_TO_DATE("Quarter to Date") {
            @Override
            public DateRange toDateRange(ZonedDateTime today) {
                int month = today.getMonthValue();
                int quarter = (month + 2) / 3;
                int monthAtBeginningOfQuarter = quarter * 3 - 2;
                ZonedDateTime beginQuarter = today.withDayOfMonth(1).withMonth(monthAtBeginningOfQuarter);
                return new DateRange(beginQuarter, today);
            }
        };
        public final String displayName;

        TimePeriod(String displayName) {
            this.displayName = displayName;
        }

        public abstract DateRange toDateRange(ZonedDateTime today);

        public final DateRange toDateRange(Instant now, ZoneId zoneId) {
            ZonedDateTime today = ZonedDateTime.ofInstant(now, zoneId).truncatedTo(ChronoUnit.DAYS);
            return toDateRange(today);
        }
    }
}
