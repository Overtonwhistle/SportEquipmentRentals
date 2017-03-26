package by.htp.shop.service.exception;

public class ServiceIncorrectPasswordException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceIncorrectPasswordException() {
		super();
	}

	public ServiceIncorrectPasswordException(String message) {
		super(message);
	}

	public ServiceIncorrectPasswordException(Exception e) {
		super(e);
	}

	public ServiceIncorrectPasswordException(String message, Exception e) {
		super(message, e);
	}

}