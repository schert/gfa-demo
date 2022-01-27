package gov.mef.gfa.gestionale.model;

import gov.mef.gfa.common.gfacommon.bean.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EnteRes extends ApiResponse {
	private Ente ente;
}