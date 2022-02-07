package gov.mef.gfa.common.bean.anagrafica;

import gov.mef.gfa.common.bean.common.ApiResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class BeneficiarioRes extends ApiResponse {
	private BeneficiarioPO beneficiario;
}