package gov.mef.gfa.gestionale.view;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class HomeBean {
	
	@Value("${pod.name}")
	private String podName;

	public String getPodName() {
		return podName;
	}

	public void setPodName(String podName) {
		this.podName = podName;
	}

}
