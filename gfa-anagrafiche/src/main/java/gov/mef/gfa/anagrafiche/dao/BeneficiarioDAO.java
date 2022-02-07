package gov.mef.gfa.anagrafiche.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.BenBeneficiario;

@Repository
public interface BeneficiarioDAO extends JpaRepository<BenBeneficiario, Long> {
	public BenBeneficiario findByIdBeneficiario(long id);
}