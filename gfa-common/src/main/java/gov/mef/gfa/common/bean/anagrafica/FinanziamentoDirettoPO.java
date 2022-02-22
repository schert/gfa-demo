package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FinanziamentoDirettoPO {
    private BigDecimal id;
    @Valid
    private BeneficiarioPO beneficiario;
    private BigDecimal impoFinanziamento;
    private BigDecimal probInsolvenza;
    private BigDecimal impoRisorseProprie;
    private BigDecimal periodicitaRimborso;
    private BigDecimal percRisorseProprie;
    private BigDecimal numRate;
    private BigDecimal durataFinanziamento;
    private BigDecimal tassoInteresse;
    private Date dataErogazione;
    private Date dataDelibera;
    private FormaGaranziaPO formaGaranzia;
    private BigDecimal impoGarantito;
    private Date dataInserimento;
    private Date dataUltimaModifica;
    private EntePO ente;
    @NotNull
    private boolean flagCancellatoSN;
}
