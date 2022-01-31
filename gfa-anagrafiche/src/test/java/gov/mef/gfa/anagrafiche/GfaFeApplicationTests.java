package gov.mef.gfa.anagrafiche;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import gov.mef.gfa.anagrafiche.dao.BenBeneficiarioDao;
import gov.mef.gfa.anagrafiche.dao.ConvenzioniDao;
import gov.mef.gfa.anagrafiche.dao.InteressiDao;
import gov.mef.gfa.anagrafiche.model.BenBeneficiario;
import gov.mef.gfa.anagrafiche.model.Convenzioni;
import gov.mef.gfa.anagrafiche.model.Interessi;
import gov.mef.gfa.anagrafiche.model.InteressiPK;

@SpringBootTest(classes = GfaAnagraficheApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class GfaBeApplicationTests {

	@Autowired
	ConvenzioniDao convenzioniDao;
	@Autowired
	InteressiDao interessiDao;
	@Autowired
	BenBeneficiarioDao benBeneficiarioDao;

	@Test
	public void testConvenzioni() {
		try {
			Convenzioni con = new Convenzioni();
			con.setIdattivita(new BigDecimal(1));
			con.setIndirizzo("indirizzo");
			con.setMaxfinerogabile(new BigDecimal(2));
			con.setModificato(new BigDecimal(3));
			con.setMoltiplicatore(new BigDecimal(4));
			con.setNomeistituto("nome istituto");
			con.setSomma(new BigDecimal(5));

			Convenzioni convenzioni = convenzioniDao.save(con);

			convenzioni = convenzioniDao.findByIdconvenzione(convenzioni.getIdconvenzione());

			Assert.isTrue(convenzioni != null, "Nessuna convenzione creata");

			convenzioniDao.delete(con);

			convenzioni = convenzioniDao.findByIdconvenzione(convenzioni.getIdconvenzione());

			Assert.isTrue(convenzioni == null, "Convezione non canellata");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void testInteressi() {
		try {
			Interessi inter = new Interessi();
			inter.setCapitaleinvestito(new BigDecimal(10));
			inter.setImporto(new BigDecimal(50));
			InteressiPK id = new InteressiPK(new BigDecimal(1), new BigDecimal(2));
			inter.setInteressiPK(id);
			inter.setModificato(new BigDecimal(1));
			inter.setNote("note");

			Interessi interesse = interessiDao.save(inter);

			interesse = interessiDao.findByInteressiPK(id);

			Assert.isTrue(interesse != null, "Nessun interesse creato");

			interessiDao.delete(inter);

			interesse = interessiDao.findByInteressiPK(id);

			Assert.isTrue(interesse == null, "Interesse non canellato");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Test
	public void testBenBeneficiario() {
		try {
			BenBeneficiario benbene = new BenBeneficiario();
			benbene.setCodicefiscale("codice fiscale");
			benbene.setEmail("email");
			benbene.setPartitaiva("partitaiva");

			BenBeneficiario benBeneficiario = benBeneficiarioDao.save(benbene);

			benBeneficiario = benBeneficiarioDao.findByIdbeneficiario(benBeneficiario.getIdbeneficiario());

			Assert.isTrue(benBeneficiario != null, "Nessun benBeneficiario creato");

			benBeneficiarioDao.delete(benbene);

			benBeneficiario = benBeneficiarioDao.findByIdbeneficiario(benBeneficiario.getIdbeneficiario());

			Assert.isTrue(benBeneficiario == null, "BenBeneficiario non canellato");

		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
