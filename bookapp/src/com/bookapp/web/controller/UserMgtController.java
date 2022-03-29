package com.bookapp.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookapp.model.dao.user.User;
import com.bookapp.model.service.UserService;
import com.bookapp.model.service.UserServiceImpl;


@WebServlet("/UserMgtController.do")
public class UserMgtController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserService userService=new UserServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("adduser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String profile=request.getParameter("profile");
		User user=new User(username, password, profile);
		userService.addUser(user);
		response.sendRedirect("BookController.do?action=showall");
	}
}
