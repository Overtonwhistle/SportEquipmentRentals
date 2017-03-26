package by.htp.shop.service.exception;

public class ServiceSqlErrorException extends ServiceException {
	private static final long serialVersionUID = 1L;

	public ServiceSqlErrorException() {
		super();
	}

	public ServiceSqlErrorException(String message) {
		super(message);
	}

	public ServiceSqlErrorException(Exception e) {
		super(e);
	}

	public ServiceSqlErrorException(String message, Exception e) {
		super(message, e);
	}

}