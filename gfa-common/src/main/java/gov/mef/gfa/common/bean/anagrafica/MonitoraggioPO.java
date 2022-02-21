package gov.mef.gfa.common.bean.anagrafica;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MonitoraggioPO {
    private BigDecimal id;
    private Date dataMonitoraggio;
    private BigDecimal numRateInsolute;
    private BigDecimal numRatePagate;
    private BigDecimal numRatePagateDopoInsolute;
    private BigDecimal impoRatePagate;
    private BigDecimal impoRateInsolute;
    private BigDecimal impoRatePagateDopoInsolute;
    private Date dataPassaggioDeteriorato;
    private Date dataRitornoBonis;
    private String status;	
    private BigDecimal statoMonitoraggio;
    private FinanziamentoDirettoPO finanziamentoDiretto;
    private String note;
}
