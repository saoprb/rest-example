package com.rest.example.apiresource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.util.NestedServletException;

import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles({"test"})
@Profile("test")
@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @SpyBean
    @Autowired
    public GreetingController greetingController;

    @Test
    public void test_greeting() throws Exception {
        doReturn(11).when(greetingController).getRandom();
        mockMvc.perform(get("/greeting/Sao"))
                .andDo(print());
    }

    @Test(expected = NestedServletException.class)
    public void test_greetingException() throws Exception {
        doReturn(10).when(greetingController).getRandom();
        mockMvc.perform(get("/greeting/Sao"))
                .andDo(print());
    }

    @Test
    public void test_getRandom() {
        greetingController.getRandom();
    }
}