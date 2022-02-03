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
 * The persistent class for the ENTE database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "ENTE")
public class Ente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, precision = 38)
	private BigDecimal idente;

	@Column(length = 500)
	private String causale;

	@Column(length = 11)
	private String codicefiscale;

	@Temporal(TemporalType.DATE)
	private Date datacessazione;

	@Temporal(TemporalType.DATE)
	@Column(nullable = false)
	private Date datacostituzione;

	@Temporal(TemporalType.DATE)
	private Date datafusione;

	@Column(length = 50)
	private String emailreferente;

	@Column(length = 500)
	private String fusioni;

	@Column(length = 1)
	private String motivazione;

	@Column(length = 79)
	private String nominativoreferente;

	@Column(length = 4000)
	private String note;

	@Column(length = 11)
	private String partitaiva;

	@Column(nullable = false, precision = 38)
	private BigDecimal progressivoregione;

	@Column(nullable = false, length = 200)
	private String ragionesociale;

	@Column(length = 100)
	private String settoreeconomico;
	
	@Column(length = 3)
	private String siglaregione;

	@Column(name = "SL_CAP", length = 5)
	private String slCap;

	@ManyToOne
	@JoinColumn(name = "SL_COMUNE", foreignKey=@ForeignKey(name = "Fk_ente_comune"))
	private Comune slComune;

	@Column(name = "SL_EMAIL", length = 50)
	private String slEmail;

	@Column(name = "SL_FAX", length = 50)
	private String slFax;

	@Column(name = "SL_INDIRIZZO", nullable = false, length = 100)
	private String slIndirizzo;

	@Column(name = "SL_INDIRIZZOWEB", length = 100)
	private String slIndirizzoweb;

	@Column(name = "SL_PEC", length = 50)
	private String slPec;

	@ManyToOne
	@JoinColumn(name = "SL_PROVINCIA", foreignKey=@ForeignKey(name = "Fk_ente_provincia"))
	private Provincia slProvincia;

	@Column(name = "SL_TELEFONO1", nullable = false, length = 50)
	private String slTelefono1;

	@Column(name = "SL_TELEFONO2", length = 50)
	private String slTelefono2;

	@Column(name = "SL_TELEFONO3", length = 50)
	private String slTelefono3;

	@Column(name = "SO_CAP", length = 5)
	private String soCap;

	@ManyToOne
	@JoinColumn(name = "SO_COMUNE", foreignKey=@ForeignKey(name = "Fk_ente_comune_2"))
	private Comune soComune;

	@Column(name = "SO_EMAIL", length = 50)
	private String soEmail;

	@Column(name = "SO_FAX", length = 50)
	private String soFax;

	@Column(name = "SO_INDIRIZZO", length = 100)
	private String soIndirizzo;
	
	@ManyToOne
	@JoinColumn(name = "SO_PROVINCIA", foreignKey=@ForeignKey(name = "Fk_ente_provincia_2"))
	private Provincia soProvincia;

	@Column(name = "SO_TELEFONO1", length = 50)
	private String soTelefono1;

	@Column(name = "SO_TELEFONO2", length = 50)
	private String soTelefono2;

	@Column(name = "SO_TELEFONO3", length = 50)
	private String soTelefono3;

	@Column(nullable = false, precision = 38)
	private BigDecimal stato;

	@Column(length = 50)
	private String telefonoreferente;

	@Column(nullable = false, precision = 38)
	private BigDecimal tipologia;

}