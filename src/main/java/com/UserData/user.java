package com.UserData;

import java.sql.*;

public class user {
	private int id;
	private String Fname;
	private String Lname;
	private String Email;
	private String Pass;
	private String rePass;
	private String gender;
	private Timestamp Tim;

	public user(int id, String fname, String lname, String email, String pass, String rePass, String gender,
			Timestamp tim) {

		this.id = id;
		Fname = fname;
		Lname = lname;
		Email = email;
		Pass = pass;
		this.rePass = rePass;
		this.gender = gender;
		Tim = tim;

	}

	public user(String fname, String lname, String email, String pass, String rePass, String gender) {

		Fname = fname;
		Lname = lname;
		Email = email;
		Pass = pass;
		this.rePass = rePass;
		this.gender = gender;

	}

	public user() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFname() {
		return Fname;
	}

	public void setFname(String fname) {
		Fname = fname;
	}

	public String getLname() {
		return Lname;
	}

	public void setLname(String lname) {
		Lname = lname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getPass() {
		return Pass;
	}

	public void setPass(String pass) {
		Pass = pass;
	}

	public String getRePass() {
		return rePass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Timestamp getTim() {
		return Tim;
	}

	public void setTim(Timestamp timestamp) {
		Tim = timestamp;
	}

}
