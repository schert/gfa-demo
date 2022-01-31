package gov.mef.gfa.anagrafiche.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="BEN_STORICOSETTORE")
public class BenStoricoSettore {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable=false)
	private BigDecimal idbeneficiario;
	
	@Column(length=20)
	private String idsettore;
	
	@Column(precision=4)
	private BigDecimal annocompetenzada;

	@Column(nullable=false, precision=4)
	private BigDecimal annocompetenzaa;

	public BigDecimal getIdbeneficiario() {
		return idbeneficiario;
	}

	public void setIdbeneficiario(BigDecimal idbeneficiario) {
		this.idbeneficiario = idbeneficiario;
	}

	public String getIdsettore() {
		return idsettore;
	}

	public void setIdsettore(String idsettore) {
		this.idsettore = idsettore;
	}

	public BigDecimal getAnnocompetenzada() {
		return annocompetenzada;
	}

	public void setAnnocompetenzada(BigDecimal annocompetenzada) {
		this.annocompetenzada = annocompetenzada;
	}

	public BigDecimal getAnnocompetenzaa() {
		return annocompetenzaa;
	}

	public void setAnnocompetenzaa(BigDecimal annocompetenzaa) {
		this.annocompetenzaa = annocompetenzaa;
	}
	
}
