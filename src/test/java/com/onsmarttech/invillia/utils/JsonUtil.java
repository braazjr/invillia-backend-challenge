package com.onsmarttech.invillia.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtil {

	public static String convertObjectToString(Object object) throws JsonProcessingException {
		return new ObjectMapper().writeValueAsString(object);
	}

}
