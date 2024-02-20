package com.Signup;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.ConnectionP;
import com.DAO.userDao;
import com.UserData.user;

@WebServlet("/register")
public class register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");

		String firstName = request.getParameter("fname");
		String lastName = request.getParameter("lname");
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		String pass1 = request.getParameter("password2");
		String gender = request.getParameter("gender");
		String check = request.getParameter("check");

		if (firstName != null && lastName != null && email != null && pass != null && pass1 != null && gender != null
				&& check != null) {

			if (pass.equals(pass1)) {

				user us = new user(firstName, lastName, email, pass, pass1, gender);

				userDao dao = null;
				try {
					dao = new userDao(ConnectionP.getConnection());
				} catch (Exception e) {

					e.printStackTrace();
				}
				if (dao.saveUser(us)) {
					request.setAttribute("okay", "User sign up successful.");

					RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
					rd.forward(request, response);
					return;

				} else {
					out.println();
					request.setAttribute("message", "Error occurred while saving user.");

					RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
					rd.forward(request, response);
					return;

				}
			} else {
				request.setAttribute("message", "Password didnot match");

				RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
				rd.forward(request, response);
				return;

			}
		} else {
			request.setAttribute("message", "ALL field are required");

			RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
			rd.forward(request, response);
			return;

		}
	}

}
