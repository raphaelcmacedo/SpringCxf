package com.ws.service;

import javax.jws.WebService;

@WebService(endpointInterface="com.ws.service.Hello")
public class HelloImpl implements Hello {

	@Override
	public String hello(String name) {
		return "Hello " + name;
	}

}
