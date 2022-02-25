package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Ente;

@Repository
public interface EnteDAO extends JpaRepository<Ente, Long> {
	public Ente findById(BigDecimal id);
}