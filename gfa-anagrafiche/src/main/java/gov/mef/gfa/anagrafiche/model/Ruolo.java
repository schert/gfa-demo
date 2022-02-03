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
 * The persistent class for the RUOLO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="RUOLO")
public class Ruolo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	private BigDecimal idruolo;
	
	@Column(nullable=false, length=100)
	private String descrizione;

}