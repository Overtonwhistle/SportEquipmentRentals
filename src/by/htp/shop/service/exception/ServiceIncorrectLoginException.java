package by.htp.shop.service.exception;

public class ServiceIncorrectLoginException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceIncorrectLoginException() {
		super();
	}

	public ServiceIncorrectLoginException(String message) {
		super(message);
	}

	public ServiceIncorrectLoginException(Exception e) {
		super(e);
	}

	public ServiceIncorrectLoginException(String message, Exception e) {
		super(message, e);
	}

}
