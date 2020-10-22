<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>index.jsp</h1>
	<div>
		<span>${loginStaff.email}</span>관리자님
	</div>
	<div>
		<a href="${pageContext.request,contextPath} }/auth/logoutServlet">로그아웃</a>
	</div>
	<div>
		
	</div>
</body>
</html>