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
 * Servlet implementation class ListAllEventsServlet
 */
@WebServlet("/ListAllEventsServlet")
public class ListAllEventsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListAllEventsServlet() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<EventModel> events = new ArrayList<>();
		
		events = ServiceHelper.eventService.getAllEvents();
		
		request.setAttribute("allEvents", events);
		request.getRequestDispatcher("StudentDashboard.jsp").forward(request, response);
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
