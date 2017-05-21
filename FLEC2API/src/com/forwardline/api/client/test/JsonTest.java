package com.forwardline.api.client.test;

import com.forwardline.api.milo.types.ApplicationResponse;
import com.google.gson.Gson;

public class JsonTest {

	public JsonTest() {
		String s = "{\"succes\":true,\"error\":null,\"nApplication\":{\"id\":\"TEST\",\"name\":\"\"}}";
		Gson gson = new Gson();
		ApplicationResponse lr = gson.fromJson(s, ApplicationResponse.class);
		System.out.println(lr.getnApplication().getId());
		
	}
	
	public static void main(String[] args) {
		JsonTest t = new JsonTest();
		
	}
}
