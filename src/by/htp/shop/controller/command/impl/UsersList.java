package by.htp.shop.controller.command.impl;

import java.util.ArrayList;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.htp.shop.bean.User;
import by.htp.shop.controller.command.Command;
import by.htp.shop.dao.UserDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;

public class UsersList implements Command {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws DAOException  {
		System.out.println("getting list users");
		
		DAOFactory daoObjectFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoObjectFactory.getUserDAO();
		ArrayList<User> usersList = userDAO.getUsersList();
		
		System.out.println(usersList);
		
		
		HttpSession session = request.getSession(true);
//		session.setAttribute("user", user);
		
//		String page;
//		if(user.getRole().equals("user")){
//			List<SportEquipment> list = null;//service
//			request.setAttribute("eq", list);
//			page = "/WEB-INF/jsp/user.jsp";
//		}else{
//			page = "/WEB-INF/jsp/admin.jsp";
//		}
//		
//		session.setAttribute("page", page);
		
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/admin.jsp");
//		try {
//			dispatcher.forward(request, response);
//		} catch (ServletException | IOException e) {
//			// log
//			dispatcher = request.getRequestDispatcher("error.jsp");
//			try {
//				dispatcher.forward(request, response);
//			} catch (ServletException |IOException e1) {
//				//log
//			}
//			
//		}
		
		
		
	}

}
