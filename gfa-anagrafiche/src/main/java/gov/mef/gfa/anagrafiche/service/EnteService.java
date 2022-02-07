package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.EnteRes;
import reactor.core.publisher.Mono;

public interface EnteService {
	public Mono<EnteRes> getEnteById(BigDecimal id) throws ServiceException;
}
