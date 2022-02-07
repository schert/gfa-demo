package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Interessi;

@Repository
public interface InteressiDAO extends JpaRepository<Interessi, Long> {
	public Interessi findById(BigDecimal id);
}