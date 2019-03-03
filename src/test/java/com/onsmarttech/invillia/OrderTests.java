package com.onsmarttech.invillia;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.Arrays;

import org.junit.Test;
import org.springframework.http.MediaType;

import com.onsmarttech.invillia.entities.Order;
import com.onsmarttech.invillia.entities.OrderItem;
import com.onsmarttech.invillia.entities.Store;
import com.onsmarttech.invillia.utils.JsonUtil;

public class OrderTests extends InvilliaBackendChallengeApplicationTests {

	@Test
	public void testCreateOrder() throws Exception {
		Order order = new Order();
		order.setAddress("Rio de Janeiro - RJ");
		order.setConfirmationDate(LocalDate.parse("2019-03-03"));
		order.setStatus(true);
		order.setStore(new Store(1));

		OrderItem item = new OrderItem();
		item.setDescription("Burguer 100g");
		item.setQuantity(BigInteger.ONE);
		item.setUnitPrice(BigDecimal.valueOf(2.99));

		order.setOrderItems(Arrays.asList(item));

		this.mvc.perform(post("/orders").with(httpBasic("spring", "secret")).accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON_VALUE)
				.content(JsonUtil.convertObjectToString(order))).andExpect(status().isCreated());
	}
}
