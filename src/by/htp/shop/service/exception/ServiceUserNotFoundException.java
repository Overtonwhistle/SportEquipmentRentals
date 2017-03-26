package by.htp.shop.service.exception;

public class ServiceUserNotFoundException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceUserNotFoundException() {
		super();
	}

	public ServiceUserNotFoundException(String message) {
		super(message);
	}

	public ServiceUserNotFoundException(Exception e) {
		super(e);
	}

	public ServiceUserNotFoundException(String message, Exception e) {
		super(message, e);
	}

}
