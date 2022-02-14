package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.FinanziamentoDiretto;

@Repository
public interface FinanziamentoDirettoDAO extends JpaRepository<FinanziamentoDiretto, Long> {
	public FinanziamentoDiretto findById(BigDecimal id);
	public Integer deleteById(BigDecimal id);
}