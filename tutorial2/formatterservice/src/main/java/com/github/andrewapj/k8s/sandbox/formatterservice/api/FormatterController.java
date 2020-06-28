package com.github.andrewapj.k8s.sandbox.formatterservice.api;

import com.github.andrewapj.k8s.sandbox.formatterservice.api.model.FormattedTimeResponse;
import com.github.andrewapj.k8s.sandbox.formatterservice.request.TimeRequester;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Endpoint that gets a time response and formats it.
 */
@RestController
@RequiredArgsConstructor
public class FormatterController {

    private final TimeRequester requester;

    /**
     * Gets a formatted time.
     *
     * @return  the formatted time response.
     */
    @GetMapping("/formattedtime")
    public FormattedTimeResponse getFormattedTime() {
        return new FormattedTimeResponse(format(requester.getTimeInMillis()));
    }

    private String format(final Long millis) {

        LocalDateTime datetime = LocalDateTime.ofInstant(
            Instant.ofEpochMilli(millis), ZoneOffset.UTC);

        return "The current time is " + DateTimeFormatter.ofPattern("EEEE, MMMM dd, yyyy HH:mm:ss")
            .format(datetime) + " GMT";
    }
}
