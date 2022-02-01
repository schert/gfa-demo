package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * The persistent class for the BEN_DEMINIMIS database table.
 * 
 */

@Entity
@Data
@NoArgsConstructor
@Table(name = "BEN_DEMINIMIS")
public class BenDeminimis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	private BigDecimal iddeminimis;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idattivita", foreignKey=@ForeignKey(name = "Fk_benDeminimis_attivita"))	
	private Attivita attivita;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idbeneficiario", foreignKey=@ForeignKey(name = "Fk_ben_beneficiario"))
	private BenBeneficiario benBeneficiario;

	@Column(precision = 5)
	private BigDecimal duratafinanziamento;

	@Column(precision = 12, scale = 2)
	private BigDecimal importogarantito;

	@Column(precision = 12, scale = 2)
	private BigDecimal importorichiesto;

	@Column(precision = 12, scale = 2)
	private BigDecimal importorichiestonew;

	@Column(precision = 5, scale = 2)
	private BigDecimal percentualefinanziamento;

	@Column(length = 1)
	private String stato;

	@Column(nullable = false, precision = 2)
	private BigDecimal tiporichiesta;

}