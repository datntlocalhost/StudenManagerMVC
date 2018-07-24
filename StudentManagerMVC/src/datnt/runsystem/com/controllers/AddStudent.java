/*
 * Class AddStudent
 * 
 * Controller cho page /admin/addstudent.jsp
 */
package datnt.runsystem.com.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import datnt.runsystem.com.model.AddStudentModel;
import datnt.runsystem.com.utils.GetPath;
import datnt.runsystem.com.utils.HashUtility;
import datnt.runsystem.com.utils.StringValidator;

public class AddStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddStudent() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher(GetPath.ADD_STUDENT_VIEW);
		rd.forward(request, response);
	}

	/*
	 * Nhận thông tin sinh viên từ request user gửi đến sau đó 
	 * xử lý thêm mới sinh viên vào database và gửi response 
	 * đến user để hiển thị kết quả 
	 * 
	 * @param request 
	 * @param response
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idStudent    = request.getParameter("idStudent");
		String birthday     = request.getParameter("birthday");
		String studentName  = request.getParameter("studentName");
		String idFaculty    = request.getParameter("idFaculty");
		String password     = HashUtility.hash(request.getParameter("password"));
		
		if (!StringValidator.isUsername(idStudent) || !StringValidator.isName(studentName)) {
			response.sendRedirect("addstudent");
		}
		
		if (AddStudentModel.getInstance().addStudent(idStudent, idFaculty, studentName)) {  //Thêm vào database SINHVIEN 
			if (AddStudentModel.getInstance().addAccount(idStudent, password)) {            //Thêm vào database TAIKHOAN 
				if (AddStudentModel.getInstance().addInfo(idStudent, birthday)) {           //Thêm vào database LYLICH   
					response.sendRedirect("addstudent?message=success");                 
				}
			}
		} else {
			response.sendRedirect("addstudent?message=failed");
		}
	}

}
