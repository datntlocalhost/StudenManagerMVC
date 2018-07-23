<%@page import="java.util.ArrayList"%>
<%@page import="datnt.runsystem.com.dto.SubjectInfoDTO"%>
<%@page import="datnt.runsystem.com.dto.StudentDTO"%>
<%@page import="datnt.runsystem.com.model.StudentModel"%>
<%@page import="datnt.runsystem.com.model.SubjectModel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Xem thong tin sinh vien</title>
</head>
<body>
	<%@ include file="../header.jsp" %>
  	
  	<form action="<%=request.getContextPath() %>/ctl/studentinfo" method="post">
    	<label>Mã số sinh viên:</label>
    	<input type="text" name="idStudent" placeholder="Nhập MSSV">
    	<input type="submit" name="submit" value="Xem">
  	</form>
  	
  	<%
 		String idStudent = request.getParameter("idStudent");
  		StudentDTO student = null;
  		ArrayList<SubjectInfoDTO> subjects = null;
  	
  		if (idStudent != null) {
  			student  = StudentModel.getInstance().getStudentInfo(idStudent);
  			subjects = SubjectModel.getInstance().getSubjectInfo(idStudent);
  		} 
  	%>	
  	
  	<div class="login-bg">
    	<div class="layer">
    		<% if (student != null) {%>
    			<table class="table-info">
           			<tr>
              			<td class="td-1">Họ tên:</td>
              			<td class="td-2"><%=student.getName() %></td>
            		</tr>
            		<tr>
              			<td class="td-1">Khoa:</td>
              			<td class="td-2"><%=student.getFaculty() %></td>
            		</tr>
            		<tr>
              			<td class="td-1">Ngày sinh:</td>
              			<td class="td-2"><%=student.getBirthday() %></td>
            		</tr>
            		<tr>
              			<td class="td-1">Địa chỉ:</td>
              			<td class="td-2"><%=student.getAddress() %></td>
            		</tr>
            		<tr>
              			<td class="td-1">Số điện thoại:</td>
              			<td class="td-2"><%=student.getPhone() %></td>
            		</tr>
            		<tr>
              			<td class="td-1">Email:</td>
              			<td class="td-2"><%=student.getEmail() %></td>
            		</tr>
          		</table>
    		<%}%>
    		
    		<% if (subjects != null) {%>
    			<table class="scores-table">
               		<tr>
                 		<td>Mã môn học</td>
                 		<td>Tên môn học</td>
                 		<td>Năm học</td>
                 		<td>Học kì</td>
                 		<td>Điểm QT</td>
                 		<td>Điểm TH</td>
                 		<td>Điểm GK</td>
                 		<td>Điểm CK</td>
               		</tr>
             	<% for (int i = subjects.size() - 1; i >= 0; i--) {%>
               		<tr>
                 		<td><%=subjects.get(i).getIdSubject()%></td>
                 		<td><%=subjects.get(i).getNameSubject() %></td>
                 		<td><%=subjects.get(i).getYear() %></td>
                 		<td><%=subjects.get(i).getSemester() %></td>
                 		<td><%=subjects.get(i).getQtScores() %></td>
                 		<td><%=subjects.get(i).getThScores() %></td>
                 		<td><%=subjects.get(i).getGkScores() %></td>
                 		<td><%=subjects.get(i).getCkScores() %></td>
               		</tr>
             	<%} %>
             	</table>
    		<%}%>
    	</div>
    </div>	
  	  
  	<%@ include file="../footer.jsp" %>
</body>
</html>