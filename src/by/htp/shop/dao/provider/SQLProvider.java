package by.htp.shop.dao.provider;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.shop.dao.exception.DAOException;

public final class SQLProvider {

	private static final String CONNECTION_STRING = "jdbc:mysql://127.0.0.1/sport_equipment_rental?useSSL=false";
	private static final String SQL_NAME = "root";
	private static final String SQL_PASSWORD = "root";
	private static final String DRIVER = "org.gjt.mm.mysql.Driver";

	private static final SQLProvider instance = new SQLProvider();

	public static SQLProvider getInstance() {
		return instance;
	}

	public ResultSet getResultSet(String query) throws DAOException {
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(CONNECTION_STRING, SQL_NAME, SQL_PASSWORD);
			st = con.createStatement();
			rs = st.executeQuery(query);
		} catch (SQLException | ClassNotFoundException e1) {
			throw new DAOException("SQL or Class not found Exception in getResultSet()", e1);
		}
		return rs;

	}

	public boolean insertSQL(String query) throws DAOException {
		Connection con = null;
		Statement st = null;
		{
				try {
					Class.forName(DRIVER);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					con = DriverManager.getConnection(CONNECTION_STRING, SQL_NAME, SQL_PASSWORD);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					st = con.createStatement();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					st.executeUpdate(query);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
		}

		return true;

	}

}
