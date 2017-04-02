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
import by.htp.shop.service.exception.ServiceIncorrectEmailException;
import by.htp.shop.service.exception.ServiceIncorrectLoginException;
import by.htp.shop.service.exception.ServiceIncorrectPasswordException;
import by.htp.shop.service.exception.ServiceIncorrectPhoneException;
import by.htp.shop.service.exception.ServiceLoginExistException;
import by.htp.shop.service.exception.ServiceSqlErrorException;
import by.htp.shop.service.exception.ServiceUserNotFoundException;
import by.htp.shop.service.factory.ServiceFactory;

public class RegistrationProcess implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in REGISTRATION PROCESS METHOD");

		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String login = request.getParameter("login");
		String password = request.getParameter("password");

		String page = "WEB-INF/jsp/register_done.jsp";
		boolean isDone = true;

		System.out.println("naaaame=" + name);

		if (name.equals("")) {
			request.setAttribute("err_name", true);
			System.out.println("empty name!!");
			isDone = false;
		}
		
		if (surname.equals("")) {
			request.setAttribute("err_surname", true);
			System.out.println("empty surname!!");
			isDone = false;
		}

//		if (phone.equals("")) {
//			System.out.println("empty phone!!!!!");
//		}
		
		ServiceFactory serviceFactoryObject = ServiceFactory.getInstance();
		UserService userService = serviceFactoryObject.getUserSevice();
		User user = new User();// = new User();

		user.setName(name);
		user.setSurname(surname);
		user.setAddress(address);
		user.setPhone(phone);
		user.setEmail(email);
		user.setLogin(login);
		user.setPassword(password);
		user.setRole("user");

		try {
			userService.addUser(user);
		} catch (ServiceUserNotFoundException e) {
			isDone = false;
			request.setAttribute("err_formuser", true);
			System.out.println("empty user in method");
//			e.printStackTrace();
		} catch (ServiceIncorrectLoginException e) {
			request.setAttribute("err_login", true);
			isDone = false;
//			e.printStackTrace();
		} catch (ServiceIncorrectPasswordException e) {
			request.setAttribute("err_password", true);
			isDone = false;
//			e.printStackTrace();
		} catch (ServiceIncorrectPhoneException e) {
			request.setAttribute("err_phone", true);
			isDone = false;
//			e.printStackTrace();
		} catch (ServiceIncorrectEmailException e) {
			request.setAttribute("err_email", true);
			isDone = false;
//			e.printStackTrace();
		} catch (ServiceLoginExistException e) {
			request.setAttribute("ex_login", true);
			isDone = false;
//			e.printStackTrace();
		} catch (ServiceSqlErrorException e) {
//			page = "error.jsp";
			isDone = false;
			request.setAttribute("err_sql", true);
			e.printStackTrace();
		}

		if (!isDone) {
			page = "WEB-INF/jsp/register_form.jsp";
		}

		HttpSession session = request.getSession(true);
		session.setAttribute("user", user);


		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);

	}

}