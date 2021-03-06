package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.RichiestaFinanziamento;

@Repository
public interface RichiestaFinanziamentoDAO extends JpaRepository<RichiestaFinanziamento, Long> {
	public RichiestaFinanziamento findById(BigDecimal id);
	public Integer deleteById(BigDecimal id);
}