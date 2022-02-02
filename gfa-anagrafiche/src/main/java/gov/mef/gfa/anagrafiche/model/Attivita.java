package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import javax.persistence.*;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * The persistent class for the ATTIVITA database table.
 * 
 */
@Entity
@Data
@NoArgsConstructor
@Table(name = "ATTIVITA")
@SequenceGenerator(name = "seqid-gen-attivita", sequenceName = "ATTIVITA_SEQ")
public class Attivita implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen-attivita")
	private BigDecimal idattivita;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "idente", foreignKey=@ForeignKey(name = "Fk_attivita_ente"))
	private Ente ente;

	@Column(precision = 12, scale = 2)
	private BigDecimal ammontaredelfondo;
	
	@Column(precision = 12, scale = 2)
	private BigDecimal ammontaredelfondonew;

	@Column(precision = 12, scale = 2)
	private BigDecimal ammontaregaranzieconcedibili;

	@Column(precision = 12, scale = 2)
	private BigDecimal ammontaregaranzieconcednew;

	@Column(precision = 12, scale = 2)
	private BigDecimal ammontaregaranzieinessere;

	@Column(precision = 12, scale = 2)
	private BigDecimal ammontaregaranzieinesserenew;

	@Column(nullable = false, precision = 4)
	private BigDecimal annocompetenza;

	@Column(precision = 4)
	private BigDecimal annogestione;

	@Column(precision = 38)
	private BigDecimal ascolti;

	@Column(precision = 38)
	private BigDecimal ascoltinew;

	@Temporal(TemporalType.DATE)
	private Date datacreazione;

	private BigDecimal documentazioneobbligatoria;

	private BigDecimal documentazioneobbligatorianew;

	private BigDecimal idambitonew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importodeliberate;

	@Column(precision = 12)
	private BigDecimal importodeliberateente;

	@Column(precision = 12)
	private BigDecimal importodeliberatemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importodeliberatenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoerogate;

	@Column(precision = 12)
	private BigDecimal importoerogateente;

	@Column(precision = 12)
	private BigDecimal importoerogatemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoerogatenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoescussionicerte;

	private BigDecimal importoescussionicerteente;

	private BigDecimal importoescussionicertemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoescussionicertenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoescussioniinessere;

	private BigDecimal importoescussioniinessereente;

	private BigDecimal importoescussioniinesseremef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importoescussioniinesserenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importofondorestituito;

	@Column(precision = 12, scale = 2)
	private BigDecimal importofondorestituitonew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importopraticherecuperate;

	private BigDecimal importopraticherecuperateente;

	private BigDecimal importopraticherecuperatemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importopraticherecuperatenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importorecuperate;

	private BigDecimal importorecuperateente;

	private BigDecimal importorecuperatemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importorecuperatenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importototdeliberate;

	@Column(precision = 12)
	private BigDecimal importototdeliberateente;

	@Column(precision = 12)
	private BigDecimal importototdeliberatemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importototdeliberatenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal importototerogate;

	@Column(precision = 12)
	private BigDecimal importototerogateente;

	@Column(precision = 12)
	private BigDecimal importototerogatemef;

	@Column(precision = 12, scale = 2)
	private BigDecimal importototerogatenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal interessiannocompetenza;

	@Column(precision = 12, scale = 2)
	private BigDecimal interessiannocompetenzanew;

	@Column(precision = 12, scale = 2)
	private BigDecimal interessiavviooperativita;

	@Column(precision = 12, scale = 2)
	private BigDecimal interessiavviooperativitanew;

	@Column(length = 4000)
	private String note;

	@Column(length = 4000)
	private String notenew;

	@Column(length = 4000)
	private String notestoricoaltricontributi;

	@Column(length = 4000)
	private String notestoricoaltricontributinoau;

	@Column(length = 4000)
	private String notestoricoattivitagenerale;

	@Column(length = 4000)
	private String notestoricoconvenzionibanche;

	@Column(length = 4000)
	private String notestoricodatigenerali;

	@Column(length = 4000)
	private String notestoricodeliberate;

	@Column(length = 4000)
	private String notestoricoerogate;

	@Column(length = 4000)
	private String notestoricoescussioni;

	@Column(length = 4000)
	private String notestoricogaranzie;

	@Column(length = 4000)
	private String notestoricointeressi;

	@Column(length = 4000)
	private String notestoricospese;

	private BigDecimal numdeliberate;

	private BigDecimal numdeliberatenew;

	private BigDecimal numerodiassociati;

	private BigDecimal numerodiassociatinew;

	private BigDecimal numeroescussionicerte;

	@Column(precision = 12)
	private BigDecimal numeroescussionicerteente;

	@Column(precision = 12)
	private BigDecimal numeroescussionicertemef;

	private BigDecimal numeroescussionicertenew;

	private BigDecimal numeroescussioniinessere;

	@Column(precision = 12)
	private BigDecimal numeroescussioniinessereente;

	@Column(precision = 12)
	private BigDecimal numeroescussioniinesseremef;

	private BigDecimal numeroescussioniinesserenew;

	private BigDecimal numerogaranzieinessere;

	private BigDecimal numerogaranzieinesserenew;

	private BigDecimal numerogate;

	private BigDecimal numerogatenew;

	private BigDecimal numeropraticherecuperate;

	@Column(precision = 12)
	private BigDecimal numeropraticherecuperateente;

	@Column(precision = 12)
	private BigDecimal numeropraticherecuperatemef;

	private BigDecimal numeropraticherecuperatenew;

	private BigDecimal numerorecuperate;

	@Column(precision = 12)
	private BigDecimal numerorecuperateente;

	@Column(precision = 12)
	private BigDecimal numerorecuperatemef;

	private BigDecimal numerorecuperatenew;

	private BigDecimal numtotdeliberate;

	private BigDecimal numtotdeliberatenew;

	private BigDecimal numtoterogate;

	private BigDecimal numtoterogatenew;

	@Column(precision = 38)
	private BigDecimal oreascolti;

	@Column(precision = 38)
	private BigDecimal oreascoltinew;

	@Column(precision = 12)
	private BigDecimal quotaautorizzatamef;

	@Column(precision = 12)
	private BigDecimal quotaautorizzatamefnew;

	@Column(precision = 12, scale = 2)
	private BigDecimal speselegali;

	private BigDecimal speselegaliente;

	private BigDecimal speselegalimef;

	@Column(precision = 12, scale = 2)
	private BigDecimal speselegalinew;

	@Column(precision = 12, scale = 2)
	private BigDecimal speselegalitotali;

	private BigDecimal speselegalitotaliente;

	private BigDecimal speselegalitotalimef;

	@Column(precision = 12, scale = 2)
	private BigDecimal speselegalitotalinew;

	@Column(precision = 12, scale = 2)
	private BigDecimal speserichieste;

	@Column(precision = 12, scale = 2)
	private BigDecimal speserichiestenew;

	@Column(precision = 12, scale = 2)
	private BigDecimal speserimborsateavvio;

	@Column(precision = 12, scale = 2)
	private BigDecimal speserimborsateavvionew;

	@Column(precision = 12, scale = 2)
	private BigDecimal speserimborsateperanno;

	@Column(precision = 12, scale = 2)
	private BigDecimal speserimborsateperannonew;

	@Column(nullable = false, precision = 12, scale = 2)
	private BigDecimal stanziamentoiniziale;

	@Column(precision = 12, scale = 2)
	private BigDecimal stanziamentoinizialenew;

	@Column(precision = 1)
	private BigDecimal stato;

}