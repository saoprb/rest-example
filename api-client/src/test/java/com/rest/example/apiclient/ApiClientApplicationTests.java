package com.rest.example.apiclient;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles({"test"})
@Profile("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiClientApplicationTests {

	@Test
	public void contextLoads() {
	}

}
