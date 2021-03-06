package com.github.andrewapj.k8s.sandbox.timeservice.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A response object representing the current millis since epoch.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimeResponse {

    private Long timeInMillis;
}
