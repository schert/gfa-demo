package gov.mef.gfa.gestionale.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.reactive.function.client.WebClient;

import gov.mef.gfa.common.Routes;
import gov.mef.gfa.common.bean.anagrafica.EnteRes;
import gov.mef.gfa.common.client.GfaClient;

@Service
@RequestScope
public class DataService  {

	private Logger logger = LoggerFactory.getLogger(DataService.class);

	@Autowired
	private WebClient.Builder webClientBuilder;

	public Map<Integer, Double> getLineChartData() {

		logger.info("Controller: {} Method: getLineChartData", DataService.class);

		Map<Integer, Double> map = webClientBuilder.build().get().uri(Routes.ANAGRAFICA_TEST_ENTE.getPath()).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<Integer, Double>>() {
				}).block();

		return map;
	}

	public EnteRes getEnteById(Integer id) {
		logger.info("Controller: {} Method: getEnteById", DataService.class);
		
		return GfaClient.apiCallGetPathParams(webClientBuilder, EnteRes.class, Routes.ANAGRAFICA_ENTE, new Object[] {id});
	}
}