package gov.mef.gfa.gestionale.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import gov.mef.gfa.common.gfacommon.Routes;
import gov.mef.gfa.gestionale.model.EnteRes;

@Service
public class DataService {

	private Logger logger = LoggerFactory.getLogger(DataService.class);

	@Autowired
	private WebClient.Builder webclientBuilder;

	public Map<Integer, Double> getLineChartData() {

		logger.info("Controller: {} Method: getLineChartData", DataService.class);

		Map<Integer, Double> map = webclientBuilder.build().get().uri(Routes.ANAGRAFICA_TEST).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<Integer, Double>>() {
				}).block();

		return map;
	}

	public EnteRes getEnteById(Integer id) {
		logger.info("Controller: {} Method: getEnteById", DataService.class);

		return webclientBuilder.build().get().uri(uriBuilder -> uriBuilder.path(Routes.ANAGRAFICA_ENTE).build(id))
				.retrieve().bodyToMono(EnteRes.class).block();
	}
}