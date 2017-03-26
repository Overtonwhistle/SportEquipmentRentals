package by.htp.shop.service.factory;

import by.htp.shop.service.ShopService;
import by.htp.shop.service.UserService;
import by.htp.shop.service.impl.ShopServiceImpl;
import by.htp.shop.service.impl.UserServiceImpl;

public class ServiceFactory {
	private static final ServiceFactory instance = new ServiceFactory();

	private final UserService userServiceImpl = new UserServiceImpl();
	private final ShopService shopServiceImpl = new ShopServiceImpl();


	public static ServiceFactory getInstance() {
		return instance;
	}

	public UserService getUserSevice() {
		return userServiceImpl;
	}

	public ShopService getShopService() {
		return shopServiceImpl;
	}

}
