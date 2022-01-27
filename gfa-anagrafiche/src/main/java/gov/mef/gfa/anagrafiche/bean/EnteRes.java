package gov.mef.gfa.anagrafiche.bean;

import gov.mef.gfa.anagrafiche.model.Ente;
import gov.mef.gfa.common.gfacommon.bean.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class EnteRes extends ApiResponse {
	private Ente ente;
}