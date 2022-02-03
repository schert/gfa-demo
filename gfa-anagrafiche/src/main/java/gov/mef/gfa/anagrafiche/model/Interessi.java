package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

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
 * The persistent class for the INTERESSI database table.
 * 
 */
@Entity
@Table(name="INTERESSI")
@Data
@NoArgsConstructor
@SequenceGenerator(name = "seqid-gen-interessi", sequenceName = "INTERESSI_SEQ")
public class Interessi implements Serializable {
	private static final long serialVersionUID = 1L;

//	@EmbeddedId
//  private InteressiPK interessiPK;
	
	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen-interessi")
	private BigDecimal id;
	
	@Column(precision=12, scale=2)
	private BigDecimal capitaleinvestito;
	
	@ManyToOne
	@JoinColumn(name = "idattivita", foreignKey = @ForeignKey(name = "Fk_interessi_attivita"))
	private Attivita attivita;

	@ManyToOne
	@JoinColumn(name = "idtipologia", foreignKey=@ForeignKey(name = "Fk_interessi_tip_interessi"), nullable = false)
	private Tipologiainteressi tipologiaInteressi;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal importo;

	@Column(nullable=false, precision=1)
	private BigDecimal modificato;

	@Column(length=100)
	private String note;
}