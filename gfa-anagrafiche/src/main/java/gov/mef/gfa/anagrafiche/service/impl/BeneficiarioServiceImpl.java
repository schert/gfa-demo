package gov.mef.gfa.anagrafiche.service.impl;

import java.math.BigDecimal;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gov.mef.gfa.anagrafiche.dao.BeneficiarioDAO;
import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.anagrafiche.model.Beneficiario;
import gov.mef.gfa.anagrafiche.service.BeneficiarioService;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioPO;
import gov.mef.gfa.common.utils.MapperUtils;

@Service
public class BeneficiarioServiceImpl implements BeneficiarioService {

	@Autowired
	BeneficiarioDAO beneficiarioRepository;

	private Logger logger = LoggerFactory.getLogger(BeneficiarioServiceImpl.class);

	@Override
	public BeneficiarioPO getBeneficiarioById(BigDecimal id) throws ServiceException {

		logger.info("Service: {} Method: getBeneficiarioById", BeneficiarioServiceImpl.class);

		try {
			return MapperUtils.copyProperties(beneficiarioRepository.findById(id), BeneficiarioPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nel recuperare le informazioni", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public BeneficiarioPO putBeneficiario(BeneficiarioPO beneficiario, BigDecimal id) throws ServiceException {
		
		logger.info("Service: {} Method: putBeneficiario", BeneficiarioServiceImpl.class);
		
		try {
			Beneficiario beneficiarioEntity = MapperUtils.copyProperties(beneficiario, Beneficiario.class);
			beneficiarioEntity.setId(id);
			return MapperUtils.copyProperties(beneficiarioRepository.save(beneficiarioEntity), BeneficiarioPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la put", e);
		}
	}

	@Override
	@Transactional(rollbackOn = ServiceException.class)
	public Integer deleteBeneficiario(BigDecimal id) throws ServiceException {
		
		logger.info("Service: {} Method: deleteBeneficiario", BeneficiarioServiceImpl.class);
		
		try {
			return beneficiarioRepository.deleteById(id);
		} catch (Exception e) {
			throw new ServiceException("Errore nell'effettuare la delete", e);
		}
	}
}
