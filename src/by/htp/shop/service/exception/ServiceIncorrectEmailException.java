package by.htp.shop.service.exception;

public class ServiceIncorrectEmailException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceIncorrectEmailException() {
		super();
	}

	public ServiceIncorrectEmailException(String message) {
		super(message);
	}

	public ServiceIncorrectEmailException(Exception e) {
		super(e);
	}

	public ServiceIncorrectEmailException(String message, Exception e) {
		super(message, e);
	}

}