package com.test.common;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConn {
	private static Properties pro = new Properties();
	static{
		try{
			pro.load(PropertiesTest.class.getClassLoader().getResourceAsStream("db.properties"));
			System.out.println(pro.getProperty("db.driver"));
			}catch(IOException e){
				e.printStackTrace();
			}
	}
	private static Connection con;

	public static Connection getCon() throws ClassNotFoundException, SQLException {
		if (con == null) {
			Class.forName("org.mariadb.jdbc.Driver");
			con = DriverManager.getConnection(pro.getProperty("db.url"),pro.getProperty("db.id"),pro.getProperty("db.pwd"));
			con.setAutoCommit(false);
		}
		return con;
	}
	public static void closeCon() throws SQLException {
		System.out.println(con);
		if (con != null) {
			con.close();
			con = null;
		}
	}
}
