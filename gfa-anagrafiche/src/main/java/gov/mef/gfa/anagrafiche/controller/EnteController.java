package gov.mef.gfa.anagrafiche.controller;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.impl.EnteServiceImpl;
import gov.mef.gfa.common.bean.anagrafica.EnteRes;
import gov.mef.gfa.common.bean.common.StatusRes;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/${path-name.ente}/${api-tag}/v1")
public class EnteController {

	@Autowired
	private EnteServiceImpl enteServices;
	
	Logger logger = LoggerFactory.getLogger(EnteController.class);
	
	@GetMapping("/{id}")
	public ResponseEntity<Mono<EnteRes>> getEnteById(@PathVariable BigDecimal id) {
		logger.info("Controller: {} Method: getEnteById", EnteController.class);
		
		try {		
			Mono<EnteRes> enteResponse = enteServices.getEnteById(id);
			HttpStatus status = enteResponse != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
		    return new ResponseEntity<Mono<EnteRes>>(enteResponse, status);
		} catch (ServiceException e) {
			EnteRes enteResponse = new EnteRes();
			logger.error("Controller: {} Method: getEnteById", EnteController.class);
			e.printStackTrace();
			enteResponse.setStatus(StatusRes.error("Errore nel recuperare le informazioni", id));
			return new ResponseEntity<Mono<EnteRes>>(Mono.just(enteResponse), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/mapTest")
	public Map<Integer, Double> getLineChartMapvalue() throws IOException{
		
		logger.info("Call: getMap");
		
		Map<Integer, Double> map = new LinkedHashMap<>();
		map.put(1, 5.20);
		map.put(2, 19.63);
		map.put(3, 59.01);
		map.put(4, 139.76);
		map.put(5, 300.4);
		map.put(6, 630.0);
		
		return map;
	}
}
