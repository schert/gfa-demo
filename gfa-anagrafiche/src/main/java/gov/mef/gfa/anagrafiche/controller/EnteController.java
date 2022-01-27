package gov.mef.gfa.anagrafiche.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.constraints.NotNull;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.mef.gfa.anagrafiche.bean.EnteRes;
import gov.mef.gfa.anagrafiche.excepltion.ServiceException;
import gov.mef.gfa.anagrafiche.service.impl.EnteServiceImpl;
import gov.mef.gfa.common.gfacommon.bean.StatusRes;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/${path-name.ente}/${api-tag}/v1")
public class EnteController {

	@Autowired
	private EnteServiceImpl enteServices;
	
	Logger logger = LoggerFactory.getLogger(EnteController.class);
	
	@GetMapping("/{id}")
	@ApiOperation(value = "Recupero Ente per ID", notes = "Restituisce tutte le informazioni relative all'ente ricercato tramite ID")
	public EnteRes getEnteById(@PathVariable @NotNull Integer id) {
		logger.info("Controller: {} Method: getEnteById", EnteController.class);
		EnteRes enteResponse = new EnteRes();
		
		try {		
			enteResponse = enteServices.getEnteById(id);
			enteResponse.setStatus(StatusRes.success());
			return enteResponse;
		} catch (ServiceException e) {
			logger.error("Controller: {} Method: getEnteById", EnteController.class);
			e.printStackTrace();
			enteResponse.setStatus(StatusRes.error("Errore nel recuperare le informazioni", id));
			return enteResponse;
		}
	}
	
	@GetMapping("/mapTest")
	@ApiOperation(value = "line chart", notes = "get line chart value")
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
