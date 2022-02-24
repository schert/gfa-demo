package gov.mef.gfa.anagrafiche.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "FINANZIAMENTO_DIRETTO")
@SequenceGenerator(name = "seqid-gen-finanziamento", sequenceName = "FINANZIAMENTO_SEQ", allocationSize = 1)
public class FinanziamentoDiretto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen-finanziamento")
    @Column(nullable = false)
    private BigDecimal id;

    @ManyToOne
    @JoinColumn(name = "ID_BENEFICIARIO", foreignKey = @ForeignKey(name = "Fk_beneficiario"))
    private Beneficiario beneficiario;

    @Column(name = "IMPORTO_FINANZIAMENTO", precision = 38, scale = 2)
    private BigDecimal impoFinanziamento;

    @Column(name = "PROBABILITA_INSOLVENZA", precision = 38, scale = 2)
    private BigDecimal probInsolvenza;

    @Column(name = "IMPORTO_RISORSE_PROPRIE", precision = 38, scale = 2)
    private BigDecimal impoRisorseProprie;

    @Column(name = "PERIODICITA_RIMBORSO", precision = 38)
    private BigDecimal periodicitaRimborso;

    @Column(name = "PERCENTUALE_RISORSE_PROPRIE", precision = 3, scale = 2)
    private BigDecimal percRisorseProprie;

    @Column(name = "NUMERO_RATE", precision = 3)
    private BigDecimal numRate;

    @Column(name = "DURATA_FINANZIAMENTO", precision = 3)
    private BigDecimal durataFinanziamento;

    @Column(name = "TASSO_INTERESSE_APPLICATO", precision = 4, scale = 2)
    private BigDecimal tassoInteresse;

    @Column(name = "DATA_EROGAZIONE")
    private Date dataErogazione;

    @Column(name = "DATA_ADOZIONE_DELIBERA")
    private Date dataDelibera;

    @ManyToOne
    @JoinColumn(name = "FORMA_GARANZIA", foreignKey = @ForeignKey(name = "Fk_forma_garanzia"))
    private FormaGaranzia formaGaranzia;

    @Column(name = "IMPORTO_GARANTITO", precision = 38, scale = 2)
    private BigDecimal impoGarantito;

    @Column(name = "DATA_INSERIMENTO")
    private Date dataInserimento;

    @Column(name = "DATA_ULTIMA_MODIFICA")
    private Date dataUltimaModifica;

    @ManyToOne
    @JoinColumn(name = "ID_ENTE", foreignKey = @ForeignKey(name = "Fk_utente"))
    private Ente ente;

    @Column(name = "FLAG_CANCELLATO", nullable = false)
    private boolean flagCancellato;

    @Column(name = "ID_DOCUMENTO")
    private BigDecimal idDoc;

}
