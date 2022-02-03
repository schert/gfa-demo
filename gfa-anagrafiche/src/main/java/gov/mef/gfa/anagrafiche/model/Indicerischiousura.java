package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the INDICERISCHIOUSURA database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="INDICERISCHIOUSURA")
public class Indicerischiousura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@JoinColumn(name = "codprovincia", foreignKey=@ForeignKey(name = "Fk_ind_risc_usura_provincia"), nullable = false)
	private Provincia provincia;
	
	@Column(nullable=false, length=1)
	private String classerischio;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal valore;

}