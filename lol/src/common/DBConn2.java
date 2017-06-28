package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn2 {

	private static Connection con;

	public static Connection getCon() throws SQLException,ClassNotFoundException{
		if (con == null) {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/iot_test", "root", "egyd3195");
		}
		return con;
	}

	public static void closeCon() throws SQLException {
		if (con != null) {
			con.close();
			con = null;
		}
	}
}