package gov.mef.gfa.anagrafiche.service;

import java.math.BigDecimal;

import gov.mef.gfa.anagrafiche.exception.ServiceException;
import gov.mef.gfa.common.bean.anagrafica.RichiestaFinanziamentoPO;

public interface RichiestaFinanziamentoService {
    public RichiestaFinanziamentoPO getRichiestaFinanziamentoById(BigDecimal id) throws ServiceException;
    public RichiestaFinanziamentoPO putRichiestaFinanziamento(RichiestaFinanziamentoPO richiestaFinanziamento, BigDecimal id) throws ServiceException;
	public Integer deleteRichiestaFinanziamento(BigDecimal id) throws ServiceException ;
}
