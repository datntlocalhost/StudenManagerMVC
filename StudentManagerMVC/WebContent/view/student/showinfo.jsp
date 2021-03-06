<%@page import="datnt.runsystem.com.model.SubjectModel"%>
<%@page import="java.util.ArrayList"%>
<%@page import="datnt.runsystem.com.dto.SubjectInfoDTO"%>
<%@page import="datnt.runsystem.com.model.StudentModel"%>
<%@page import="datnt.runsystem.com.dto.StudentDTO"%>
<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="datnt.runsystem.com.dto.UserDTO" %>
<%@ page import="datnt.runsystem.com.utils.GetPath" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Thông tin sinh viên</title>
  <link rel="stylesheet" href="<%=request.getContextPath()%>/css/main.css">
</head>
<body>
  <%@ include file="../header.jsp" %>
  
  <% 
     StudentDTO student = null;
     ArrayList<SubjectInfoDTO> subjects = null;
     if (userDTO != null) {
    	 student = StudentModel.getInstance().getStudentInfo(userDTO.getUsername());
    	 subjects = SubjectModel.getInstance().getSubjectInfo(userDTO.getUsername());
     }
  %>
  
  <div class="login-bg">
    <div class="layer">
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
          <%} %>
    </div>
  </div>
  <%@ include file="../footer.jsp" %>
</body>
</html>