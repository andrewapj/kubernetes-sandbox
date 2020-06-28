package com.github.andrewapj.k8s.sandbox.formatterservice.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Formatted time response.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FormattedTimeResponse {

    private String message;
}
