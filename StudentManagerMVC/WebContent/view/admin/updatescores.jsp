<%@page import="datnt.runsystem.com.dto.SubjectInfoDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
    <%@ include file="../header.jsp" %>
    
    <form action="<%=request.getContextPath() %>/ctl/updatescores" method="post">
    	<label>MSSV: </label>
    	<input type="text" name="idStudent" placeholder="Nhập MSSV">
    	
    	<label>Mã môn học: </label>
    	<input type="text" name="idSubject" placeholder="Nhập Mã môn học">
    	
    	<input type="hidden" name="type" value="getinfo">
    	<input type="submit" name="submit" value="Cập nhật">
    </form>
    
    <% SubjectInfoDTO subjectInfo = (SubjectInfoDTO) request.getAttribute("subjectinfo"); 
       String message = (String) request.getAttribute("message");
       
       if ("success".equalsIgnoreCase(message)) {
    	   out.print("<h2>Cập nhật thành công </h2>");
       }
    %>	
    	 <%if (subjectInfo != null) {%>
    		 <h2>Thông tin điểm hiện tại</h2>
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
               <tr>
                 <td><%=subjectInfo.getIdSubject()%></td>
                 <td><%=subjectInfo.getNameSubject() %></td>
                 <td><%=subjectInfo.getYear() %></td>
                 <td><%=subjectInfo.getSemester() %></td>
                 <td><%=subjectInfo.getQtScores() %></td>
                 <td><%=subjectInfo.getThScores() %></td>
                 <td><%=subjectInfo.getGkScores() %></td>
                 <td><%=subjectInfo.getCkScores() %></td>
               </tr>
        	</table>
        	
        	<form action="<%=request.getContextPath() %>/ctl/updatescores" method="post">
        	   <label>Điểm Quá trình: </label>
        	   <input type="text" name="qtscores">
        	   <br>
        	   <label>Điểm Thực hành: </label>
        	   <input type="text" name="thscores">
        	   <br>
        	   <label>Điểm Giữa kỳ: </label>
        	   <input type="text" name="gkscores">
        	   <br>
        	   <label>Điểm Cuối kỳ: </label>
        	   <input type="text" name="ckscores">
        	   <br>
        	   <input type="hidden" name="idStudent" value="<%=request.getAttribute("idstudent")%>">
        	   <input type="hidden" name="idSubject" value="<%=request.getAttribute("idsubject")%>">
        	   <input type="hidden" name="type" value="updatescores">
        	   <input type="submit" name="submit" value="Cập nhật">
        	</form>
     <%}%>
    
    <%@ include file="../footer.jsp" %>
</body>
</html>