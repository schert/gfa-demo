package gov.mef.gfa.anagrafiche;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import gov.mef.gfa.anagrafiche.dao.BenStoricoDao;
import gov.mef.gfa.anagrafiche.model.BenStoricoSettore;

@SpringBootTest(classes = GfaAnagraficheApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GfaBeApplicationTests {
	
	@Autowired
	BenStoricoDao benStoricoDao;

	@Test
	public void testGetAllUsers() {
		BenStoricoSettore storico = new BenStoricoSettore();
		storico.setIdbeneficiario(new BigDecimal(1));
		storico.setIdsettore("1");
		storico.setAnnocompetenzada(new BigDecimal(2022));
		storico.setAnnocompetenzaa(new BigDecimal(2023));
		
		benStoricoDao.save(storico);
		benStoricoDao.findAll();
		benStoricoDao.delete(storico);
	}
}
