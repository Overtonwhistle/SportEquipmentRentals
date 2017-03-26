package by.htp.shop.controller.command.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidation {

	public static boolean checkLogin(String login) {
		// Pattern p = Pattern.compile("^[a-z0-9_-]{3,15}$");
		
		// 2-20 symbols (letters and numbers), first - only letter
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$");

		Matcher m = p.matcher(login);
		return m.matches();
	}

	
	public static boolean checkPassword(String password) {
		
		// min 8 symbols (letters and numbers, spec.chars)
//		Pattern p = Pattern.compile("(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$");
		// 2-20 symbols (letters and numbers), first - only letter
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z0-9-_\\\\.]{1,20}$");

		Matcher m = p.matcher(password);
		return m.matches();
	}
	
}
