package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;


/**
 * The persistent class for the BEN_BENEFICIARIO database table.
 * 
 */
@Data
@NoArgsConstructor
@Entity
@Table(name="BEN_BENEFICIARIO")
public class BenBeneficiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=16)
	private String codicefiscale;

	@Column(length=100)
	private String email;

	@Column(length=20)
	private String fax;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private BigDecimal idbeneficiario;

	@Column(length=200)
	private String indirizzo;

	@Column(length=200)
	private String nominativo;

	@Column(length=4000)
	private String note;

	@Column(length=11)
	private String partitaiva;

	@Column(length=200)
	private String ragionesociale;

	@Column(length=20)
	private String telefono;

	private BigDecimal tipopersona;

}