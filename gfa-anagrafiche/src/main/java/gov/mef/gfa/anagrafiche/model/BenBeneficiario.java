package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the BEN_BENEFICIARIO database table.
 * 
 */
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

	public BenBeneficiario() {
	}

	public String getCodicefiscale() {
		return this.codicefiscale;
	}

	public void setCodicefiscale(String codicefiscale) {
		this.codicefiscale = codicefiscale;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public BigDecimal getIdbeneficiario() {
		return this.idbeneficiario;
	}

	public void setIdbeneficiario(BigDecimal idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getNominativo() {
		return this.nominativo;
	}

	public void setNominativo(String nominativo) {
		this.nominativo = nominativo;
	}

	public String getNote() {
		return this.note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public String getPartitaiva() {
		return this.partitaiva;
	}

	public void setPartitaiva(String partitaiva) {
		this.partitaiva = partitaiva;
	}

	public String getRagionesociale() {
		return this.ragionesociale;
	}

	public void setRagionesociale(String ragionesociale) {
		this.ragionesociale = ragionesociale;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public BigDecimal getTipopersona() {
		return this.tipopersona;
	}

	public void setTipopersona(BigDecimal tipopersona) {
		this.tipopersona = tipopersona;
	}

}