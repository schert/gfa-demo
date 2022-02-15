package gov.mef.gfa.filemanager.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.filemanager.model.Documento;

@Repository
public interface DocumentoDAO extends JpaRepository<Documento, Long> {
	public Documento getDocumentoByIdDocumento(BigDecimal id);

}
