package com.ws.service;

import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(endpointInterface="com.ws.service.Hello", name="Hello")
public class HelloImpl implements Hello {

	@WebResult(name="message", partName="message")
	public String hello(@WebParam(name="name",partName="name") String name) {
		return "Hello " + name;
	}

}
