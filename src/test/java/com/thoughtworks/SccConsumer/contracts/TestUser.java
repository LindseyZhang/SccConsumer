package com.thoughtworks.SccConsumer.contracts;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.stubrunner.spring.StubRunnerProperties;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
@RunWith(SpringRunner.class)
@AutoConfigureStubRunner(ids = {"com.thoughtworks:SccProducer:+:stubs:8080"}, stubsMode = StubRunnerProperties.StubsMode.LOCAL)
public class TestUser {

	@Autowired
	RestTemplate restTemplate;

	@Test
	public void test_get_users() {
		final String users = restTemplate.getForObject("/users", String.class);
		final String expectedUsers = "[{\"username\":\"Zhang san\",\"country\":\"China\"},{\"username\":\"Steven Jobs\",\"country\":\"US\"}]";
		assertThat(users).isEqualTo(expectedUsers);
	}
}
