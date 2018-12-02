package com.rest.example.apiclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.cloud.netflix.ribbon.RibbonAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.cloud.openfeign.ribbon.FeignRibbonClientAutoConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

@ActiveProfiles({"test"})
@Profile("test")
@RunWith(SpringRunner.class)
@WebMvcTest(GreetingController.class)
@ImportAutoConfiguration({
        RibbonAutoConfiguration.class,
        FeignRibbonClientAutoConfiguration.class,
        FeignAutoConfiguration.class
})
public class GreetingControllerTest {

    @Autowired
    public MockMvc mockMvc;

    @TestConfiguration
    public static class mockConfig {

        @Bean
        public GreetingClient.GreetingClientFallback greetingClientFallback() {
            return new GreetingClient.GreetingClientFallback();
        }
    }

    @SpyBean
    @Autowired
    public GreetingController greetingController;

    @Test
    public void test_greeting() throws Exception {
        mockMvc.perform(get("/greeting/Sao"))
                .andDo(print());
    }
}