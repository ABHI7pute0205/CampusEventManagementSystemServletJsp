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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

// this method all student cha record at a  time gheun yete.

//		List<StudentModel> students = new ArrayList<>();
//		students = ServiceHelper.studentService.viewAllStudents();
//		request.setAttribute("allStudents", students);
//		request.getRequestDispatcher("StudentOperation.jsp").forward(request, response);


        int page = 1;
        int recordsPerPage = 5;

        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * recordsPerPage;

        // Fetch students for this page
        List<StudentModel> students = ServiceHelper.studentService.viewStudentsWithPagination(recordsPerPage, offset);

        // Total number of students
        int totalStudent = ServiceHelper.studentService.getTotalStudentCount();
        // 12 1-5 
        int totalPages = (int) Math.ceil((double) totalStudent / recordsPerPage);

        if (page > totalPages && totalPages != 0) {
            page = totalPages;
            offset = (page - 1) * recordsPerPage;
            students = ServiceHelper.studentService.viewStudentsWithPagination(recordsPerPage, offset);
        }

        request.setAttribute("allStudents", students);
        request.setAttribute("allcurrentPage", page);
        request.setAttribute("alltotalPages", totalPages);

        request.getRequestDispatcher("StudentOperation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
