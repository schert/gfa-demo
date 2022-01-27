package gov.mef.gfa.anagrafiche.service;

import gov.mef.gfa.anagrafiche.bean.EnteRes;
import gov.mef.gfa.anagrafiche.excepltion.ServiceException;

public interface EnteService {
	public EnteRes getEnteById(Integer id) throws ServiceException;
}
