package datnt.runsystem.com.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class StudentInfo
 */
public class StudentInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentInfo() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("/view/admin/studentinfo.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStudent = request.getParameter("idStudent");
		if (idStudent != null) {
			response.sendRedirect("studentinfo?idStudent=" + idStudent);
		}
	}

}
