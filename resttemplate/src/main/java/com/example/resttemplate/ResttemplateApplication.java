package com.example.resttemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.example.resttemplate.dto.Message;

@SpringBootApplication
public class ResttemplateApplication {
	private static final Logger log = LoggerFactory.getLogger(ResttemplateApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ResttemplateApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			String requestURL = "http://localhost:8080/service/message";
			Message msg = restTemplate.getForObject(requestURL, Message.class);
			log.info("IN SERVICE RESPONSE: msg.getMessage() ::" + msg.getMessage());
		};
	}
}
