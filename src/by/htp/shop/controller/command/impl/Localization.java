package by.htp.shop.controller.command.impl;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;


	public class Localization implements Command {

		@Override
		public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException {
			
			System.out.println("LOCALIZATION here");
			HttpSession session = request.getSession(true);
			session.setAttribute("local", request.getParameter("local"));
			
//			RequestDispatcher dispatcher = request.getRequestDispatcher(page);
			
			String url;
			url = (String) session.getAttribute("url");
			
			if(url != null){
				response.sendRedirect(url);
				
			}else{
				System.out.println("In LOCALIZATION - redirect to index.jsp");
				response.sendRedirect("index.jsp");
			}
			
		}

	}
