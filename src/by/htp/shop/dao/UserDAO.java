package by.htp.shop.dao;

import java.util.ArrayList;
import by.htp.shop.bean.User;
import by.htp.shop.dao.exception.DAOException;

public interface UserDAO {
	
	public User userLogin(String login, String password) throws DAOException;

	public boolean addUser(User user) throws DAOException;
	
	public boolean deleteUser (int id);

	public boolean editUser (int id);
	
	public ArrayList<User> getUsersList() throws DAOException;
	
	public User getUser (int id) throws DAOException;
	
	boolean isLoginExist (String login) throws DAOException;

	
}
