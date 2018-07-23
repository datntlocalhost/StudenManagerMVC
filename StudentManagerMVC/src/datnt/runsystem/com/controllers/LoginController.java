package datnt.runsystem.com.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datnt.runsystem.com.dto.UserDTO;
import datnt.runsystem.com.model.UserModel;
import datnt.runsystem.com.utils.HashUtility;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public LoginController() {
        super();
    }

    /*
     * Thực thi request login và logout 
     * 
     * @param request
     * @param response
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		String      operation = request.getParameter("operation");
		HttpSession session   = request.getSession();
		
		if (session.getAttribute("user") != null) {
			if (operation.equalsIgnoreCase("logout")) {
				session.invalidate();
				response.sendRedirect(request.getContextPath() + "/view/home.jsp");
				return;
			}
		} else {
			if (operation.equalsIgnoreCase("login")) {
				response.sendRedirect(request.getContextPath() + "/view/login.jsp");
			}
		}
	}

	/*
	 * Nhận request login từ user, kiểm tra hợp lệ và set session.
	 * 
	 * @param request 
	 * @param response 
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = HashUtility.hash(request.getParameter("password"));
		HttpSession session = request.getSession();
		
		UserDTO userDTO = UserModel.getInstance().getUser(username, password);
		
		//Nếu tài khoản tồn tại hoặc hợp lệ 
		if (userDTO != null) {
			UserDTO userSession = (UserDTO) session.getAttribute("user");
			//set user session nếu chưa có
			if (userSession == null) {
				session.setAttribute("user", userDTO);
				session.setMaxInactiveInterval(15*60);
			}
			//chuyển hướng đến trang home
			response.sendRedirect(request.getContextPath() + "/view/home.jsp");
		} else { //Tài khoản ko tồn tại hoặc không hợp lệ
			response.sendRedirect(request.getContextPath() + "/view/login.jsp");
		}
	}

}
