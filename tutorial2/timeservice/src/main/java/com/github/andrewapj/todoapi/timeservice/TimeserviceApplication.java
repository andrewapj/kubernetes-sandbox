package com.github.andrewapj.todoapi.timeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Service that returns the current time.
 * Designed to be called by other services.
 */
@SpringBootApplication
public class TimeserviceApplication {

    /**
     * Application entry point.
     * @param args the application args.
     */
    public static void main(final String[] args) {
        SpringApplication.run(TimeserviceApplication.class, args);
    }
}
