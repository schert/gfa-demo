package gov.mef.gfa.gateway;

import org.springframework.http.HttpStatus;

public class GatewayError {

	private HttpStatus status;
	private String message;
	
	public GatewayError(HttpStatus status, String message) {
		this.status = status;
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GatewayError [status=" + status + ", message=" + message + "]";
	}
}
