package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;

public class Localization2 implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("in localization body 6");

		String local;
		local = request.getParameter("local");
		HttpSession session = request.getSession(true);
		session.setAttribute("local", local);
		// request.getSession(true).setAttribute("local",
		// request.getParameter("local"));

//		String page = (String) session.getAttribute("page");
		String page = request.getParameter("page");
		System.out.println("page: " + page);

		try {
			request.getRequestDispatcher(page).forward(request, response);
//			request.getRequestDispatcher("index.jsp").forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}