package gov.mef.gfa.anagrafiche.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Ente;

@Repository
public interface EnteDao extends JpaRepository<Ente, Long> {
	public Ente findByIdente(Integer id);
}