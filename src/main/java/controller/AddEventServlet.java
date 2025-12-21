package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;

import Model.EventModel;
import helper.ServiceHelper;
import java.text.SimpleDateFormat;

@WebServlet("/AddEventServlet")
public class AddEventServlet extends HttpServlet {

    public AddEventServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		 	String name = request.getParameter("name");
	        String d = request.getParameter("date");
	        String venue = request.getParameter("location");
	        int capacity = Integer.parseInt(request.getParameter("capacity"));
	        
	        Date date = Date.valueOf(d);
	        
	        EventModel e=new EventModel();
	        
	        e.setName(name);
	        e.setEdate(date);
	        e.setVenue(venue);
	        e.setCapacity(capacity);

	        boolean b = ServiceHelper.eventService.isAddEvent(e);
	        
	        if (b) {
	            response.sendRedirect("EventOperationDashboard.jsp?status=success");
	        } else {
	            response.sendRedirect("EventOperationDashboard.jsp?status=error");
	        }
		
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
