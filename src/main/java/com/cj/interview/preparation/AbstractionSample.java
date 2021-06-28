package com.cj.interview.preparation;

import java.time.Clock;
import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

public class AbstractionSample implements Runnable {
    public static void main(String[] args) {
        new AbstractionSample().run();
    }

    @Override
    public void run() {
        debug(new TimePeriodsA());
        debug(new TimePeriodsB());
    }

    void debug(TimePeriods timePeriods) {
        ZoneId zoneId = ZoneId.systemDefault();
        Clock clock = Clock.system(zoneId);
        Instant now = clock.instant();
        List<String> lines = timePeriods.debugTimePeriods(now, zoneId);
        for (String line : lines) {
            System.out.println(line);
        }
        System.out.println();
    }
}
