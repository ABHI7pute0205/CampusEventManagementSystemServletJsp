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
 * Servlet implementation class EventWieseStudentRegServlet
 */
@WebServlet("/EventWieseStudentRegServlet")
public class EventWieseStudentRegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventWieseStudentRegServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		int eventId = Integer.parseInt(request.getParameter("eid"));
		
		String eventName = request.getParameter("eventName");
		List<StudentModel> studentList = new ArrayList<>();
		
		studentList = ServiceHelper.eventRegService.viewEventWiseStudentRegistrations(eventName);
	
		request.setAttribute("studEventReg", studentList);
		
		request.getRequestDispatcher("StudentEventReg.jsp").forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
