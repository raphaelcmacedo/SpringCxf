package com.ws.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ws.service.HelloImpl;

@Configuration
public class ServiceConfiguration {

	@Bean
	public SpringBus springBus() {
	    return new SpringBus();
	}
	
	@Bean
	public Endpoint endpoint() {
	    EndpointImpl endpoint = new EndpointImpl(springBus(), new HelloImpl());
	    endpoint.publish("http://localhost:8081/ws/services/Hello");
	    return endpoint;
	}
	
	
}
