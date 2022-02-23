package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.groups.ConvertGroup;
import javax.validation.groups.Default;

import gov.mef.gfa.common.validator.ReferedRequiredValidation;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RichiestaFinanziamentoPO {

	private BigDecimal idRichiestaFinanziamento;
	private BigDecimal annoCompetenza;
	@NotNull
	private BigDecimal annoGestione;
	private String causale;
	@NotNull
	private Timestamp dataCreazione;
	private Timestamp dataEliminazione;
	@NotNull
	private Timestamp dataPresentazione;
	@NotNull
	private Boolean documentazioneObbligatoria;
	private String iban;
	private BigDecimal importoRichiesto;
	private String indirizzoFiliale;
	private String nomeBanca;
	private String nomeFiliale;
	private String note;
	@Valid
	@NotNull
	@ConvertGroup(from=Default.class, to=ReferedRequiredValidation.class)
	private AmbitoPO ambito;
	@Valid
	@NotNull
	@ConvertGroup(from=Default.class, to=ReferedRequiredValidation.class)
	private EntePO ente;
	private StatoRichiestaFinanziamentoPO statoRichiestaFinanziamento;
	private StatoEntePO statoEnte;
	private boolean flagCancellato;

}
