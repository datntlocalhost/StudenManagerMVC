package datnt.runsystem.com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import datnt.runsystem.com.dto.UserDTO;
import datnt.runsystem.com.utils.GetPath;

public class AdminPageFilter implements Filter {

    public AdminPageFilter() {}

	public void destroy() {}

	/*
	 * Lọc các lượt truy cập vào các page của admin 
	 * 
	 * @param request 
	 * @param response 
	 * @param chain
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		HttpSession session = req.getSession();
		UserDTO user = (UserDTO) session.getAttribute("user");
		String[] uri = req.getRequestURI().split("/");
		
		//neu user chua login
		if (user == null) {
			//chuyen sang trang login
			RequestDispatcher rd = req.getRequestDispatcher(GetPath.LOGIN_VIEW);
			rd.forward(req, res);
			return;
		}
		
		//neu user co permission = 1 va truy cap vao cac trang trong admin
		if (uri[uri.length - 2].equalsIgnoreCase("admin") && user.getPermission() == 1) {
			chain.doFilter(request, response); //cho phep truy cap
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
