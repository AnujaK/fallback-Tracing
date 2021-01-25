package com.crtbrkr.svcb;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class NameService {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
	private final RestTemplate template;

	public NameService(RestTemplate template) {
		this.template = template;
	}

	@HystrixCommand(fallbackMethod = "defaultName")
	public String createName() {
		URI uri = URI.create("http://localhost:8080/possible");
		LOG.info("In create");
		return this.template.getForObject(uri, String.class);
	}

	private String defaultName() {
		LOG.info("In fallback method");
		return "Super";
	}

}
