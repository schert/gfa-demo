package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the BENEFICIARIO_PMI_DEMINIMIS database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="BEN_BENEFICIARIO")
@SequenceGenerator(name = "seqid-gen-beneficiario", sequenceName = "BENEFICIARIO_SEQ", allocationSize = 1)
public class Beneficiario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "seqid-gen-beneficiario")
	@Column(name="IDBENEFICIARIO", unique=true, nullable=false, precision=38)
	private BigDecimal id;

	@Column(length=100)
	private String codiceAteco;

	@Column(name="CODICEFISCALE", length=16)
	private String codiceFiscale;

	@ManyToOne
    @JoinColumn(name = "comune", foreignKey=@ForeignKey(name = "Fk_beneficiario_comune"))
	private Comune comune;

	@Column(length=100)
	private String email;

	@Column(length=20)
	private String fax;

	@Column(length=200)
	private String indirizzo;

	@Column(length=200)
	private String nominativo;

	@Column(length=4000)
	private String note;	
	
	@OneToMany(mappedBy="beneficiario")
	private Set<StoricoNumeroAddetti> storicoNumeroAddetti;

	@Column(name="PARTITAIVA", length=11)
	private String partitaIva;

	@ManyToOne
    @JoinColumn(name = "provincia", foreignKey=@ForeignKey(name = "Fk_beneficiario_provincia"))
	private Provincia provincia;

	@Column(name="RAGIONESOCIALE", length=200)
	private String ragioneSociale;

	@ManyToOne
    @JoinColumn(name = "regione", foreignKey=@ForeignKey(name = "Fk_beneficiario_regione"))
	private Regione regione;

	@ManyToOne
    @JoinColumn(name = "settore", foreignKey=@ForeignKey(name = "Fk_beneficiario_settore"))
	private BenSettore settore;

	@Column(length=20)
	private String telefono;

	@ManyToOne
    @JoinColumn(name = "TIPOPERSONA", foreignKey=@ForeignKey(name = "Fk_beneficiario_tipo_persona"))
	private TipoPersona tipoPersona;

	@Column(name = "FLAG_CANCELLATO", nullable = false)
	boolean flagCancellato;

}