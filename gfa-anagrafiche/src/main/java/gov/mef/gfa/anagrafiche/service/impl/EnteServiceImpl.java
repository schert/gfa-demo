package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.controller.EnteController;
import gov.mef.gfa.anagrafiche.dao.EnteDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.EnteService;
import gov.mef.gfa.common.bean.anagrafica.EntePO;
import gov.mef.gfa.common.bean.anagrafica.EnteRes;
import gov.mef.gfa.common.utils.MapperUtils;

@Service
public class EnteServiceImpl implements EnteService {
	
	@Autowired
	EnteDAO enteRepository;	
	private Logger logger = LoggerFactory.getLogger(EnteServiceImpl.class);
	
	public EnteRes getEnteById(BigDecimal id) throws ServiceException {
		
		logger.info("Controller: {} Method: getEnteById", EnteController.class);
		
		try {			
			EnteRes enteRes = new EnteRes();			
			EntePO entePO = MapperUtils.copyProperties(enteRepository.findByIdente(id), EntePO.class);			
			enteRes.setEnte(entePO);
			
			return enteRes;
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}
