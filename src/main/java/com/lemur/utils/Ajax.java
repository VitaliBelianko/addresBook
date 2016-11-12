package com.lemur.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Виталий on 30.10.2016.
 */
public class Ajax {
	public static Map<String, Object> successResponse(Object object) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("result", "success");
		response.put("data", object);
		return response;
	}

	public static Map<String, Object> emptyResponse() {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("result", "success");
		return response;
	}

	public static Map<String, Object> errorResponse(String errorMessage) {
		Map<String, Object> response = new HashMap<String, Object>();
		response.put("result", "error");
		response.put("message", errorMessage);
		return response;
	}
}
