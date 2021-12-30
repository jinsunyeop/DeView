<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${empty sessionScope.user}">
	<h1>로그인 하실?</h1>
		<p><a href="<c:url value='/user/login'/>">[로그인]</a> </p>
		</c:if>
	<c:if test="${ not empty sessionScope.user}">
	<h1>너의 닉네임은 ${sessionScope.user.nickname }</h1>
	<a href="<c:url value="/user/profile/profile"/>">프로필 가기</a>
	</c:if>
</body>
</html>