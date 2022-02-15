package gov.mef.gfa.filemanager.service;

import java.math.BigDecimal;

import gov.mef.gfa.filemanager.exception.ServiceException;

public interface DocumentaleService {
	
	public BigDecimal setDocEntrata(byte[] file) throws ServiceException;
	public void deleteContent(BigDecimal idFile) throws ServiceException;

}
