package com.fresh.coding.bookverse.utils;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Clock;
import java.util.Date;

@Component
@RequiredArgsConstructor
public class TimeProvider {
    private final Clock clock;

    public Date now() {
        return Date.from(clock.instant());
    }
}