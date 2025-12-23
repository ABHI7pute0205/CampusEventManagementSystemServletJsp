package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdf.StudentPdfDownload;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/EventPdfServlet")
public class EventPdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/campuseventapp","root","admin");

			PreparedStatement psmt =
				con.prepareStatement("SELECT * FROM event");
			ResultSet rs = psmt.executeQuery();

			String path = System.getProperty("user.home")
				+ "\\Downloads\\events.pdf";

			StudentPdfDownload.generateEventPdf(rs, path);
			
			response.sendRedirect("EventOperationDashboard.jsp");
			

		} catch (Exception e) {
			System.out.println("Error is " + e);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
