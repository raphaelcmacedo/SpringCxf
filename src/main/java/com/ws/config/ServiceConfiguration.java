package com.ws.config;

import java.sql.SQLException;
import java.util.Properties;

import javax.annotation.Resource;
import javax.sql.DataSource;
import javax.xml.ws.Endpoint;

import oracle.jdbc.pool.OracleDataSource;

import org.apache.cxf.bus.spring.SpringBus;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxws.EndpointImpl;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.ws.service.HelloImpl;
import com.ws.service.SiteService;

@Configuration
@EnableTransactionManagement
@PropertySource({ "classpath:oracle.properties" })
@ComponentScan(basePackages = { "com.ws" })
public class ServiceConfiguration {

	@Autowired
	private SiteService siteService;
	@Resource
	public Environment env;

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
		factoryBean.setServiceBean(siteService);
		factoryBean.setAddress("http://localhost:8081/api/");
		return factoryBean.create();
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() throws SQLException {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(this.dataSource());

		String[] packages = new String[] { "com.ws.entity" };
		sessionFactory.setPackagesToScan(packages);
		sessionFactory.setHibernateProperties(hibernateProperties());

		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() throws SQLException {

		String url = env.getProperty("jdbc.url");
		String username = env.getProperty("jdbc.username");
		String password = env.getProperty("jdbc.password");

		OracleDataSource dataSource = new OracleDataSource();
		dataSource.setUser(username);
		dataSource.setPassword(password);
		dataSource.setURL(url);
		dataSource.setImplicitCachingEnabled(false);
		dataSource.setFastConnectionFailoverEnabled(true);
		return dataSource;
	}

	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(
			SessionFactory sessionFactory) {

		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}

	@Bean
	public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
		return new PersistenceExceptionTranslationPostProcessor();
	}

	Properties hibernateProperties() {
		return new Properties() {
			{
				setProperty("hibernate.hbm2ddl.auto",
						env.getProperty("hibernate.hbm2ddl.auto"));
				setProperty("hibernate.dialect",
						env.getProperty("hibernate.dialect"));
				setProperty("hibernate.show_sql",
						env.getProperty("hibernate.show_sql"));
				setProperty("hibernate.globally_quoted_identifiers", "true");
				setProperty("hibernate.id.new_generator_mappings", "true");
			}
		};
	}

}
