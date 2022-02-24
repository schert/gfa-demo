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
 * The persistent class for the AMBITO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="AMBITO")
public class Ambito implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal id;

	@Column(nullable=false, length=20)
	private String descrizione;

}