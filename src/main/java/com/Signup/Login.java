package com.Signup;

import java.io.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.DAO.ConnectionP;
import com.DAO.userDao;
import com.UserData.user;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		String uname = request.getParameter("email");
		String upass = request.getParameter("password");

		try {

			userDao ud = new userDao(ConnectionP.getConnection());

			if (!ud.isUserRegistered(uname)) {
				request.setAttribute("message", "User with this email  is not registered");
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
				return;
			}

			else {

				user u = ud.validateUser(uname, upass);
				if (u == null) {
					request.setAttribute("message", "Email or password didnot match");
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
					return;

				} else {
					HttpSession s = request.getSession();
					s.setAttribute("user", u);
					response.sendRedirect("success.jsp");

				}

			}
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

}
