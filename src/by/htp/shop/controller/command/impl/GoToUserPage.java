package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;

public class GoToUserPage implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// http://127.0.0.1:8080/Laboratory/Controller/command=goto_user
		System.out.println("in GOTO USER PAGE");
		HttpSession session = request.getSession(true);
		session.setAttribute("url", "Controller?command=goto_user");

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/user.jsp");
		dispatcher.forward(request, response);

	}

}
