package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.dao.MonitoraggioDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.model.Monitoraggio;
import gov.mef.gfa.anagrafiche.service.MonitoraggioService;
import gov.mef.gfa.common.bean.anagrafica.MonitoraggioPO;
import gov.mef.gfa.common.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MonitoraggioImpl implements MonitoraggioService {

	@Autowired
	MonitoraggioDAO monitoraggioRepository;

	@Override
	public MonitoraggioPO getMonitoraggioById(BigDecimal id) throws ServiceException {

		log.info("Controller: {} Method: getMonitoraggioById", MonitoraggioImpl.class);

		try {
			return MapperUtils.copyProperties(monitoraggioRepository.findById(id), MonitoraggioPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nel recuperare le informazioni", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public MonitoraggioPO putMonitoraggio(MonitoraggioPO monitoraggio, BigDecimal id)
			throws ServiceException {
		log.info("Service: {} Method: putMonitoraggio", MonitoraggioImpl.class);

		try {
			Monitoraggio monitoraggioEntity = MapperUtils.copyProperties(monitoraggio,
					Monitoraggio.class);
			monitoraggioEntity.setId(id);
			return MapperUtils.copyProperties(monitoraggioRepository.save(monitoraggioEntity),
					MonitoraggioPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la put", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public Integer deleteMonitoraggio(BigDecimal id) throws ServiceException {

		log.info("Service: {} Method: deleteMonitoraggio", MonitoraggioImpl.class);

		try {
			return monitoraggioRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la delete", e);
		}
	}

}
