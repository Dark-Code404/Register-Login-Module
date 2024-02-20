package com.DAO;

import java.sql.*;

import com.UserData.user;

public class userDao {

	private Connection con;

	public userDao(Connection con) {
		this.con = con;

	}

	public boolean saveUser(user user) {
		boolean f = false;

		try {

			String q = "insert into user (first_name,last_name,email,password,gender) values(?,?,?,?,?)";
			PreparedStatement p = this.con.prepareStatement(q);
			p.setString(1, user.getFname());
			p.setString(2, user.getLname());
			p.setString(3, user.getEmail());
			p.setString(4, user.getPass());
			p.setString(5, user.getGender());

			int i = p.executeUpdate();
			if (i > 0)
				f = true;

		} catch (Exception e) {

			e.printStackTrace();

		}
		return f;

	}

	public user validateUser(String email, String password) {
		user usr = null;
		try {
			String query = "SELECT * FROM user WHERE email=? AND password=?";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, password);

			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				usr = new user();
				usr.setFname(rs.getString("first_name"));
				usr.setLname(rs.getString("last_name"));
				usr.setId(rs.getInt("Id"));
				usr.setEmail(rs.getString("email"));
				usr.setGender(rs.getString("gender"));
				usr.setTim(rs.getTimestamp("date"));

			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		return usr;
	}

	public boolean isUserRegistered(String email) {
		try {
			String query = "SELECT * FROM user WHERE email=? ";
			PreparedStatement stmt = con.prepareStatement(query);
			stmt.setString(1, email);

			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
