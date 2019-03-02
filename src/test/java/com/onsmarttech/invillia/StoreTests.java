package com.onsmarttech.invillia;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.onsmarttech.invillia.entities.Store;

public class StoreTests extends InvilliaBackendChallengeApplicationTests {

	@Test
	public void testGetStores() throws Exception {
		this.mvc.perform(get("/stores").with(httpBasic("spring", "secret"))).andExpect(status().isOk());
	}

	@Test
	public void testCreateStore() throws Exception {
		Store store = new Store();
		store.setName("Citroen");
		store.setAddress("Servidão Idalino Damásio Fernandes, 169 - Ingleses - Florianópolis - SC");

		String json = new ObjectMapper().writeValueAsString(store);

		this.mvc.perform(post("/stores").with(httpBasic("spring", "secret")).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isCreated());
	}

	@Test
	public void testUpdateStore() throws Exception {
		MvcResult result = this.mvc.perform(get("/stores/1").with(httpBasic("spring", "secret"))).andDo(print()).andReturn();
		Store store = new ObjectMapper().readValue(result.getResponse().getContentAsString(), Store.class);

		store.setName("Fiat");

		String json = new ObjectMapper().writeValueAsString(store);

		this.mvc.perform(put("/stores/1").with(httpBasic("spring", "secret")).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE).content(json))
				.andExpect(status().isOk());
	}

}
