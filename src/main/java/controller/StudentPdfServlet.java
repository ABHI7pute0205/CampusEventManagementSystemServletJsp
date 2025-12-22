package controller;

import pdf.StudentPdfDownload;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;

@WebServlet("/StudentPdfServlet")
public class StudentPdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

			Connection con = DriverManager.getConnection(
				"jdbc:mysql://localhost:3306/campuseventapp","root","admin");

			PreparedStatement psmt =
				con.prepareStatement("SELECT * FROM student");
			ResultSet rs = psmt.executeQuery();

			String path = System.getProperty("user.home")
				+ "\\Downloads\\students.pdf";

			StudentPdfDownload.generateStudentPdf(rs, path);
			
			response.sendRedirect("StudentOperation.jsp");
			

		} catch (Exception e) {
			System.out.println("Error is " + e);
		}
	}
}
