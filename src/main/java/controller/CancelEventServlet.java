package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import helper.ServiceHelper;

@WebServlet("/CancelEventServlet")
public class CancelEventServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public CancelEventServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			//response.getWriter().append("Served at: ").append(request.getContextPath());
		/* ================= SESSION ================= */
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("studentId") == null) {
			response.sendRedirect("login.html");
			return;
		}

		int studentId = (int) session.getAttribute("studentId");

		/* ================= EVENT ID ================= */
		int eventId = Integer.parseInt(request.getParameter("eventId"));

		/* ================= CANCEL REGISTRATION ================= */
		boolean status = ServiceHelper.eventService
				.cancelEventRegistration(studentId, eventId);

		if (status) {
			response.sendRedirect("StudentDashboard.jsp?view=upcoming&msg=cancel");
		} else {
			response.sendRedirect("StudentDashboard.jsp?view=upcoming&msg=error");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
