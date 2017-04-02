package by.htp.shop.service.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

	public static boolean checkLogin(String login) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");
		Matcher m = p.matcher(login);
		return m.matches();
	}

	public static boolean checkPassword(String password) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\\\.]{1,20}$");
		Matcher m = p.matcher(password);
		return m.matches();
	}

	public static boolean checkEmail(String email) {
		Pattern p = Pattern
				.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		// Pattern p =
		// Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$");
		Matcher m = p.matcher(email);
		System.out.println("validation EMAIL-" + m);
		return m.matches();
	}

	public static boolean checkPhone(String phone) {
		Pattern p = Pattern.compile("^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$");
		Matcher m = p.matcher(phone);
		return m.matches();
	}

	public static boolean checkTelNumber(String telNumber) {
		String str = telNumber.replaceAll("[-+)(]", "");
		if (str.matches("^(\\d+)$")) {
			if (str.length() < 10) {
				return false;
			}
			if (str.length() > 12) {
				return false;
			}
			if (str.length() == 11) {
				return false;
			}
		}
		if (str.matches("^(\\d+)$") && str.charAt(0) != '3' && str.length() == 12) {
			return false;
		}
		if (telNumber.matches(("^(\\+)?\\d+?\\-?\\d+\\-?\\d+$"))
				|| telNumber.matches("^(\\+\\d+)?(\\(\\d{3}\\))\\d{7}$")
				|| telNumber.matches("^(\\+\\d+)?(\\(\\d{3}\\))(\\(\\d{3}\\))?\\-?\\d$")
				|| telNumber.matches("^(\\+\\-?(\\d){12})$|^(\\d){10}$")) {
			return true;
		}
		return false;
	}

}
