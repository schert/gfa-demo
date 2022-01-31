package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * The persistent class for the CONVENZIONI database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="CONVENZIONI")
public class Convenzioni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal idconvenzione;
	
	@Column(nullable=false, precision=38)
	private BigDecimal idattivita;

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