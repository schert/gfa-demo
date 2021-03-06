package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
	
	@ManyToOne
    @JoinColumn(name = "idsettore", foreignKey=@ForeignKey(name = "Fk_ben_str_set_settore"))
	private BenSettore settore;
	
	@Column(precision=4)
	private BigDecimal annocompetenzada;

	@Column(precision=4)
	private BigDecimal annocompetenzaa;
	
}
