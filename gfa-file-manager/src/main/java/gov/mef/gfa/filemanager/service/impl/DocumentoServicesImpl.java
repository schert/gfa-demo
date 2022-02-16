package gov.mef.gfa.filemanager.service.impl;

import java.math.BigDecimal;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import gov.mef.gfa.common.bean.filemanager.DocumentoPO;
import gov.mef.gfa.common.utils.MapperUtils;
import gov.mef.gfa.filemanager.dao.DocumentoDAO;
import gov.mef.gfa.filemanager.exception.FileException;
import gov.mef.gfa.filemanager.exception.ServiceException;
import gov.mef.gfa.filemanager.model.Documento;
import gov.mef.gfa.filemanager.service.DocumentaleService;
import gov.mef.gfa.filemanager.service.DocumentoService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DocumentoServicesImpl implements DocumentoService {

	@Autowired
	DocumentoDAO documentoRepository;
	@Autowired
	DocumentaleService documentaleService;

	@Override
	public DocumentoPO getDocumentoById(BigDecimal id) throws ServiceException {

		log.info("Service: {} Method: getDocumentoById", DocumentoServicesImpl.class);

		try {
			return MapperUtils.copyProperties(documentoRepository.getDocumentoByIdDocumento(id), DocumentoPO.class);
		} catch (Exception e) {
			throw new ServiceException("Errore nel recuperare le informazioni", e);
		}
	}

	@Override
	public void putDocumento(MultipartFile file, BigDecimal id) throws FileException {

		log.info("Service: {} Method: putDocumento", DocumentoServicesImpl.class);

		try {
			Documento documentoEntity = new Documento();
			documentoEntity.setContentFile(ArrayUtils.toObject(file.getBytes()));
			documentoEntity.setNomeFile(file.getOriginalFilename());
			documentoRepository.save(documentoEntity);
			// TODO
			BigDecimal idDocumentale = documentaleService.setDocEntrata(file.getBytes());

			try {
				documentoEntity.setIdDocumentale(idDocumentale);
				documentoRepository.save(documentoEntity);
			} catch (Exception e) {
				documentaleService.deleteContent(idDocumentale);
				throw new ServiceException("Errore nel aggiornare l'id documentale");
			}
		// TODO
		} catch (Exception e) {
			throw new FileException("Errore nello storicizzare i documento", e, file);
		}

	}

}
