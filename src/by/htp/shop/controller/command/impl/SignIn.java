package by.htp.shop.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.SportEquipment;
import by.htp.shop.bean.User;
import by.htp.shop.controller.command.Command;
import by.htp.shop.service.UserService;
import by.htp.shop.service.exception.ServiceIncorrectLoginException;
import by.htp.shop.service.exception.ServiceIncorrectPasswordException;
import by.htp.shop.service.exception.ServiceSqlErrorException;
import by.htp.shop.service.exception.ServiceUserNotFoundException;
import by.htp.shop.service.factory.ServiceFactory;

public class SignIn implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String page;

		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		UserService userService = serviceFactoryObject.getUserSevice();
		User user = null;// = new User();

		HttpSession session = request.getSession(true);

		try {
			user = userService.getUserByLogin(login, password);

		} catch (ServiceUserNotFoundException e2) {
			System.out.println("user not found");
			session.setAttribute("error_reason", "User not found!");

		} catch (ServiceSqlErrorException e2) {
			System.out.println("sql errr");
			session.setAttribute("error_reason", "sql_error");

		} catch (ServiceIncorrectLoginException e2) {
			System.out.println("incorr login");
			// session.setAttribute("error_reason", "Incorrecr login!");
			session.setAttribute("error_reason", "bad_login");

		} catch (ServiceIncorrectPasswordException e2) {
			System.out.println("incorr pass");
			session.setAttribute("error_reason", "Incorrect password!");
		}

		if (user == null) {

			session.setAttribute("error_reason", "User not found!");
			System.out.println(" user not found");
			page = "sign_in_error.jsp";
			session.setAttribute("url", "sign_in_error.jsp");

			// response.sendRedirect("Controller?command=goto_signin_error");
			// return;

		} else {

			session.setAttribute("user", user);

			if (user.getRole().equals("admin")) {
				response.sendRedirect("Controller?command=goto_admin");
				return;

			} else {
				response.sendRedirect("Controller?command=goto_user");
				return;
			}
		}

		session.setAttribute("page", page);

		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}
