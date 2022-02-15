package gov.mef.gfa.filemanager.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class FileException extends Exception {

	private static final long serialVersionUID = -7914126436857558836L;

	private Object obj;
	
	public FileException(String errorMessage, Object obj) {
		super(errorMessage);
		this.obj = obj;
	}
	
	public FileException(String errorMessage) {
		super(errorMessage);
	}
	
	public FileException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public FileException(String errorMessage, Throwable err, Object obj) {
		super(errorMessage, err);
		this.obj = obj;
	}
	
	public FileException(Throwable err) {
		super(err);
	}
}
