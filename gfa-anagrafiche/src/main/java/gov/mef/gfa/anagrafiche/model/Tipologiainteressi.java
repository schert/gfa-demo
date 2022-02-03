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
 * The persistent class for the TIPOLOGIAINTERESSI database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="TIPOLOGIAINTERESSI")
public class Tipologiainteressi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal idtipologia;
	
	@Column(nullable=false, length=10)
	private String descrizione;
}