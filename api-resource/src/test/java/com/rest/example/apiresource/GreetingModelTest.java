package com.rest.example.apiresource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

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
        GreetingModel x = new GreetingModel("Hello");
        GreetingModel y = new GreetingModel("Hello");
        assertThat(x.equals(y), is(true));

        GreetingModel z = new GreetingModel("World");
        assertThat(x.equals(z), is(false));
    }

    @Test
    public void test_canEqual() {
        GreetingModel x = new GreetingModel("Hello");
        GreetingModel y = new GreetingModel("Hello");
        assertThat(x.canEqual(y), is(true));
        assertThat(x.canEqual(new String()), is(false));
    }

    @Test
    public void test_hashCode() {
        GreetingModel x = new GreetingModel("Hello");
        assertThat(x.hashCode(), is(notNullValue()));
    }

    @Test
    public void test_toString() {
        GreetingModel x = new GreetingModel("Hello");
        assertThat(x.toString(), is(notNullValue()));
    }
}