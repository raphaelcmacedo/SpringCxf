package com.ws.service;

import javax.jws.WebService;

@WebService
public interface Hello {
	String hello(String name);
}
