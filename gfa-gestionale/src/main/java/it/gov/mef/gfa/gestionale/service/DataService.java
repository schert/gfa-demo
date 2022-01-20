package it.gov.mef.gfa.gestionale.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class DataService {
	
	private Logger logger = LoggerFactory.getLogger(DataService.class);

	@Autowired
	private WebClient.Builder webclientBuilder;
	
	@Value("${gateway.host}")
	private String hostTest;

	public Map<Integer, Double> getLineChartData() {
		
		logger.info("Call getLineChartData: "+hostTest+"/test/api/v1/mapTest");

		Map<Integer, Double> map = webclientBuilder.build().get().uri(hostTest+"/test/api/v1/mapTest").retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<Integer, Double>>() {}).block();

		return map;
	}
}