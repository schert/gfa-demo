package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinanziamentoDirettoPO {
    private BigDecimal id;
    private BeneficiarioPO beneficiario;
    private BigDecimal impoFinanziamento;
    private BigDecimal probInsolvenza;
    private BigDecimal impoRisorseProprie;
    private BigDecimal periodicitaRimborso;
    private BigDecimal percRisorseProprie;
    private BigDecimal numRate;
    private BigDecimal durataFinanziamento;
    private BigDecimal tassoInteresse;
    private Timestamp dataErogazione;
    private Timestamp dataDelibera;
    private FormaGaranziaPO formaGaranzia;
    private BigDecimal impoGarantito;
    private Timestamp dataInserimento;
    private Timestamp dataUltimaModifica;
    private EntePO ente;
    private boolean flagCancellatoSN;
}
