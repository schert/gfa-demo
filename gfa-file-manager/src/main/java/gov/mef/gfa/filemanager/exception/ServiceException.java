package gov.mef.gfa.filemanager.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends Exception {

	private static final long serialVersionUID = -6552821387894334214L;
	private Object obj;
	
	public ServiceException(String errorMessage) {
		super(errorMessage);
	}
	
	public ServiceException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public ServiceException(String errorMessage, Throwable err, Object obj) {
		super(errorMessage, err);
		this.obj = obj;
	}
	
	public ServiceException(Throwable err) {
		super(err);
	}

}
