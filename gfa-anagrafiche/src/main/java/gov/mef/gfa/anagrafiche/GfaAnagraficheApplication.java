package gov.mef.gfa.anagrafiche;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@ComponentScan({"gov.mef.gfa"})
@OpenAPIDefinition(info = @Info(title = "Anagrafiche API", version = "1.0", description = "REST API del microservizio gfa-anagrafiche"))
public class GfaAnagraficheApplication {

	public static void main(String[] args) {
		SpringApplication.run(GfaAnagraficheApplication.class, args);
	}

	@Bean
	public WebClient.Builder getWebClientBuilder() {
	    return WebClient.builder();
	}
	
	@Bean
	public LocaleResolver localeResolver() {
	    SessionLocaleResolver slr = new SessionLocaleResolver();
	    slr.setDefaultLocale(Locale.ITALIAN);
	    return slr;
	}
}
