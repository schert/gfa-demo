package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

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
	private BigDecimal id;

	@Column(precision = 4)
	private BigDecimal annoCompetenza;

	@Column(nullable = false, precision = 4)
	private BigDecimal annoGestione;

	@Column(length = 1000)
	private String causale;

	@Column(nullable = false)
	private Date dataCreazione;

	private Date dataEliminazione;

	@Column(nullable = false)
	private Date dataPresentazione;

	@Column(nullable = false)
	private boolean documentazioneObbligatoria;

	@Column(length = 27)
	private String iban;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoRichiesto;

	@Column(length = 100)
	private String indirizzoFiliale;

	@Column(length = 100)
	private String nomeBanca;

	@Column(length = 30)
	private String nomeFiliale;

	@Column(length = 4000)
	private String note;

	@ManyToOne
	@JoinColumn(name = "ID_AMBITO", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_ambito"), nullable = false)
	private Ambito ambito;

	@ManyToOne
	@JoinColumn(name = "ID_ENTE", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_ente"), nullable = false)
	private Ente ente;

	@ManyToOne
	@JoinColumn(name = "ID_STATO_RICHIESTA_FINANZIAMENTO", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_stato"), nullable = false)
	private StatoRichiestaFinanziamento statoRichiestaFinanziamento;

	@ManyToOne
	@JoinColumn(name = "ID_STATO_ENTE", foreignKey = @ForeignKey(name = "Fk_richiesta_finanziamento_stato_ente"), nullable = false)
	private StatoEnte statoEnte;

	@Column(name = "FLAG_CANCELLATO", nullable = false)
	private boolean flagCancellato;

}
