package gov.mef.gfa.common.gfacommon;

import org.springframework.stereotype.Component;

@Component(value="2")
public class GfaClientImpl2 implements GfaClient{

	public String test() {
		return "GfaClientImpl2";
	}

}
