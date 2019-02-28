package com.onsmarttech.invillia;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class InvilliaBackendChallengeApplicationTests {

	@Autowired
	private MockMvc mvc;

	@Autowired
	protected TestRestTemplate template;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testUnauthorized() throws Exception {
		mvc.perform(get("/stores").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isUnauthorized());
	}

	@Test
	public void testAuthorized() throws Exception {
		ResponseEntity<String> result = template.withBasicAuth("spring", "secret").getForEntity("/stores", String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}
}
