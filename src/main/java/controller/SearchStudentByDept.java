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
 * Servlet implementation class SearchStudentByDept
 */
@WebServlet("/SearchStudentByDept")
public class SearchStudentByDept extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchStudentByDept() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		String department = request.getParameter("department");
		
		List<StudentModel> students = new ArrayList<>();
		
		students = ServiceHelper.studentService.isSearchStudentByDept(department);
		
		request.setAttribute("deptStudent", students);
		request.getRequestDispatcher("StudentOperation.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
