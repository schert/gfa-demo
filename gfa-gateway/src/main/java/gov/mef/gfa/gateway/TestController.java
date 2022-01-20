package gov.mef.gfa.gateway;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

@RestController
public class TestController {
	
	@Autowired
	private WebClient.Builder webclientBuilder;
	
	@GetMapping("testCall")
	private Mono<Map<Integer, Double>> testCall() {
		return webclientBuilder.build().get().uri("localhost:8081/test/api/v1/mapTest").retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<Integer, Double>>() {});
	}

}
