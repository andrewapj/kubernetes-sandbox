package com.github.andrewapj.k8s.sandbox.formatterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A Service that fetches the current time from the time service and formats it.
 */
@SpringBootApplication
public class FormatterserviceApplication {

    /**
     * Application entry point.
     *
     * @param args the appllication args.
     */
    public static void main(final String[] args) {
        SpringApplication.run(FormatterserviceApplication.class, args);
    }
}
