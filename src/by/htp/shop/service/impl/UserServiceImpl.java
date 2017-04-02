package by.htp.shop.service.impl;

import java.util.ArrayList;

import by.htp.shop.bean.User;
import by.htp.shop.dao.UserDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.factory.DAOFactory;
import by.htp.shop.service.UserService;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.exception.ServiceIncorrectEmailException;
import by.htp.shop.service.exception.ServiceIncorrectLoginException;
import by.htp.shop.service.exception.ServiceIncorrectPasswordException;
import by.htp.shop.service.exception.ServiceIncorrectPhoneException;
import by.htp.shop.service.exception.ServiceLoginExistException;
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

		// System.out.println("in service - checkLogination...");

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

		// if (list == null) {
		//
		// throw new ServiceUserNotFoundException("No exist users!");
		// }

		return list;
	}

	@Override
	public boolean addUser(User user) throws ServiceUserNotFoundException, ServiceIncorrectLoginException,
			ServiceIncorrectPasswordException, ServiceIncorrectPhoneException, ServiceIncorrectEmailException,
			ServiceLoginExistException, ServiceSqlErrorException {

		if (user == null) {
			System.out.println("null user!!");
			throw new ServiceUserNotFoundException("null ref to user in addUser()");
		}

		try {
			if (userDAO.isLoginExist(user.getLogin())) {
				System.out.println("login exist!!");
				throw new ServiceLoginExistException("login exist in addUser()");
			}
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceSqlErrorException("isLoginExist() in addUser()");
		}

		

//		if (!user.getPhone().equals("")) {
//			System.out.println("+++++++++++phone valid");
//		System.out.println("++++phone:"+user.getPhone());
			if ((!user.getPhone().equals(""))&&!DataValidation.checkTelNumber(user.getPhone())) {
				System.out.println("in service addUser - bad phone");
				throw new ServiceIncorrectPhoneException("DataValidation.checkPhone()");
			}
//		}

//		if (!user.getEmail().equals("")) {
//			System.out.println("+++++++++++email valid");
			if ((!user.getEmail().equals(""))&&!DataValidation.checkEmail(user.getEmail())) {
				System.out.println("in service addUser - bad mail");
				throw new ServiceIncorrectEmailException("DataValidation.checkEmail()");
			}
//		}

		if (!DataValidation.checkLogin(user.getLogin())) {
			System.out.println("in service addUser - bad login");
			throw new ServiceIncorrectLoginException("DataValidation.checkLogin()");
		}

		if (!DataValidation.checkPassword(user.getPassword())) {
			System.out.println("in service addUser - bad password");
			throw new ServiceIncorrectPasswordException("DataValidation.checkPassword()");
		}
		
		try {
			return userDAO.addUser(user);
		} catch (DAOException e) {
			e.printStackTrace();
			throw new ServiceSqlErrorException("DAO addUser() in addUser()");
		}
	}

}
