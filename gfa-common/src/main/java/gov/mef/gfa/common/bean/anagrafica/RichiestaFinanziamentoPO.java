package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.sql.Timestamp;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import gov.mef.gfa.common.validator.onPostValidation;
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
	@NotNull (groups =  onPostValidation.class)
	private Boolean documentazioneObbligatoria;
	private String iban;
	private BigDecimal importoRichiesto;
	private String indirizzoFiliale;
	private String nomeBanca;
	private String nomeFiliale;
	private String note;
	@Valid
	@NotNull
	private AmbitoPO ambito;
	@Valid
	@NotNull
	private EntePO ente;
	@Valid
	@NotNull
	private StatoRichiestaFinanziamentoPO statoRichiestaFinanziamento;
	@Valid
	@NotNull
	private StatoEntePO statoEnte;
	@NotNull
	private boolean flagCancellatoSN;

}
