package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the RICHIESTAFINANZIAMENTO database table.
 * 
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "RICHIESTA_FINANZIAMENTO")
@SequenceGenerator(name = "seqid-gen-richiesta-finanziamento", sequenceName = "RICHIESTA_FINANZIAMENTO_SEQ", allocationSize = 1)
public class RichiestaFinanziamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen-richiesta-finanziamento")
	@Column(nullable = false)
	private BigDecimal idRichiestaFinanziamento;

	@Column(name = "ANNO_COMPETENZA", precision = 4)
	private BigDecimal annoCompetenza;

	@Column(name = "ANNO_GESTIONE", nullable = false, precision = 4)
	private BigDecimal annoGestione;

	@Column(name = "CASUALE", length = 1000)
	private String causale;

	@Column(name = "DATA_CREAZIONE", nullable = false)
	private Date dataCreazione;

	@Column(name = "DATA_ELIMINAZIONE")
	private Date dataEliminazione;

	@Column(name = "DATA_PRESENTAZIONE", nullable = false)
	private Date dataPresentazione;

	@Column(name = "DOCUMENTAZIONE_OBBLIGATORIA", nullable = false)
	private boolean documentazioneObbligatoria; // bigdecimal

	@Column(name = "IBAN", length = 27)
	private String iban;

	@Column(name = "IMPORTO_RICHIESTO", precision = 12, scale = 2)
	private BigDecimal importoRichiesto;

	@Column(name = "INDIRIZZO_FILIALE", length = 100)
	private String indirizzoFiliale;

	@Column(name = "NOME_BANCA", length = 100)
	private String nomeBanca;

	@Column(name = "NOME_FILIALE", length = 30)
	private String nomeFiliale;

	@Column(name = "NOTE", length = 4000)
	private String note;	

	@ManyToOne
	@JoinColumn(name = "ID_AMBITO", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_ambito"))
	private Ambito ambito;

	@ManyToOne
	@JoinColumn(name = "ID_ENTE", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_ente"))
	private Ente ente;	
	
	@ManyToOne
	@JoinColumn(name = "ID_STATO_RICHIESTA_FINANZIAMENTO", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_stato"))
	private StatoRichiestaFinanziamento statoRichiestaFinanziamento;

	@ManyToOne
	@JoinColumn(name = "ID_STATO_ENTE", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_stato_ente"))
	private StatoEnte statoEnte;
	
	@Column(name = "FLAG_CANCELLATO", nullable = false)
	private boolean flagCancellato;

}