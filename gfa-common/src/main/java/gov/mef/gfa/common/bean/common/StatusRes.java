package gov.mef.gfa.common.bean.common;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StatusRes {
	private static final int SYSTEM_ERROR = -1;
	private static final int BUSINESS_ERROR = -2;
	private static final int SUCCESS = 0;
	private static final String OK = "OK";
		
	private int statusCode;
	private String message;
	private Map<String, String> validationErrors;
	private Object request;
	
	public static StatusRes error(String message, Object request) {	
		return new StatusRes(SYSTEM_ERROR, message, null, request);
	}
	
	public static StatusRes businessError(String message, Map<String, String> validationErrors, Object request) {	
		return new StatusRes(BUSINESS_ERROR, message, validationErrors, request);
	}
	
	public static StatusRes businessError(String message, Map<String, String> validationErrors) {	
		return new StatusRes(BUSINESS_ERROR, message, validationErrors, null);
	}
	
	public static StatusRes success(String message, Object request) {
		return new StatusRes(SUCCESS, message, null, request);
	}
	
	public static StatusRes success() {	
		return new StatusRes(SUCCESS, OK, null, null);
	}
}
