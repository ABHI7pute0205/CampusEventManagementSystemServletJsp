package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import helper.ServiceHelper;

@WebServlet("/ApplyForEventServlet")
public class ApplyForEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ApplyForEventServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	
		// eith he session false kel mhanje aadhe cha jo session cha object create zale la 
		// ye tya ch session chya object la ha reference point kar to 
		// .getSession(true) -> pass kelya var ti ch new Session cha object create hoto 
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("studentId") == null) {
			response.sendRedirect("login.html");
			return;
		}

		int studentId = (int) session.getAttribute("studentId");
		int eventId = Integer.parseInt(request.getParameter("eventId"));
		
		boolean status = ServiceHelper.eventService.registerStudentForEvent(studentId, eventId);
		

		if (status) {
			response.sendRedirect("StudentDashboard.jsp?view=upcoming&msg=success");
		} else {
			response.sendRedirect("StudentDashboard.jsp?view=upcoming&msg=error");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
