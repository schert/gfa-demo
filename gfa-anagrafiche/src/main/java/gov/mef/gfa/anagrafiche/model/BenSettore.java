package gov.mef.gfa.anagrafiche.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name="BEN_SETTORE")
public class BenSettore {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable=false)
	private BigDecimal idsettore;
	
	@Column(length=4000)
	private String descrizione;

}
