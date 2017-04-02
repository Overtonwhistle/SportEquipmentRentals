package by.htp.shop.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import by.htp.shop.bean.User;
import by.htp.shop.dao.UserDAO;
import by.htp.shop.dao.exception.DAOException;
import by.htp.shop.dao.provider.SQLProvider;

public class SQLUserDAO implements UserDAO {

	final static String CONNECTION_STRING = "jdbc:mysql://127.0.0.1/sport_equipment_rental?useSSL=false";
	final static String SQL_NAME = "root";
	final static String SQL_PASSWORD = "root";

	SQLProvider provider = SQLProvider.getInstance();

	@Override
	public boolean addUser(User user) throws DAOException {

		String name = user.getName();
		String surname = user.getSurname();
//		String address = user.getAddress();
		
		String address;
		address = user.getAddress().equals("") ? null: user.getAddress();
				
//		address = address.equals("")? address==null: address="sds";
		String phone;
		phone = user.getPhone().equals("") ? null: user.getPhone();
		
		String email;
		email = user.getEmail().equals("") ? null: user.getEmail();
		
		String login = user.getLogin();
		String password = user.getPassword();
		String role = user.getRole();

		String request = "INSERT INTO users (id, role, name, surname, address, phone, email, login, password) VALUES (NULL, '"
				+ role + "', '" + name + "', '" + surname + "','" + address + "','" + phone + "', '" + email + "', '"
				+ login + "', '" + password + "')";
		System.out.println("INSERTing req SQL=" + request);

		// ResultSet rs = provider.getResultSet(request);
		// System.out.println("result set=" + rs);
		provider.insertSQL(request);
		return true;
	}

	@Override
	public boolean deleteUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean editUser(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<User> getUsersList() throws DAOException {
		ArrayList<User> users = new ArrayList<>();
		ResultSet rs = provider.getResultSet("select * from users");

		try {
			while (rs.next()) {
				// User user = new User();

				// System.out.println(rs.getInt(1) + " " + rs.getString(2) + " "
				// + rs.getString(3) + " " + rs.getString(4)
				// + " " + rs.getString(5) + " " + rs.getString(6) + " " +
				// rs.getString(7) + " " + rs.getString(8)
				// + " " + rs.getString(9));

				users.add(makeUser(rs));

			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("Error from getUsersList()");
		}

		return users;
	}

	@Override
	public User userLogin(String login, String password) throws DAOException {

		String request = "SELECT * FROM users WHERE login='" + login + "' AND password='" + password + "'";

		System.out.println("reqSQL=" + request);

		ResultSet rs = provider.getResultSet(request);

		try {
			if (!rs.next()) {
				System.out.println("checkLogin() - return NULL");
				return null;
			} else {
				System.out.println("checkLogin() - return USER");

				return makeUser(rs);
			}
		} catch (SQLException e) {
			throw new DAOException("SQL Exception in checkLogin()", e);
		}
	}

	@Override
	public User getUser(int id) throws DAOException {

		String request = "SELECT * FROM users WHERE id='" + id + "'";
		// System.out.println("reqSQL=" + request);
		ResultSet rs = provider.getResultSet(request);

		try {
			if (!rs.next()) {
				System.out.println("getUser() - return null");
				return null;
			}
		} catch (SQLException e1) {
			throw new DAOException("SQL Exception in getUser()", e1);
		}

		return makeUser(rs);
	}

	private User makeUser(ResultSet rs) throws DAOException {
		User user = new User();
		try {
			user.setId(rs.getInt(1));
			user.setRole(rs.getString(2));
			user.setName(rs.getString(3));
			user.setSurname(rs.getString(4));
			user.setAddress(rs.getString(5));
			user.setPhone(rs.getString(6));
			user.setEmail(rs.getString(7));
			user.setLogin(rs.getString(8));
			user.setPassword(rs.getString(9));
		} catch (SQLException e) {
			throw new DAOException("SQL Exception in getUser()", e);
		}

		return user;
	}

	@Override
	public boolean isLoginExist(String login) throws DAOException {
		String request = "SELECT * FROM users WHERE login='" + login + "'";
		System.out.println("reqSQL=" + request);
		ResultSet rs = provider.getResultSet(request);

		try {
			if (rs.next()) {
				System.out.println("return true");

				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DAOException("SQL Exception in isLoginExist()", e);
		}
		return false;
	};
}