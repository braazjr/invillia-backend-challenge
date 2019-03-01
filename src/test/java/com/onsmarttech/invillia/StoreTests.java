package com.onsmarttech.invillia;

import static org.junit.Assert.assertEquals;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onsmarttech.invillia.entities.Store;

public class StoreTests extends InvilliaBackendChallengeApplicationTests {

	@Test
	public void testGetStores() throws Exception {
		ResponseEntity<String> result = this.template.withBasicAuth("spring", "secret").getForEntity("/stores", String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@Test
	public void testCreateStore() throws Exception {
		Store store = new Store();
		store.setName("Citroen");
		store.setAddress("Rio de Janeiro");

		String json = new ObjectMapper().writeValueAsString(store);

		this.mvc.perform(
				post("/stores/user").with(httpBasic("spring", "secret")).contentType("application/json;charset=UTF-8").content(json).accept("application/json;charset=UTF-8"))
				.andExpect(status().isCreated());
	}

}
