package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.bean.EnteRes;
import gov.mef.gfa.anagrafiche.controller.EnteController;
import gov.mef.gfa.anagrafiche.dao.EnteDao;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.EnteService;

@Service
public class EnteServiceImpl implements EnteService {
	
	@Autowired
	EnteDao enteRepository;	
	private Logger logger = LoggerFactory.getLogger(EnteServiceImpl.class);
	
	public EnteRes getEnteById(BigDecimal id) throws ServiceException {
		
		logger.info("Controller: {} Method: getEnteById", EnteController.class);
		
		try {			
			EnteRes enteRes = new EnteRes();
			enteRes.setEnte(enteRepository.findByIdente(id));
			
			return enteRes;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}
