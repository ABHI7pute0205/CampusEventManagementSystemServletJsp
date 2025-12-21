package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Model.EventModel;
import helper.ServiceHelper;

@WebServlet("/StudentWiseEventRegServlet")
public class StudentWiseEventRegServlet extends HttpServlet {
	//private static final long serialVersionUID = 1L;

    public StudentWiseEventRegServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int studentId = Integer.parseInt(request.getParameter("sid"));

		//String studName = request.getParameter("sname");
		List<EventModel> eventList = new ArrayList<>();
				
		eventList = ServiceHelper.eventRegService.viewStudentWiseEventRegistrations(studentId);

		request.setAttribute("studRegForEvent", eventList);
		request.setAttribute("sid", studentId);
		
		request.getRequestDispatcher("StudentEventReg.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
