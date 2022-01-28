package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * The persistent class for the BEN_TIPOAIUTO database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="BEN_TIPOAIUTO")
public class BenTipoaiuto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=4000)
	private String descrizione;
	
	@Id
	@Column(nullable=false)
	private BigDecimal idtipoaiuto;

}