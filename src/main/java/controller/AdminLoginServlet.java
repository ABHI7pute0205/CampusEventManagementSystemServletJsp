package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import Model.AdminLoginModel;
import helper.ServiceHelper;

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
	            HttpSession session = request.getSession();
	            session.setAttribute("adminUser", username);
	            
	            response.sendRedirect("AdminDashboard.jsp");
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
