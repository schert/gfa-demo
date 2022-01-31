package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
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
@Table(name="BEN_STORICOSETTORE")
public class BenStoricoSettore implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(nullable=false)
	private BigDecimal idbeneficiario;
	
	@Column(length=20)
	private String idsettore;
	
	@Column(precision=4)
	private BigDecimal annocompetenzada;

	@Column(nullable=false, precision=4)
	private BigDecimal annocompetenzaa;
	
}
