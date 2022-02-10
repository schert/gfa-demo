package gov.mef.gfa.gestionale.service;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.web.reactive.function.client.WebClient;

import gov.mef.gfa.common.Routes;
import gov.mef.gfa.common.bean.anagrafica.EnteRes;
import gov.mef.gfa.common.client.GfaClient;

public class DataService {

	private static String gatewayHost;
	private Logger logger = LoggerFactory.getLogger(DataService.class);
	private static DataService instance = null;
	private WebClient.Builder webClientBuilder;

	private DataService() {
		webClientBuilder = WebClient.builder().baseUrl(gatewayHost);
	}
	
	public static DataService setGateway(String gatewayHost) {
		DataService.setGatewayHost(gatewayHost);
		DataService instance = DataService.getInstance();
		return instance;
	}
	
	public static void setGatewayHost(String gatewayHost) {
		DataService.gatewayHost = gatewayHost;
	}

	public static DataService getInstance() {
		if (instance == null) {
			instance = new DataService();
		}
		return instance;
	}

	public Map<Integer, Double> getLineChartData() {

		logger.info("Controller: {} Method: getLineChartData", DataService.class);

		Map<Integer, Double> map = webClientBuilder.build().get().uri(Routes.ANAGRAFICA_TEST_ENTE.getPath()).retrieve()
				.bodyToMono(new ParameterizedTypeReference<Map<Integer, Double>>() {
				}).block();

		return map;
	}

	public EnteRes getEnteById(Integer id) {
		logger.info("Controller: {} Method: getEnteById", DataService.class);

		return GfaClient.apiCallGetPathParams(webClientBuilder, EnteRes.class, Routes.ANAGRAFICA_ENTE,
				new Object[] { id });
	}
}