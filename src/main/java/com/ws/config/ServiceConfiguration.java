package com.ws.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.ws.service.HelloImpl;
import com.ws.service.SiteService;

@Configuration
@ComponentScan(basePackages = { "com.ws" })
public class ServiceConfiguration {

	@Autowired
	private SiteService siteService;
	
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
	
	@Bean
	 public org.apache.cxf.endpoint.Server jaxRsServer() {
		JAXRSServerFactoryBean factoryBean = new JAXRSServerFactoryBean();
		//factoryBean.setResourceClasses(SiteService.class);
		//factoryBean.setResourceProvider(new SingletonResourceProvider(new SiteService()));
		factoryBean.setServiceBean(siteService);
		factoryBean.setAddress("http://localhost:8081/api/");
		return factoryBean.create();
	 }
	
}
