package gov.mef.gfa.common.bean.common;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ApiRequest {
	private Params params;
	private Auth auth;
}
