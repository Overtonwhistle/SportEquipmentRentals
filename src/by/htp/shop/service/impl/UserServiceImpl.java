package by.htp.shop.service.impl;

import java.util.ArrayList;

import by.htp.shop.bean.User;
import by.htp.shop.controller.command.impl.DataValidation;
import by.htp.shop.dao.UserDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.UserService;
import by.htp.shop.service.exception.ServiceIncorrectLoginException;
import by.htp.shop.service.exception.ServiceIncorrectPasswordException;
import by.htp.shop.service.exception.ServiceSqlErrorException;
import by.htp.shop.service.exception.ServiceUserNotFoundException;

public class UserServiceImpl implements UserService {

	DAOFactory daoObjectFactory = DAOFactory.getInstance();
	UserDAO userDAO = daoObjectFactory.getUserDAO();


	@Override
	public User getUserById(int id) throws ServiceUserNotFoundException, ServiceSqlErrorException {
		User user = new User();

		try {
			user = userDAO.getUser(id);
			if (user == null) {
				// System.out.println("Service - 'getUser' takes NULL from
				// userDAO.getUser()");
				throw new ServiceUserNotFoundException("Service - 'getUser' takes NULL from userDAO.getUser()");
			}

		} catch (DAOException e) {
			// System.out.println("Service - SQL err from 'getUser' ()");
			throw new ServiceSqlErrorException(e);

		}

		// System.out.println("user in SERVICE:" + user);
		return user;
	}

	@Override
	public boolean checkLogination(String login, String password) throws ServiceIncorrectPasswordException,
			ServiceIncorrectLoginException, ServiceUserNotFoundException, ServiceSqlErrorException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User getUserByLogin(String login, String password) throws ServiceUserNotFoundException,
			ServiceSqlErrorException, ServiceIncorrectLoginException, ServiceIncorrectPasswordException {

		System.out.println("in service - checkLogination...");

		if (!DataValidation.checkLogin(login)) {
			System.out.println("in service - bad login");
			throw new ServiceIncorrectLoginException("DataValidation.checkLogin(login)");
		}

		if (!DataValidation.checkPassword(password)) {
			System.out.println("in service - bad password");
			throw new ServiceIncorrectPasswordException("DataValidation.checkPassword(password)");
		}

		User user = new User();

		try {
			user = userDAO.userLogin(login, password);
			if (user == null) {
				throw new ServiceUserNotFoundException(
						"Service - 'getUserByLogin()' takes NULL from userDAO.userLogin()");
			}

		} catch (DAOException e) {
			System.out.println("Service - SQL err from 'getUser' ()");
			throw new ServiceSqlErrorException(e);

		}

		System.out.println("user in SERVICE:" + user);
		return user;

	}

	@Override
	public ArrayList<User> getUsersList() throws ServiceUserNotFoundException, ServiceSqlErrorException {

		ArrayList<User> list = new ArrayList<User>();
		try {
			list = userDAO.getUsersList();
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceSqlErrorException(e);
		}

//		if (list == null) {
//			
//			throw new ServiceUserNotFoundException("No exist users!");
//		}

		return list;
	}

}
