package by.htp.shop.dao.factory;

import by.htp.shop.dao.ShopDAO;
import by.htp.shop.dao.UserDAO;
import by.htp.shop.dao.impl.SQLShopDAO;
import by.htp.shop.dao.impl.SQLUserDAO;

public final class DAOFactory {

	private static final DAOFactory instance = new DAOFactory();

	private final UserDAO userDAOImpl = new SQLUserDAO();
	private final ShopDAO shopDAOImpl = new SQLShopDAO();

	private DAOFactory() {
	}

	public static DAOFactory getInstance() {
		return instance;
	}

	public UserDAO getUserDAO() {
		return userDAOImpl;
	}

	public ShopDAO getShopDAO() {
		return shopDAOImpl;
	}

}
