<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String userid = request.getParameter("userid").trim();
String username = request.getParameter("username");
String sex = request.getParameter("sex");
String phone = request.getParameter("phone");
String email = request.getParameter("email");
String address = request.getParameter("address");
String comment = request.getParameter("comment");
String isdelete = request.getParameter("isdelete");

System.out.print(userid+" "+sex+" "+isdelete);
%>
</body>
</html>