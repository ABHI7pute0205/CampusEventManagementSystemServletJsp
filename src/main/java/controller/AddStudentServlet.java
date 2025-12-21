package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Model.StudentModel;
import helper.ServiceHelper;

@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sname = request.getParameter("sname");
        String email = request.getParameter("email");
        String department = request.getParameter("department");
        String contact = request.getParameter("mobile");
        String password = request.getParameter("password");

        StudentModel model = new StudentModel();
        model.setSname(sname);
        model.setEmail(email);
        model.setDept(department);
        model.setContact(contact);
        model.setPassword(password);

        boolean res = ServiceHelper.studentService.isAddStudent(model);

        if (res) {
            response.sendRedirect("StudentOperation.jsp?status=success");
        } else {
            response.sendRedirect("StudentOperation.jsp?status=error");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
