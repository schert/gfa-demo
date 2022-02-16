package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import gov.mef.gfa.common.validator.ifNotEmptyRequired;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@ifNotEmptyRequired(isNotEmpty = "partitaIva", required = {"ragioneSociale"})
@ifNotEmptyRequired(isNotEmpty = "codiceFiscale", required = {"codiceFiscale","nominativo"})
public class BeneficiarioPO {
	private BigDecimal id;
	@NotEmpty
	@Size(min = 22)
	private String codiceAteco;
	@Size(min = 11, max = 11)
	private String codiceFiscale;
	@Valid
	private ComunePO comune;
	private String email;
	private String fax;
	private String indirizzo;
	private String nominativo;
	private String note;
	private BigDecimal numeroAddetti;
	private String partitaIva;
	@Valid
	private ProvinciaPO provincia;
	private String ragioneSociale;
	@Valid
	private RegionePO regione;
	private SettorePO settore;
	private String telefono;
	boolean flagCancellatoSn;

}