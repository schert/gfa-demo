package gov.mef.gfa.anagrafiche.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gov.mef.gfa.anagrafiche.model.Interessi;
import gov.mef.gfa.anagrafiche.model.InteressiPK;

@Repository
public interface InteressiDao extends JpaRepository<Interessi, Long> {
	public Interessi findByInteressiPK(InteressiPK id);
}