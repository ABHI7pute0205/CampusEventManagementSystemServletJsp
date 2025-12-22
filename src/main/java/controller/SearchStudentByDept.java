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
		
//		String department = request.getParameter("department");
//		
//		List<StudentModel> students = new ArrayList<>();
//		
//		students = ServiceHelper.studentService.isSearchStudentByDept(department);
//		
//		request.setAttribute("deptStudent", students);
//		request.getRequestDispatcher("StudentOperation.jsp").forward(request, response);
		
		String department = request.getParameter("department");
		
		int page =1;
		int recordsPerPage=5;
		
        if (request.getParameter("page") != null) {
            page = Integer.parseInt(request.getParameter("page"));
        }

        int offset = (page - 1) * recordsPerPage;
        
        List<StudentModel> students = new ArrayList<>();
        students = ServiceHelper.studentService.isSearchStudentByDept(department, recordsPerPage, offset);
        
        int totalStudents = ServiceHelper.studentService.getStudentCountByDept(department);
        
        int totalPages =
                (int) Math.ceil((double) totalStudents / recordsPerPage);
        
        if (page > totalPages && totalPages != 0) {
            page = totalPages;
            offset = (page - 1) * recordsPerPage;

            students = ServiceHelper.studentService
                    .isSearchStudentByDept(department, recordsPerPage, offset);  // ✅

        }

        request.setAttribute("deptStudent", students);
        request.setAttribute("currentPage", page);
        request.setAttribute("totalPages", totalPages);
        request.setAttribute("department", department);
        
        request.getRequestDispatcher("StudentOperation.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
