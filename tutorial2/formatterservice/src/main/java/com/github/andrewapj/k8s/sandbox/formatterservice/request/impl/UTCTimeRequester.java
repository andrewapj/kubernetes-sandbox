package com.github.andrewapj.k8s.sandbox.formatterservice.request.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.andrewapj.k8s.sandbox.formatterservice.request.TimeRequester;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.time.temporal.ChronoUnit;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

/**
 * Implementation of a {@link TimeRequester}.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UTCTimeRequester implements TimeRequester {

    private static final long TIMEOUT_DURATION = 10;

    private final HttpClient client = HttpClient.newHttpClient();
    private final ObjectMapper mapper;

    @Value("${app.timeHost}") private String host;
    @Value("${app.timeHostPort}") private String port;
    @Value("${app.timeHostPath}") private String path;

    @Override
    public Long getTimeInMillis() {

        String url = "http://" + host + ":" + port + path;

        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .timeout(Duration.of(TIMEOUT_DURATION, ChronoUnit.SECONDS))
            .header("Content-Type", MediaType.APPLICATION_JSON_VALUE)
            .GET()
            .build();

        try {
            HttpResponse<String> response = client.send(
                request, HttpResponse.BodyHandlers.ofString());

            JsonNode node = mapper.readTree(response.body());
            return node.get("timeInMillis").asLong();
        }
        catch (IOException | InterruptedException ex) {
            log.error("Unable to get time from {}", url, ex);
            throw new RuntimeException();
        }
    }
}
