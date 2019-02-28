package com.onsmarttech.invillia;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.test.context.support.WithMockUser;

import com.onsmarttech.invillia.entities.Store;

public class StoreTests extends InvilliaBackendChallengeApplicationTests {

	@Test
	public void testGetStores() throws Exception {
		ResponseEntity<String> result = this.template.withBasicAuth("spring", "secret").getForEntity("/stores", String.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
	}

	@WithMockUser("spring")
	@Test
	public void testCreateStore() throws Exception {
		Store store = new Store();
		store.setName("Citroen");
		store.setAddress("Rio de Janeiro");

		ResponseEntity<Store> result = this.template.withBasicAuth("spring", "secret").postForEntity("/stores", store, Store.class);
		assertEquals(HttpStatus.OK, result.getStatusCode());
		assertNotNull(result.getBody());
	}

}
