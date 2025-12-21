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

/**
 * Servlet implementation class UpcomingEventsServle
 */
@WebServlet("/UpcomingEventsServlet")
public class UpcomingEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public UpcomingEventsServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		//EventModel upComingEvent = new EventModel();
	
		List<EventModel> upComingEvents = new ArrayList<>();
		
		upComingEvents = ServiceHelper.eventService.getUpComingEvents();
		
		request.setAttribute("upComingE", upComingEvents);
		request.getRequestDispatcher("EventOperationDashboard.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
