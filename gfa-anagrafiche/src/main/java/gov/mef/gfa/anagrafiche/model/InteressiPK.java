package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Embeddable
public class InteressiPK implements Serializable {
	private static final long serialVersionUID = 9210508979742918158L;
	private BigDecimal idattivita;
	private BigDecimal idtipologia; 
}
