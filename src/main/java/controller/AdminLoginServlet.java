package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.AdminLoginModel;
import helper.ServiceHelper;

/**
 * Servlet implementation class AdminLoginServlet
 */
@WebServlet("/AdminLoginServlet")
 public class AdminLoginServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String username = request.getParameter("username");
	        String password = request.getParameter("password");

	        AdminLoginModel model = new AdminLoginModel();
	        model.setUsername(username);
	        model.setPassword(password);

	        boolean isValid = ServiceHelper.adminService.validateAdminLogin(model);

	        if (isValid) {
	        	// session
	            request.getRequestDispatcher("AdminDashboard.html")
	                   .forward(request, response);
	        } else {
	            request.getRequestDispatcher("AdminLogin.html")
	                   .forward(request, response);
	        }
	    }

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        request.getRequestDispatcher("AdminLogin.html")
	               .forward(request, response);
	    }
	}
