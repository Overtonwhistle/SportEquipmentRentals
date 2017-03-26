package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.dao.exception.DAOException;

public class RegisterUser implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws DAOException, IOException, ServletException {

		System.out.println("in REGISTER USER");
		HttpSession session = request.getSession(true);
		session.setAttribute("url", "Controller?command=register_user");
		
		if (session.getAttribute("user")!=null) 
		{
			System.out.println("removing user from session...");
			session.removeAttribute("user");
		}

//		response.sendRedirect("Controller?command=goto_admin");
//		return;
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/register_form.jsp");

		dispatcher.forward(request, response);
		
		
	}

}
