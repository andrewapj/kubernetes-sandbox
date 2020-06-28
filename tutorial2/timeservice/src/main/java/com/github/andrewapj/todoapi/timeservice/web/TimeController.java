package com.github.andrewapj.todoapi.timeservice.web;

import com.github.andrewapj.todoapi.timeservice.domain.TimeResponse;
import java.time.Clock;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Rest controller for getting the current time.
 */
@RestController
@RequiredArgsConstructor
public class TimeController {

    private final Clock clock;

    /**
     * Get the current time.
     *
     * @return  A {@link TimeResponse} containing the current millis since epoch.
     */
    @GetMapping("/time")
    public TimeResponse getTime() {
        return new TimeResponse(clock.instant().toEpochMilli());
    }
}
