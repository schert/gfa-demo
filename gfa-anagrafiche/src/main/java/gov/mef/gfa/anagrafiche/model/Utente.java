package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the UTENTE database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name="UTENTE")
public class Utente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(length=50)
	private String cognome;

	@Temporal(TemporalType.DATE)
	private Date datacreazione;

	@Temporal(TemporalType.DATE)
	private Date datadisabilitazione;

	@Column(length=255)
	private String email;

	@ManyToOne
	@JoinColumn(name = "idufficio", foreignKey=@ForeignKey(name = "Fk_utente_strutturaufficio"), nullable = false)
	private StrutturaUfficio strutturaUfficio;

	@Id
	@Column(nullable=false, precision=38)
	private BigDecimal idutente;

	@Column(length=50)
	private String nome;

	private BigDecimal ruolo;

	@Column(length=50)
	private String username;

}