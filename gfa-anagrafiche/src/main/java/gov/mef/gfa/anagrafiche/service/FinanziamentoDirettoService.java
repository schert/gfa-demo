package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoRes;
import reactor.core.publisher.Mono;

public interface FinanziamentoDirettoService {
    public Mono<FinanziamentoDirettoRes> getFinanziamentoDirettoById(BigDecimal id) throws ServiceException;
}
