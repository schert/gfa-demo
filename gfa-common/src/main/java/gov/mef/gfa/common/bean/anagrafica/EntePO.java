package gov.mef.gfa.common.bean.anagrafica;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;

@Data
public class EntePO  implements Serializable {

	private static final long serialVersionUID = 1L;
	private BigDecimal idente;
	private String causale;
	private String codicefiscale;
	private Date datacessazione;
	private Date datacostituzione;
	private Date datafusione;
	private String emailreferente;
	private String fusioni;
	private String motivazione;
	private String nominativoreferente;
	private String note;
	private String partitaiva;
	private BigDecimal progressivoregione;
	private String ragionesociale;
	private String settoreeconomico;
	private String siglaregione;
	private String slCap;
	private ComunePO slComune;
	private String slEmail;
	private String slFax;
	private String slIndirizzo;
	private String slIndirizzoweb;
	private String slPec;
	private ProvinciaPO slProvincia;
	private String slTelefono1;
	private String slTelefono2;
	private String slTelefono3;
	private String soCap;
	private ComunePO soComune;
	private String soIndirizzo;
	private ProvinciaPO soProvincia;
	private String soTelefono1;
	private String soTelefono2;
	private String soTelefono3;
	private BigDecimal stato;
	private String telefonoreferente;
	private BigDecimal tipologia;
}
