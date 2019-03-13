package com.onsmarttech.invillia;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestPropertySource(locations = "classpath:test.properties")
public class InvilliaBackendChallengeApplicationTests {

	@Autowired
	protected MockMvc mvc;

	@Autowired
	protected TestRestTemplate template;

	@Test
	public void testUnauthorized() throws Exception {
		mvc.perform(get("/stores/filter")).andExpect(status().isUnauthorized());
	}

	@Test
	public void testAuthorized() throws Exception {
		mvc.perform(get("/stores/filter").with(httpBasic("spring", "secret"))).andExpect(status().isOk());
	}
}
