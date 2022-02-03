package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the STRUTTURA database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="STRUTTURA")
public class Struttura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date datadisattivazione;

	@Column(nullable=false, length=50)
	private String descrizione;

	@Column(precision=38)
	private BigDecimal idaoo;

	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal idstruttura;

}