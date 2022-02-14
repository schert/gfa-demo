package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.FinanziamentoDirettoPO;

public interface FinanziamentoDirettoService {
    public FinanziamentoDirettoPO getFinanziamentoDirettoById(BigDecimal id) throws ServiceException;
    public FinanziamentoDirettoPO putFinanziamento(FinanziamentoDirettoPO finanziamento, BigDecimal id) throws ServiceException;
	public Integer deleteFinanziamento(BigDecimal id) throws ServiceException ;
}
