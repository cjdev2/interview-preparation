package com.cj.interview.preparation;

import java.time.Instant;
import java.time.ZoneId;
import java.util.List;

public interface TimePeriods {
    List<String> debugTimePeriods(Instant now, ZoneId zoneId);
}
