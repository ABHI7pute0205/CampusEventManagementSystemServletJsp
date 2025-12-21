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

@WebServlet("/ListOfUpcomingEventServlet")
public class ListOfUpcomingEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ListOfUpcomingEventServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<EventModel> uEvent = new ArrayList<>();
		
		uEvent = ServiceHelper.eventService.getUpComingEvents();
		request.setAttribute("upcomingEvents", uEvent);
		
		request.getRequestDispatcher("StudentDashboard.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
