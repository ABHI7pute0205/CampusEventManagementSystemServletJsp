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

@WebServlet("/EventCapaciyDetailsServlet")
public class EventCapaciyDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EventCapaciyDetailsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int eventId = Integer.parseInt(request.getParameter("eid"));
		
		EventModel eventDetails = ServiceHelper.eventRegService.getEventCapacityDetails(eventId);
		
		request.setAttribute("eventCapacity", eventDetails);
		
		request.getRequestDispatcher("StudentEventReg.jsp")
	       .forward(request, response);
	}	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
