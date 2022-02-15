package gov.mef.gfa.filemanager.service.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import gov.mef.gfa.filemanager.exception.ServiceException;
import gov.mef.gfa.filemanager.service.DocumentaleService;

@Service
public class DocumentaleServiceImpl implements DocumentaleService {

	@Override
	public BigDecimal setDocEntrata(byte[] file) throws ServiceException {
		return new BigDecimal(100);
	}

	@Override
	public void deleteContent(BigDecimal idFile) throws ServiceException {

	}
}