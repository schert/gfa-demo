package gov.mef.gfa.anagrafiche.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="RIPARTIZIONEGEOGRAFICA")
public class RipartizioneGeografica {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private BigDecimal id;
	
	@Column(length=6)
	private String ripartizione;
	
	@Column(length=10)
	private String codregione;

	public BigDecimal getId() {
		return id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public String getRipartizione() {
		return ripartizione;
	}

	public void setRipartizione(String ripartizione) {
		this.ripartizione = ripartizione;
	}

	public String getCodregione() {
		return codregione;
	}

	public void setCodregione(String codregione) {
		this.codregione = codregione;
	}

}
