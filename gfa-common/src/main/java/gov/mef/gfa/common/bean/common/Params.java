package gov.mef.gfa.common.bean.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Params {
	private static final int ERROR = -1;
	private static final int BUSINESS_ERROR = -2;
	private static final int SUCCESS = 0;
	private static final String OK = "OK";
	
	private int statusCode;
	private String message;
	private Object request;
	
	public static Params error(String message, Object request) {	
		return new Params(ERROR, message, request);
	}
	
	public static Params businessError(String message, Object request) {	
		return new Params(BUSINESS_ERROR, message, request);
	}
	
	public static Params success(String message, Object request) {	
		return new Params(SUCCESS, message, request);
	}
	
	public static Params success() {	
		return new Params(SUCCESS, OK, null);
	}
}
