package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * The persistent class for the BEN_CONFIGURAZIONEDEMINIMIS database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="BEN_CONFIGURAZIONEDEMINIMIS")
public class BenConfigurazionedeminimis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(precision=4)
	private BigDecimal annofine;

	@Column(precision=4)
	private BigDecimal annoinizio;

	@Column(precision=2)
	private BigDecimal arcotemporale;

	@Id
	@Column(nullable=false)
	private BigDecimal idconfigurazione;

	@Column(length=4000)
	private String note;

}