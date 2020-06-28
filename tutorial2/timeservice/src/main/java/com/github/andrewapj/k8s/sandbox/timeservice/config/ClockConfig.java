package com.github.andrewapj.k8s.sandbox.timeservice.config;

import java.time.Clock;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration for a clock.
 */
@Configuration
public class ClockConfig {

    /**
     * Builds a clock using the UTC timezone.
     *
     * @return  the clock with timezone = UTC.
     */
    @Bean
    public Clock getClock() {
        return Clock.systemUTC();
    }
}
