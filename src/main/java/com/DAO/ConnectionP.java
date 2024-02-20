package com.DAO;

import java.sql.*;

public class ConnectionP {
	private static Connection con;

	public static Connection getConnection() throws Exception {
		final String uname = "root";
		final String upass = "Yunish@2059";
		final String url = "jdbc:mysql://localhost:3306/Register";

		if (con == null) {

			Class.forName("com.mysql.cj.jdbc.Driver");

			con = DriverManager.getConnection(url, uname, upass);

		}

		return con;

	}

}
