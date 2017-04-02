package by.htp.shop.service.exception;

public class ServiceIncorrectPhoneException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceIncorrectPhoneException() {
		super();
	}

	public ServiceIncorrectPhoneException(String message) {
		super(message);
	}

	public ServiceIncorrectPhoneException(Exception e) {
		super(e);
	}

	public ServiceIncorrectPhoneException(String message, Exception e) {
		super(message, e);
	}

}