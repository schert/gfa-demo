package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Convenzioni;

@Repository
public interface ConvenzioniDao extends JpaRepository<Convenzioni, Long> {
	public Convenzioni findByIdconvenzione(BigDecimal id);
}