package gov.mef.gfa.common.gfacommon;

import org.springframework.stereotype.Component;

import gov.mef.gfa.common.gfacommon.bean.StatusRes;

@Component(value="1")
public class GfaClientImpl1  implements GfaClient {

	@Override
	public String test() {
		return "GfaClientImpl1";
	}

}
