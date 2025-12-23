package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.StudentModel;
import helper.ServiceHelper;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int sid = Integer.parseInt(request.getParameter("studentId"));

		ServiceHelper helper = new ServiceHelper();
		StudentModel student = helper.studentService.getStudentById(sid);
		
		

		request.setAttribute("student", student);
		request.getRequestDispatcher("editStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
