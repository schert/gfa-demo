package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.BeneficiarioPO;

public interface BeneficiarioService {
	public BeneficiarioPO getBeneficiarioById(BigDecimal id) throws ServiceException;
	public BeneficiarioPO putBeneficiario(BeneficiarioPO beneficiario, BigDecimal id) throws ServiceException;
	public Integer deleteBeneficiario(BigDecimal id) throws ServiceException ;
}
