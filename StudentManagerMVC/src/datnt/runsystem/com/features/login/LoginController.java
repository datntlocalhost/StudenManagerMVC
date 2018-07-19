package datnt.runsystem.com.features.login;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datnt.runsystem.com.dao.AccountDAO;
import datnt.runsystem.com.model.AccountModel;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public LoginController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("/view/login.jsp");
		requestDispatcher.forward(request, response);
	}

	/*
	 * Hàm nhận request từ trang đăng nhập,sau đó kiểm tra thông tin username, password,
	 * nếu chính xác (có trong database) thì chuyển hướng đến trang home, sai thì hiển 
	 * thị đăng nhập thất bại.
	 * 
	 * @param request từ trang login
	 * @param response đến user 
	 * 
	 * @throws ServletException, IOException
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		AccountModel accountModel = AccountDAO.getInstance().getAccount(username, password);
		HttpSession session = request.getSession();
		
		if (accountModel != null) {
			//Chuyển hướng đến trang home
			
			//them session
			session.setAttribute(accountModel.getUsername(), accountModel);
		} else {
			//Hiển thị đăng nhập thất bại 
			response.sendRedirect(this.getServletContext().getContextPath() + "/view/login.jsp");	
		}
	}
}
