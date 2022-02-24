package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import gov.mef.gfa.common.eum.TipoPersonaEnum;
import gov.mef.gfa.common.validator.IfValuesRequired;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@IfValuesRequired(selected = "tipopersona.idTipoPersona", values={TipoPersonaEnum.Constants.FISICA}, required = {"partitaIva","ragioneSociale"})
@IfValuesRequired(selected = "tipopersona.idTipoPersona", values={TipoPersonaEnum.Constants.GIURIDICA}, required = {"codiceFiscale","nominativo"})
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
	private Set<StoricoNumeroAddettiPO> storicoNumeroAddetti;
	private String partitaIva;
	@Valid
	private ProvinciaPO provincia;
	private String ragioneSociale;
	@Valid
	private RegionePO regione;
	@Valid
	private SettorePO settore;
	private String telefono;
	@Valid
	@NotNull
	private TipoPersonaPO tipoPersona;
	boolean flagCancellato;
}