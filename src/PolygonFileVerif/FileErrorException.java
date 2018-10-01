package PolygonFileVerif;

public class FileErrorException extends Exception {

	public FileErrorException() {
		super();
	}
	
	public FileErrorException(String message) {
		super(message);
	}

	public FileErrorException(Throwable cause) {
		super(cause);
	}

	public FileErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public FileErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
