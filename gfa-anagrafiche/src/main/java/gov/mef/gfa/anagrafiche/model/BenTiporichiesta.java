package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the BEN_TIPORICHIESTA database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="BEN_TIPORICHIESTA")
public class BenTiporichiesta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, precision=2)
	private BigDecimal idtiporichiesta;
	
	@Column(nullable=false, length=50)
	private String descrizione;

}