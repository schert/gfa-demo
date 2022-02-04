package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.EnteRes;

public interface EnteService {
	public EnteRes getEnteById(BigDecimal id) throws ServiceException;
}
