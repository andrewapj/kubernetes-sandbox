package com.github.andrewapj.k8s.sandbox.formatterservice;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import com.github.andrewapj.k8s.sandbox.formatterservice.api.FormatterController;
import com.github.andrewapj.k8s.sandbox.formatterservice.api.model.FormattedTimeResponse;
import com.github.andrewapj.k8s.sandbox.formatterservice.request.TimeRequester;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class FormatterTest {

    @Autowired private FormatterController formatterController;
    @MockBean private TimeRequester timeRequester;

    @BeforeEach
    void setup() {
        when(timeRequester.getTimeInMillis()).thenReturn(1593388800000L);
    }

    @Test
    void shouldGetTimeFromService() {

        FormattedTimeResponse response = given().
            standaloneSetup(formatterController)
            .contentType(ContentType.JSON)
            .when()
            .get("/formattedtime")
            .then()
            .status(HttpStatus.OK)
            .extract().as(FormattedTimeResponse.class);

        assertThat(response.getMessage())
            .isEqualTo("The current time is Monday, June 29, 2020 00:00:00 GMT");
    }
}
