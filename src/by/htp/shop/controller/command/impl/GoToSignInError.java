package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;

public class GoToSignInError implements Command{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)  {
		
		//http://127.0.0.1:8080/Laboratory/Controller/command=goto_user
		System.out.println("in GOTO SIGN IN ERROR");
		HttpSession session = request.getSession(true);
		session.setAttribute("url", "Controller?command=goto_signin_error");
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/sign_in_error.jsp");
		try {
			dispatcher.forward(request, response);
		} catch (ServletException | IOException e) {
			// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			e.printStackTrace();
		}
		
	}

}
