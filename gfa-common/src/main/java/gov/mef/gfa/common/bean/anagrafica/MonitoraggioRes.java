package gov.mef.gfa.common.bean.anagrafica;

import gov.mef.gfa.common.bean.common.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class MonitoraggioRes extends ApiResponse {
    private MonitoraggioPO monitoraggio;
}
