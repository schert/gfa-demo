package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RichiestaFinanziamentoPO {

	private BigDecimal idRichiestaFinanziamento;
	private BigDecimal annoCompetenza;
	private BigDecimal annoGestione;
	private String causale;
	private Timestamp dataCreazione;
	private Timestamp dataEliminazione;
	private Timestamp dataPresentazione;
	private boolean documentazioneObbligatoria;
	private String iban;
	private BigDecimal importoRichiesto;
	private String indirizzoFiliale;
	private String nomeBanca;
	private String nomeFiliale;
	private String note;
	// private AmbitoPO ambitoPO;
	private EntePO entePO;
	/*
	 * private StatoRichiestaFinanziamentoPO statoRichiestaFinanziamentoPO; private
	 * StatoEntePO statoEntePO;
	 */
	private boolean flagCancellatoSN;

}
