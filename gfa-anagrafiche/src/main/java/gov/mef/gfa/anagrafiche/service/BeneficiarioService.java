package gov.mef.gfa.anagrafiche.service;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioRes;
import reactor.core.publisher.Mono;

public interface BeneficiarioService {
	public Mono<BeneficiarioRes> getBeneficiarioById(long id) throws ServiceException;
}
