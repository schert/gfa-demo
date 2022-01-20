package com.example.gfaBe.controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import gov.mef.gfa.common.gfacommon.GfaClient;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/api/v1")
public class TestController {

//	@Autowired
//	private TestRepository userRepository;
	
	Logger logger = LoggerFactory.getLogger(TestController.class);

	/**
	 * Get all test list.
	 *
	 * @return the list
	 */
//	@GetMapping("/tests")
//	@ApiOperation(value = "get all", notes = "test call")
//	public List<Test> getAllTests() {
//		// Only for test! Respect: controller -> service -> model -> dao
//		
//		logger.info("Call: getAllTests");
//		return userRepository.findAll();
//	}
	
	@Autowired
	@Qualifier("1")
	GfaClient GfaClientImpl2;
	
	@GetMapping("/mapTest")
	@ApiOperation(value = "line chart", notes = "get line chart value")
	public Map<Integer, Double> getLineChartMapvalue() throws IOException{
		
		logger.info("Call: getMap");
		
		logger.info(GfaClientImpl2.test());
		
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
