package by.htp.shop.controller.command.impl;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.User;
import by.htp.shop.controller.command.Command;
import by.htp.shop.service.UserService;
import by.htp.shop.service.exception.ServiceSqlErrorException;
import by.htp.shop.service.exception.ServiceUserNotFoundException;
import by.htp.shop.service.factory.ServiceFactory;

public class GoToUsersList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(true);
		session.setAttribute("url", "Controller?command=goto_users_list");
		String page = "WEB-INF/jsp/users_list.jsp";
		

		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		UserService userService = serviceFactoryObject.getUserSevice();
		ArrayList<User> usersList = null;

			try {
				usersList = userService.getUsersList();
			
			} catch (ServiceUserNotFoundException e) {
				System.out.println("ServiceUserNotFoundException in GoToUsersList");
				session.setAttribute("error_reason", "Users not found!");
				page = "WEB-INF/jsp/error.jsp";
			
			} catch (ServiceSqlErrorException e) {
				System.out.println("ServiceSqlErrorException in GoToUsersList");
				session.setAttribute("error_reason", "SQL Error!");
				page = "WEB-INF/jsp/error.jsp";
			}

		System.out.println(usersList);

		session.setAttribute("list", usersList);
		request.setAttribute("list", usersList);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		
		dispatcher.forward(request, response);

	}

}