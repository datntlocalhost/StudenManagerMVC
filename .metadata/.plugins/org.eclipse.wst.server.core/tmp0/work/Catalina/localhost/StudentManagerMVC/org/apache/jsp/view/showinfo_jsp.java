/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.90
 * Generated at: 2018-07-22 08:14:11 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.view;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import datnt.runsystem.com.model.SubjectModel;
import java.util.ArrayList;
import datnt.runsystem.com.dto.SubjectDTO;
import datnt.runsystem.com.model.StudentModel;
import datnt.runsystem.com.dto.StudentDTO;
import java.sql.ResultSet;
import datnt.runsystem.com.dto.UserDTO;
import datnt.runsystem.com.utils.GetPath;
import datnt.runsystem.com.dto.UserDTO;
import datnt.runsystem.com.utils.GetPath;

public final class showinfo_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/view/footer.jsp", Long.valueOf(1532070514000L));
    _jspx_dependants.put("/view/header.jsp", Long.valueOf(1532247231000L));
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("  <title>Thông tin sinh viên</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/main.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("  ");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("  <title>Insert title here</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/main.css\">\n");
      out.write("  \n");
      out.write("  ");
 
    UserDTO userDTO = (UserDTO) session.getAttribute("user");
    
    boolean isLoggedIn = (userDTO != null);
    
    String user = "Hi, Guest";
    
    if (isLoggedIn) {
    	user = userDTO.getUsername();
    }
  
      out.write("\n");
      out.write("  \n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write(" <div id=\"header\">\n");
      out.write("   <div class=\"uit-icon\">\n");
      out.write("     <img alt=\"uit-icon\" src=\"");
      out.print(request.getContextPath());
      out.write("/imgs/logo-uit.png\">\n");
      out.write("   </div>\n");
      out.write("   ");
 if (isLoggedIn) {
      out.write("\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath());
      out.write("/ctl/login\" method=\"get\">\n");
      out.write("          <input type=\"hidden\" name=\"operation\" value=\"logout\">\n");
      out.write("          <button class=\"login-btn\" type=\"submit\" name=\"logout\" >Logout</button>\n");
      out.write("        </form> \n");
      out.write("                \n");
      out.write("        <span class=\"welcome\">");
      out.print(user);
      out.write("</span>\n");
      out.write("        \n");
      out.write("        ");
 if (userDTO.getPermission() == 0) {
      out.write("\n");
      out.write("          <ul class=\"menu\">\n");
      out.write("             <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/view/showinfo.jsp\">Xem thông tin</a></li>\n");
      out.write("             <li><a href=\"");
      out.print(GetPath.UPDATE_INFO_VIEW);
      out.write("\">Cập nhật lý lịch</a></li>\n");
      out.write("             <li><a href=\"\">Đăng ký môn học</a></li>\n");
      out.write("          </ul> \n");
      out.write("        ");
} else {
      out.write("\n");
      out.write("          <ul class=\"menu\">\n");
      out.write("             <li><a href=\"");
      out.print(request.getContextPath() );
      out.write("/view/showinfo.jsp\">Xem thông tin</a></li>\n");
      out.write("             <li><a href=\"\">Thêm sinh viên</a></li>\n");
      out.write("             <li><a href=\"\">Cập nhật điểm</a></li>\n");
      out.write("             <li><a href=\"\"></a></li>\n");
      out.write("          </ul>\n");
      out.write("        ");
}
      out.write("\n");
      out.write("        \n");
      out.write("   ");
} else {
      out.write("\n");
      out.write("        <form action=\"");
      out.print(request.getContextPath());
      out.write("/ctl/login\" method=\"get\">\n");
      out.write("          <input type=\"hidden\" name=\"operation\" value=\"login\">\n");
      out.write("          <button class=\"login-btn\" type=\"submit\" name=\"login\" >Login</button>\n");
      out.write("        </form> \n");
      out.write("        <span class=\"welcome\">");
      out.print(user);
      out.write("</span>\n");
      out.write("   ");
}
      out.write("\n");
      out.write(" </div>\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("  \n");
      out.write("  ");
 
     StudentDTO student = null;
     ArrayList<SubjectDTO> subjects = null;
     if (userDTO != null) {
    	 student = StudentModel.getInstance().getStudentInfo(userDTO.getUsername());
    	 subjects = SubjectModel.getInstance().getSubject(userDTO.getUsername());
     }
  
      out.write("\n");
      out.write("  \n");
      out.write("  <div class=\"login-bg\">\n");
      out.write("    <div class=\"layer\">\n");
      out.write("          <table class=\"table-info\">\n");
      out.write("            <tr>\n");
      out.write("              <td class=\"td-1\">Họ tên:</td>\n");
      out.write("              <td class=\"td-2\">");
      out.print(student.getName() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td class=\"td-1\">Khoa:</td>\n");
      out.write("              <td class=\"td-2\">");
      out.print(student.getFaculty() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td class=\"td-1\">Ngày sinh:</td>\n");
      out.write("              <td class=\"td-2\">");
      out.print(student.getBirthday() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td class=\"td-1\">Địa chỉ:</td>\n");
      out.write("              <td class=\"td-2\">");
      out.print(student.getAddress() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td class=\"td-1\">Số điện thoại:</td>\n");
      out.write("              <td class=\"td-2\">");
      out.print(student.getPhone() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("              <td class=\"td-1\">Email:</td>\n");
      out.write("              <td class=\"td-2\">");
      out.print(student.getEmail() );
      out.write("</td>\n");
      out.write("            </tr>\n");
      out.write("          </table>\n");
      out.write("          \n");
      out.write("          ");
 if (subjects != null) {
      out.write("\n");
      out.write("             <table class=\"scores-table\">\n");
      out.write("               <tr>\n");
      out.write("                 <td>Mã môn học</td>\n");
      out.write("                 <td>Tên môn học</td>\n");
      out.write("                 <td>Năm học</td>\n");
      out.write("                 <td>Học kì</td>\n");
      out.write("                 <td>Điểm QT</td>\n");
      out.write("                 <td>Điểm TH</td>\n");
      out.write("                 <td>Điểm GK</td>\n");
      out.write("                 <td>Điểm CK</td>\n");
      out.write("               </tr>\n");
      out.write("             ");
 for (int i = subjects.size() - 1; i >= 0; i--) {
      out.write("\n");
      out.write("               <tr>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getIdSubject());
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getNameSubject() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getYear() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getSemester() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getQtScores() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getThScores() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getGkScores() );
      out.write("</td>\n");
      out.write("                 <td>");
      out.print(subjects.get(i).getCkScores() );
      out.write("</td>\n");
      out.write("               </tr>\n");
      out.write("             ");
} 
      out.write("\n");
      out.write("             </table>\n");
      out.write("          ");
} 
      out.write("\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("  ");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("  <meta charset=\"UTF-8\">\n");
      out.write("  <title>Insert title here</title>\n");
      out.write("  <link rel=\"stylesheet\" href=\"");
      out.print(request.getContextPath());
      out.write("/css/main.css\">\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("\n");
      out.write("  <div id=\"footer\">\n");
      out.write("    <div class=\"footer-1\"></div>\n");
      out.write("    <div class=\"footer-2\"></div>\n");
      out.write("  </div>\n");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
