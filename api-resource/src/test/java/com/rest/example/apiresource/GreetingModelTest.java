package com.rest.example.apiresource;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.TimeZone;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

@ActiveProfiles({"test"})
@Profile("test")
@SpringBootTest
@RunWith(SpringRunner.class)
public class GreetingModelTest {

    @Test
    public void test_equals() {
        EqualsVerifier.forClass(GreetingModel.class)
                .verify();
    }

    @Test
    public void test_toString() {
        GreetingModel x = new GreetingModel("Hello",
                LocalDateTime.now(TimeZone.getTimeZone("UTC").toZoneId()),
                LocalDate.now(TimeZone.getTimeZone("UTC").toZoneId()));
        assertThat(x.toString(), is(notNullValue()));
    }
}