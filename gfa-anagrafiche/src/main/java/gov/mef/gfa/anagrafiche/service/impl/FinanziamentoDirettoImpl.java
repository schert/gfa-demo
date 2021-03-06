package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.dao.FinanziamentoDirettoDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.model.FinanziamentoDiretto;
import gov.mef.gfa.anagrafiche.service.FinanziamentoDirettoService;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoPO;
import gov.mef.gfa.common.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FinanziamentoDirettoImpl implements FinanziamentoDirettoService {

	@Autowired
	FinanziamentoDirettoDAO finanziamentoRepository;

	@Override
	public FinanziamentoDirettoPO getFinanziamentoDirettoById(BigDecimal id) throws ServiceException {

		log.info("Controller: {} Method: getFinanziamentoDirettoById", FinanziamentoDirettoImpl.class);

		try {
			return MapperUtils.copyProperties(finanziamentoRepository.findById(id), FinanziamentoDirettoPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nel recuperare le informazioni", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public FinanziamentoDirettoPO putFinanziamento(FinanziamentoDirettoPO finanziamento, BigDecimal id)
			throws ServiceException {
		log.info("Service: {} Method: putFinanziamento", FinanziamentoDirettoImpl.class);

		try {
			FinanziamentoDiretto finanziamentoEntity = MapperUtils.copyProperties(finanziamento,
					FinanziamentoDiretto.class);
			finanziamentoEntity.setId(id);
			return MapperUtils.copyProperties(finanziamentoRepository.save(finanziamentoEntity),
					FinanziamentoDirettoPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la put", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public Integer deleteFinanziamento(BigDecimal id) throws ServiceException {

		log.info("Service: {} Method: deleteFinanziamento", FinanziamentoDirettoImpl.class);

		try {
			return finanziamentoRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la delete", e);
		}
	}

}
