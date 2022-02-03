package gov.mef.gfa.anagrafiche.exception;

public class ServiceException extends Exception {

	private static final long serialVersionUID = -6552821387894334214L;
	
	public ServiceException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public ServiceException(Throwable err) {
		super(err);
	}

}
