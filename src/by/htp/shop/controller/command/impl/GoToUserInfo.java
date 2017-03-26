package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.dao.exception.DAOException;

public class GoToUserInfo implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws DAOException, IOException, ServletException {

		System.out.println("in GOTO USER INFO");
		HttpSession session = request.getSession(true);
		session.setAttribute("url", "Controller?command=goto_user_info");

		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/user_info.jsp");

		dispatcher.forward(request, response);

	}

}
