package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.StudentModel;
import helper.ServiceHelper;

/**
 * Servlet implementation class ListAllStudent
 */
@WebServlet("/ListAllStudent")
public class ListAllStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListAllStudent() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		List<StudentModel> students = new ArrayList<>();
		
		students = ServiceHelper.studentService.viewAllStudents();
		
		request.setAttribute("allStudents", students);
		
		request.getRequestDispatcher("StudentOperation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
