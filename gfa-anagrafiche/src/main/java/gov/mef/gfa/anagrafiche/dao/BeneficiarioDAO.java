package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Beneficiario;

@Repository
public interface BeneficiarioDAO extends JpaRepository<Beneficiario, Long> {
	public Beneficiario findById(BigDecimal id);
	public Integer deleteById(BigDecimal id);
}