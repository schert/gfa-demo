package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
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
public class Interessi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
    private InteressiPK convenzioniPK;
	
	@Column(precision=12, scale=2)
	private BigDecimal capitaleinvestito;

//	@Column(nullable=false, precision=38)
//	private BigDecimal idattivita;

//	@Column(nullable=false, precision=38)
//	private BigDecimal idtipologia;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal importo;

	@Column(nullable=false, precision=1)
	private BigDecimal modificato;

	@Column(length=100)
	private String note;
}