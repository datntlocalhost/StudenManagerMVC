<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="datnt.runsystem.com.dto.UserDTO" %>
<%@ page import="datnt.runsystem.com.utils.GetPath" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
  
  <% 
    UserDTO userDTO = (UserDTO) session.getAttribute("user");
    
    boolean isLoggedIn = (userDTO != null);
    
    String user = "Hi, Guest";
    
    if (isLoggedIn) {
    	user = userDTO.getUsername();
    }
  %>
  
</head>
<body>

 <div id="header">
   <div class="uit-icon">
     <img alt="uit-icon" src="<%=request.getContextPath()%>/imgs/logo-uit.png">
   </div>
   <% if (isLoggedIn) {%>
        <form action="<%=request.getContextPath()%>/LoginController" method="get">
          <input type="hidden" name="operation" value="logout">
          <button class="login-btn" type="submit" name="logout" >Logout</button>
        </form> 
                
        <span class="welcome"><%=user%></span>
        
        <% if (userDTO.getPermission() == 0) {%>
          <ul class="menu">
             <li><a href="<%=request.getContextPath() %>/view/showinfo.jsp">Xem thông tin</a></li>
             <li><a href="">Cập nhật lý lịch</a></li>
             <li><a href="">Đăng ký môn học</a></li>
          </ul> 
        <%} else {%>
          <ul class="menu">
             <li><a href="<%=request.getContextPath() %>/view/showinfo.jsp">Xem thông tin</a></li>
             <li><a href="">Thêm sinh viên</a></li>
             <li><a href="">Cập nhật điểm</a></li>
             <li><a href=""></a></li>
          </ul>
        <%}%>
        
   <%} else {%>
        <form action="<%=request.getContextPath()%>/LoginController" method="get">
          <input type="hidden" name="operation" value="login">
          <button class="login-btn" type="submit" name="login" >Login</button>
        </form> 
        <span class="welcome"><%=user%></span>
   <%}%>
 </div>
</body>
</html>