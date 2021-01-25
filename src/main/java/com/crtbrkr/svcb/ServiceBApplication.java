package com.crtbrkr.svcb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@EnableCircuitBreaker
@RestController
@SpringBootApplication
public class ServiceBApplication {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private NameService service;

	@Bean
	public RestTemplate rest(RestTemplateBuilder builder) {
		return builder.build();
	}

	@RequestMapping("/produce")
	public String produceName() {
		LOG.info("IN produce");
		return service.createName();
	}
	public static void main(String[] args) {
		SpringApplication.run(ServiceBApplication.class, args);
	}

}
