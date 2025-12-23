package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pdfdownload.StudentPdfDownload;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/RegisteredStudentPdfServlet")
public class RegisteredStudentPdfServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

//		try {
//
//			Class.forName("com.mysql.cj.jdbc.Driver");
//
//			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/campuseventapp", "root", "admin");
//
//			PreparedStatement psmt = con.prepareStatement("select s.sid , s.sname , s.email , s.contact , s.dept "
//					+ "from student s " + "join registration r on r.sid = s.sid " + "join event e on e.eid = r.eid "
//					+ "where e.eid = ?" // ← use event ID
//			);
//
//			//psmt.setInt(1, eventId);
//
//			ResultSet rs = psmt.executeQuery();
//
//			String path = System.getProperty("user.home") + "\\Downloads\\studentEventRegister.pdf";
//
//			//StudentPdfDownload.generateregisteredStudentEventPdf(rs, path);
//
//			System.out.println("PDF Download Successfully: " + path);
//
//		} catch (Exception e) {
//			System.out.println("Error is " + e);
//		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
