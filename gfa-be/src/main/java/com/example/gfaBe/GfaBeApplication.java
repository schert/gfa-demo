package com.example.gfaBe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@ComponentScan({"com.example.gfaBe","gov.mef.gfa"})
@EnableSwagger2
public class GfaBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(GfaBeApplication.class, args);
	}

	@Bean
	public WebClient.Builder getWebClientBuilder() {
	    return WebClient.builder();
	}
}
