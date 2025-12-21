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

@WebServlet("/SearchStudentByEmail")
public class SearchStudentByEmail extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SearchStudentByEmail() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String email = request.getParameter("email");

        List<StudentModel> al =
                ServiceHelper.studentService.isSearchStudentByEmail(email);

            request.setAttribute("studentList", al);
            
            request.getRequestDispatcher("StudentOperation.jsp")
                   .forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
