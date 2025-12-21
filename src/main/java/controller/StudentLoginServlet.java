package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.StudentLoginServiceImpl;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import DBConfiguration.DBInitialize;
import Model.StudentModel;
import helper.ServiceHelper;

@WebServlet("/studentLogin")
public class StudentLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	
    	// this is values come from html form when user filled form 
    	String username = request.getParameter("username");
    	String password = request.getParameter("password");
    	
    	// set this values to model to verify details
    	StudentModel model = new StudentModel();
    	model.setEmail(username);
    	model.setPassword(password);
    	
    	boolean b = ServiceHelper.studentLogin.isValidateStudent(model);

    	if (b) {
    	    int studentId = ServiceHelper.studentLogin.getStudentId(username, password);
    	    
    	    // create new Objct of the session interface 
    	    HttpSession session = request.getSession();
    	    
    	    session.setAttribute("studentId", studentId);
    	    session.setAttribute("studentEmail", username);
    	    session.setAttribute("studentPassword", password);

    	    response.sendRedirect("StudentDashboard.jsp");

    	} else {
    	    request.getRequestDispatcher("login.html").forward(request, response);
    	}

    
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	request.getRequestDispatcher("login.html").forward(request, response);
       // response.sendRedirect("login.html");
    }

}
