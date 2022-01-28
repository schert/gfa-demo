package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * The persistent class for the BEN_LIMITEAIUTO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="BEN_LIMITEAIUTO")
public class BenLimiteaiuto implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idconfigurazione")
	private BenConfigurazionedeminimis benConfigurazionedeminimis;
	
	@Id
	@Column(nullable=false)
	private BigDecimal idlimiteaiuto;

	@Column(nullable=false)
	private BigDecimal idsettore;

	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idtipoaiuto")
	private BenTipoaiuto benTipoaiuto;

	@Column(nullable=false, precision=10, scale=2)
	private BigDecimal limite;

}