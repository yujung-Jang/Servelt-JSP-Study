<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<%

String cnt_ = request.getParameter("cnt");

int cnt = 100;
if(cnt_ != null && !cnt_.equals(""))
	cnt = Integer.parseInt(cnt_);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<%for(int i=0; i<cnt; i++){ %>
	 안녕 Servlet!!<br >
	<%} %>
</body>
</html>