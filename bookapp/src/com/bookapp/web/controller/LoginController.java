package com.bookapp.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookapp.model.dao.user.User;
import com.bookapp.model.exceptions.UserNotFoundException;
import com.bookapp.model.service.UserService;
import com.bookapp.model.service.UserServiceImpl;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	private UserService userService=new UserServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		try {
			User user = userService.getUser(username, password);
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", user);
			response.sendRedirect("BookController.do?action=showall");
			
		} catch (UserNotFoundException ex) {
			response.sendRedirect("login.jsp?message=login failed");
		}
	}

}
