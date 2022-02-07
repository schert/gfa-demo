package gov.mef.gfa.anagrafiche.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.controller.BeneficiarioController;
import gov.mef.gfa.anagrafiche.dao.BeneficiarioDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.service.BeneficiarioService;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioPO;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioRes;
import gov.mef.gfa.common.bean.common.StatusRes;
import gov.mef.gfa.common.utils.MapperUtils;
import reactor.core.publisher.Mono;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {
	
	@Autowired
	BeneficiarioDAO beneficairioRepository;	
	
	private Logger logger = LoggerFactory.getLogger(BeneficiarioServiceImpl.class);
	
	public Mono<BeneficiarioRes> getBeneficiarioById(long id) throws ServiceException {
		
		logger.info("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);
		
		try {			
			BeneficiarioRes enteRes = new BeneficiarioRes();			
			BeneficiarioPO entePO = MapperUtils.copyProperties(beneficairioRepository.findByIdBeneficiario(id), BeneficiarioPO.class);			
			
			if(entePO == null)
				return null;
			
			enteRes.setStatus(StatusRes.success());
			enteRes.setBeneficiario(entePO);
			
			return Mono.just(enteRes);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}
