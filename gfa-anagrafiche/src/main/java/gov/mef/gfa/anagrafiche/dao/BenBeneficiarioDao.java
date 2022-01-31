package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.BenBeneficiario;

@Repository
public interface BenBeneficiarioDao extends JpaRepository<BenBeneficiario, Long> {
	public BenBeneficiario findByIdbeneficiario(BigDecimal id);
}