package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.MonitoraggioPO;

public interface MonitoraggioService {
	    public MonitoraggioPO getMonitoraggioById(BigDecimal id) throws ServiceException;
	    public MonitoraggioPO putMonitoraggio(MonitoraggioPO monitoraggio, BigDecimal id) throws ServiceException;
		public Integer deleteMonitoraggio(BigDecimal id) throws ServiceException ;
	}
