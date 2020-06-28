package com.github.andrewapj.k8s.sandbox.formatterservice.request;

/**
 * Responsible for retrieving a time from an external resource.
 */
public interface TimeRequester {

    /**
     * Gets the time in millis from an external source.
     *
     * @return  the millis since epoch.
     */
    Long getTimeInMillis();
}
