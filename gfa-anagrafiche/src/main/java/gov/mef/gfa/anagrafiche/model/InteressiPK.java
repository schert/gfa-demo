package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class InteressiPK implements Serializable {
	private static final long serialVersionUID = 9210508979742918158L;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idattivita", foreignKey=@ForeignKey(name = "Fk_interessi_attivita"))	
	private Attivita attivita;
	
	@Column(nullable=false, precision=38)
	private BigDecimal idtipologia; 
}
