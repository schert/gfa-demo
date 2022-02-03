package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.bean.EnteRes;
import gov.mef.gfa.anagrafiche.exception.ServiceException;

public interface EnteService {
	public EnteRes getEnteById(BigDecimal id) throws ServiceException;
}
