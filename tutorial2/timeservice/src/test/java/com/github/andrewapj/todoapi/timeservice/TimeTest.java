package com.github.andrewapj.todoapi.timeservice;

import static io.restassured.module.mockmvc.RestAssuredMockMvc.given;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.andrewapj.todoapi.timeservice.domain.TimeResponse;
import com.github.andrewapj.todoapi.timeservice.web.TimeController;
import io.restassured.http.ContentType;
import java.time.Clock;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;

@SpringBootTest
public class TimeTest {

    @Autowired
    @Qualifier("fixed")
    private Clock fixedClock;

    @Autowired private TimeController timeController;

    @Test
    void shouldGetCorrectTime() {

        TimeResponse response = given().
            standaloneSetup(timeController)
            .contentType(ContentType.JSON)
            .when()
            .get("/time")
            .then()
            .status(HttpStatus.OK)
            .extract().as(TimeResponse.class);

        assertThat(response.getTimeInMillis()).isEqualTo(1593374400000L);
    }
}
