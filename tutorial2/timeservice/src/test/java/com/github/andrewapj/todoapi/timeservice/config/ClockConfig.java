package com.github.andrewapj.todoapi.timeservice.config;

import java.time.Clock;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClockConfig {

    @Bean("fixed")
    public Clock getClock() {
        return Clock.fixed(
            LocalDateTime.of(2020, Month.JUNE, 28, 20, 0, 0)
                .toInstant(ZoneOffset.UTC),
            ZoneOffset.UTC);
    }
}
