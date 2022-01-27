package gov.mef.gfa.gestionale;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class GfaGestionaleApplication {
	
	@Value("${gateway.host}")
	private String hostTest;

	public static void main(String[] args) {
		SpringApplication.run(GfaGestionaleApplication.class, args);
	}
	
	@Bean
	public WebClient.Builder getWebClientBuilder() {
		return WebClient.builder().baseUrl(hostTest);
	}
}
