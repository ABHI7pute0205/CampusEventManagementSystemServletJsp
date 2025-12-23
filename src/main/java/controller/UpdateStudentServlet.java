package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.StudentModel;
import helper.ServiceHelper;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		StudentModel model = new StudentModel();
		model.setSid(Integer.parseInt(request.getParameter("sid")));
		model.setSname(request.getParameter("sname"));
		model.setEmail(request.getParameter("email"));
		model.setContact(request.getParameter("contact"));
		model.setPassword(request.getParameter("password"));
		model.setDept(request.getParameter("dept"));

		ServiceHelper helper = new ServiceHelper();
		StudentModel updated = helper.studentService.isUpdateStudent(model);
		
		if (updated != null) {
			response.sendRedirect("ListAllStudent");
		} else {
			response.getWriter().println("Update Failed");
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
