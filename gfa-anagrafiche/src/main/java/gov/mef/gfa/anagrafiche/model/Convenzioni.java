package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
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
 * The persistent class for the CONVENZIONI database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CONVENZIONI")
@SequenceGenerator(name = "seqid-gen", sequenceName = "CONVENZIONI_SEQ")
public class Convenzioni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen")
	@Column(nullable=false, precision=38)
	private BigDecimal idconvenzione;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idattivita", foreignKey=@ForeignKey(name = "Fk_convenzioni_attivita"))	
	private Attivita attivita;

	@Column(length=300)
	private String indirizzo;

	@Column(precision=12, scale=2)
	private BigDecimal maxfinerogabile;

	@Column(nullable=false, precision=1)
	private BigDecimal modificato;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal moltiplicatore;

	@Column(nullable=false, length=300)
	private String nomeistituto;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal somma;

}