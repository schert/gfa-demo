package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

import gov.mef.gfa.common.validator.ReferedRequiredValidation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EntePO {

	@NotNull(groups = ReferedRequiredValidation.class)
	@Null
	private BigDecimal idente;
	private String causale;
	private String codicefiscale;
	private Date datacessazione;
	@NotNull
	private Date datacostituzione;
	private Date datafusione;
	private String emailreferente;
	private String fusioni;
	private String motivazione;
	private String nominativoreferente;
	private String note;
	private String partitaiva;
	@NotNull
	private BigDecimal progressivoregione;
	@NotNull
	private String ragionesociale;
	private String settoreeconomico;
	private String siglaregione;
	private String slCap;
	private ComunePO slComune;
	private String slEmail;
	private String slFax;
	@NotNull
	private String slIndirizzo;
	private String slIndirizzoweb;
	private String slPec;
	private ProvinciaPO slProvincia;
	@NotNull
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
	@NotNull
	private BigDecimal stato;
	private String telefonoreferente;
	@NotNull
	private BigDecimal tipologia;
}
