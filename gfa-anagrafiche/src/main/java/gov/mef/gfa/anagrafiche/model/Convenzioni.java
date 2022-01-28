package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the CONVENZIONI database table.
 * 
 */
@Entity
@Table(name="CONVENZIONI")
public class Convenzioni implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal idconvenzione;
	
	@Column(nullable=false, precision=38)
	private BigDecimal idattivita;

	@Column(length=300)
	private String indirizzo;

	@Column(precision=12, scale=2)
	private BigDecimal maxfinerogabile;

	@Column(nullable=false, precision=1)
	private BigDecimal modificato;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal moltiplicatore;

	@Column(nullable=false, length=300)
	private String nomeistituto;

	@Column(nullable=false, precision=12, scale=2)
	private BigDecimal somma;

	public Convenzioni() {
	}

	public BigDecimal getIdattivita() {
		return this.idattivita;
	}

	public void setIdattivita(BigDecimal idattivita) {
		this.idattivita = idattivita;
	}

	public String getIndirizzo() {
		return this.indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public BigDecimal getMaxfinerogabile() {
		return this.maxfinerogabile;
	}

	public void setMaxfinerogabile(BigDecimal maxfinerogabile) {
		this.maxfinerogabile = maxfinerogabile;
	}

	public BigDecimal getModificato() {
		return this.modificato;
	}

	public void setModificato(BigDecimal modificato) {
		this.modificato = modificato;
	}

	public BigDecimal getMoltiplicatore() {
		return this.moltiplicatore;
	}

	public void setMoltiplicatore(BigDecimal moltiplicatore) {
		this.moltiplicatore = moltiplicatore;
	}

	public String getNomeistituto() {
		return this.nomeistituto;
	}

	public void setNomeistituto(String nomeistituto) {
		this.nomeistituto = nomeistituto;
	}

	public BigDecimal getSomma() {
		return this.somma;
	}

	public void setSomma(BigDecimal somma) {
		this.somma = somma;
	}

}