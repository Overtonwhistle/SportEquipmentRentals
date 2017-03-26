package by.htp.shop.dao;

import by.htp.shop.bean.SportEquipment;

public interface ShopDAO {

	boolean addEquipment(SportEquipment equipment);

	SportEquipment findEquipment(int idEquipment);
}
