package gov.mef.gfa.filemanager.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import gov.mef.gfa.common.bean.filemanager.DocumentoPO;
import gov.mef.gfa.filemanager.exception.FileException;
import gov.mef.gfa.filemanager.exception.ServiceException;

public interface DocumentoService {
    public DocumentoPO getDocumentoById(BigDecimal id) throws ServiceException;
    public void putDocumento(MultipartFile beneficiario, BigDecimal id) throws FileException;
}
