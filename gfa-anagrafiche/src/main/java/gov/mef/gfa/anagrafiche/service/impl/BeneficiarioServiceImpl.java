package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.controller.BeneficiarioController;
import gov.mef.gfa.anagrafiche.dao.BeneficiarioDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.model.BenBeneficiario;
import gov.mef.gfa.anagrafiche.service.BeneficiarioService;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioPO;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioRes;
import gov.mef.gfa.common.bean.common.StatusRes;
import gov.mef.gfa.common.utils.MapperUtils;
import reactor.core.publisher.Mono;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

	@Autowired
	BeneficiarioDAO beneficiarioRepository;

	private Logger logger = LoggerFactory.getLogger(BeneficiarioServiceImpl.class);

	@Override
	public Mono<BeneficiarioRes> getBeneficiarioById(BigDecimal id) throws ServiceException {

		logger.info("Controller: {} Method: getBeneficiarioById", BeneficiarioController.class);

		try {
			BeneficiarioRes beneficiarioRes = new BeneficiarioRes();
			BeneficiarioPO beneficiarioPO = MapperUtils.copyProperties(beneficiarioRepository.findById(id),
					BeneficiarioPO.class);

			if (beneficiarioPO == null)
				return Mono.empty();

			beneficiarioRes.setStatus(StatusRes.success());
			beneficiarioRes.setBeneficiario(beneficiarioPO);

			return Mono.just(beneficiarioRes);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}

	@Override
	@Transactional(rollbackOn=ServiceException.class)
	public Mono<BeneficiarioRes> putBeneficiario(BeneficiarioPO beneficiario, BigDecimal id) throws ServiceException {
		try {
			BeneficiarioRes beneficiarioRes = new BeneficiarioRes();
			BenBeneficiario beneficiarioEntity = MapperUtils.copyProperties(beneficiario, BenBeneficiario.class);

			beneficiarioEntity.setId(id);
			beneficiarioRes.setBeneficiario(
					MapperUtils.copyProperties(beneficiarioRepository.save(beneficiarioEntity), BeneficiarioPO.class));
			beneficiarioRes.setStatus(StatusRes.success());
			return Mono.just(beneficiarioRes);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
	
	@Override
	@Transactional(rollbackOn=ServiceException.class)
	public Mono<BeneficiarioRes> deleteBeneficiario(BigDecimal id) throws ServiceException {
		try {
			BeneficiarioRes beneficiarioRes = new BeneficiarioRes();
			beneficiarioRepository.deleteById(id);
			beneficiarioRes.setStatus(StatusRes.success());
			
			return Mono.just(beneficiarioRes);
		} catch (Exception e) {
			throw new ServiceException(e);
		}
	}
}
