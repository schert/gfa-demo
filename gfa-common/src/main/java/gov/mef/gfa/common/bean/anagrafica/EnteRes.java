package gov.mef.gfa.common.bean.anagrafica;

import gov.mef.gfa.common.bean.common.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EnteRes extends ApiResponse {
	private EntePO ente;
}