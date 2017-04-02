package by.htp.shop.service;

import java.util.ArrayList;

import by.htp.shop.bean.User;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.service.exception.ServiceException;
import by.htp.shop.service.exception.ServiceIncorrectEmailException;
import by.htp.shop.service.exception.ServiceIncorrectLoginException;
import by.htp.shop.service.exception.ServiceIncorrectPasswordException;
import by.htp.shop.service.exception.ServiceIncorrectPhoneException;
import by.htp.shop.service.exception.ServiceLoginExistException;
import by.htp.shop.service.exception.ServiceSqlErrorException;
import by.htp.shop.service.exception.ServiceUserNotFoundException;

public interface UserService {

	boolean checkLogination(String login, String password) throws ServiceIncorrectPasswordException,
			ServiceIncorrectLoginException, ServiceUserNotFoundException, ServiceSqlErrorException;

	public User getUserById(int id) throws ServiceUserNotFoundException, ServiceSqlErrorException;

	public User getUserByLogin(String login, String password) throws ServiceUserNotFoundException,
			ServiceSqlErrorException, ServiceIncorrectLoginException, ServiceIncorrectPasswordException;

	public ArrayList<User> getUsersList() throws ServiceUserNotFoundException, ServiceSqlErrorException;

	boolean addUser(User user) throws ServiceUserNotFoundException, ServiceIncorrectLoginException,
			ServiceIncorrectPasswordException, ServiceIncorrectPhoneException, ServiceIncorrectEmailException,
			ServiceLoginExistException, ServiceSqlErrorException;

}
