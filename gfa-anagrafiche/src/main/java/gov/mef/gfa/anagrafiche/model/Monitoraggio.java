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
@Table(name = "MONITORAGGIO")
@SequenceGenerator(name = "seqid-gen-monitoraggio", sequenceName = "MONITORAGGIO_SEQ", allocationSize = 1)
public class Monitoraggio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqid-gen-monitoraggio")
    @Column(nullable = false)
    private BigDecimal id;

    @Column(name = "DATA_MONITORAGGIO", nullable = false)
    private Date dataMonitoraggio;

    @Column(name = "NUM_RATE_INSOLUTE", nullable = false, precision = 3)
    private BigDecimal numRateInsolute;

    @Column(name = "NUM_RATE_PAGATE", nullable = false, precision = 3)
    private BigDecimal numRatePagate;

    @Column(name = "NUM_RATE_PAGATE_DOPO_INSOLUTE", precision = 3)
    private BigDecimal numRatePagateDopoInsolute;

    @Column(name = "IMPO_RATE_PAGATE", nullable = false, precision = 38)
    private BigDecimal impoRatePagate;

    @Column(name = "IMPO_RATE_INSOLUTE", nullable = false, precision = 38)
    private BigDecimal impoRateInsolute;

    @Column(name = "IMPO_RATE_PAGATE_DOPO_INSOLUTE", precision = 38)
    private BigDecimal impoRatePagateDopoInsolute;

    @Column(name = "DATA_PASSAGGIO_DETERIORATO")
    private Date dataPassaggioDeteriorato;

    @Column(name = "DATA_RITORNO_BONIS")
    private Date dataRitornoBonis;

    @Column(name = "STATUS", nullable = false)
    private String status;

    @Column(name = "STATO_UPLOADER_MONITORAGGIO", nullable = false)
    private BigDecimal statoMonitoraggio;

    @ManyToOne
    @JoinColumn(name = "ID_FINANZIAMENTO_DIRETTO", nullable = false, foreignKey = @ForeignKey(name = "Fk_finanziamento_diretto"))
    private FinanziamentoDiretto finanziamentoDiretto;

    @Column(name = "NOTE")
    private String note;

}
