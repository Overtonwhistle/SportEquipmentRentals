package by.htp.shop.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.controller.command.Command;
import by.htp.shop.controller.command.CommandProvider;
import by.htp.shop.dao.exception.DAOException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final CommandProvider provider = new CommandProvider();
       
    public Controller() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
//		HttpSession session = request.getSession(true);
		String page = request.getParameter("page");
		System.out.println("contr page: " + page);
		
		
		String commandName = request.getParameter("command");
		System.out.println("contr comm: " + commandName);
		System.out.println("Controller execute--- "+commandName);
		Command command = provider.getCommand(commandName);
		try {
			command.execute(request, response);
		} catch (DAOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
