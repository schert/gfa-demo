package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.controller.FinanziamentoDirettoController;
import gov.mef.gfa.anagrafiche.dao.FinanziamentoDirettoDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.FinanziamentoDirettoService;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoPO;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoRes;
import gov.mef.gfa.common.bean.common.StatusRes;
import gov.mef.gfa.common.utils.MapperUtils;
import reactor.core.publisher.Mono;

@Service
public class FinanziamentoDirettoImpl implements FinanziamentoDirettoService {

	@Autowired
	FinanziamentoDirettoDAO finanziamentoRepository;

	private Logger logger = LoggerFactory.getLogger(FinanziamentoDirettoImpl.class);

	public Mono<FinanziamentoDirettoRes> getFinanziamentoDirettoById(BigDecimal id) throws ServiceException {

		logger.info("Controller: {} Method: getFinanziamentoDirettoById", FinanziamentoDirettoController.class);

		try {
			FinanziamentoDirettoRes finanziamentoRes = new FinanziamentoDirettoRes();
			FinanziamentoDirettoPO finanziamentoPO = MapperUtils.copyProperties(finanziamentoRepository.findById(id),
					FinanziamentoDirettoPO.class);

			if (finanziamentoPO == null) {
				return Mono.empty();
			}

			finanziamentoRes.setStatus(StatusRes.success());
			finanziamentoRes.setFinanziamento(finanziamentoPO);

			return Mono.just(finanziamentoRes);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

}
