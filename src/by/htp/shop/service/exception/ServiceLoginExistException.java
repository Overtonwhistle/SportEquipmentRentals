package by.htp.shop.service.exception;

public class ServiceLoginExistException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceLoginExistException() {
		super();
	}

	public ServiceLoginExistException(String message) {
		super(message);
	}

	public ServiceLoginExistException(Exception e) {
		super(e);
	}

	public ServiceLoginExistException(String message, Exception e) {
		super(message, e);
	}

}