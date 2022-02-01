package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "siglaregione", foreignKey=@ForeignKey(name = "Fk_ente_regione"))
	private Regione regione;

	@Column(name = "SL_CAP", length = 5)
	private String slCap;

	@Column(name = "SL_COMUNE", nullable = false, length = 10)
	private String slComune;

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

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "SL_PROVINCIA", foreignKey=@ForeignKey(name = "Fk_ente_provincia"))
	private Provincia provincia;

	@Column(name = "SL_TELEFONO1", nullable = false, length = 50)
	private String slTelefono1;

	@Column(name = "SL_TELEFONO2", length = 50)
	private String slTelefono2;

	@Column(name = "SL_TELEFONO3", length = 50)
	private String slTelefono3;

	@Column(name = "SO_CAP", length = 5)
	private String soCap;

	@Column(name = "SO_COMUNE", length = 10)
	private String soComune;

	@Column(name = "SO_EMAIL", length = 50)
	private String soEmail;

	@Column(name = "SO_FAX", length = 50)
	private String soFax;

	@Column(name = "SO_INDIRIZZO", length = 100)
	private String soIndirizzo;

	@Column(name = "SO_PROVINCIA", length = 10)
	private String soProvincia;

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