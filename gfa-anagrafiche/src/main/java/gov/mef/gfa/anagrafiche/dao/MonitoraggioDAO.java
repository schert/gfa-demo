package gov.mef.gfa.anagrafiche.dao;

import java.math.BigDecimal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Monitoraggio;

@Repository
public interface MonitoraggioDAO extends JpaRepository<Monitoraggio, Long> {
	public Monitoraggio findById(BigDecimal id);
	public Integer deleteById(BigDecimal id);
}
