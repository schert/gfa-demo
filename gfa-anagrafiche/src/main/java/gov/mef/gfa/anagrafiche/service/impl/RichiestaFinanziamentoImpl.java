package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.dao.RichiestaFinanziamentoDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.model.RichiestaFinanziamento;
import gov.mef.gfa.anagrafiche.service.RichiestaFinanziamentoService;
import gov.mef.gfa.common.bean.anagrafica.RichiestaFinanziamentoPO;
import gov.mef.gfa.common.utils.MapperUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RichiestaFinanziamentoImpl implements RichiestaFinanziamentoService {

	@Autowired
	RichiestaFinanziamentoDAO richiestaFinanziamentoRepository;

	@Override
	public RichiestaFinanziamentoPO getRichiestaFinanziamentoById(BigDecimal id) throws ServiceException {

		log.info("Controller: {} Method: getRichiestaFinanziamentoById", RichiestaFinanziamentoImpl.class);

		try {
			return MapperUtils.copyProperties(richiestaFinanziamentoRepository.findById(id),
					RichiestaFinanziamentoPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nel recuperare le informazioni", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public RichiestaFinanziamentoPO putRichiestaFinanziamento(RichiestaFinanziamentoPO richiestaFinanziamento,
			BigDecimal id) throws ServiceException {
		log.info("Service: {} Method: putFinanziamento", RichiestaFinanziamentoImpl.class);

		try {
			RichiestaFinanziamento richiestaFinanziamentoEntity = MapperUtils.copyProperties(richiestaFinanziamento,
					RichiestaFinanziamento.class);
			richiestaFinanziamentoEntity.setId(id);
			return MapperUtils.copyProperties(richiestaFinanziamentoRepository.save(richiestaFinanziamentoEntity),
					RichiestaFinanziamentoPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la put", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public Integer deleteRichiestaFinanziamento(BigDecimal id) throws ServiceException {

		log.info("Service: {} Method: deleteRichiestaFinanziamento", RichiestaFinanziamentoImpl.class);
		try {
			return richiestaFinanziamentoRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la delete", e);
		}
	}

}
