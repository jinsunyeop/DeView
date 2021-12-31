<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>비밀번호 바꾸기</title>
</head>
<body>
<form:form commandName = "changePw" method="POST">

<h1>${sessionScope.member.nickName }</h1>
<h2><form:errors/></h2>
	<label> 현재 비밀번호 <br>
	<form:password path="currentPassword"/>
	<form:errors path="currentPassword"/>
	</label>

<p>
	<label>새 비밀번호<br>
	<form:password path="newPassword"/>
	<form:errors path="newPassword"/>
	</label>
</p>
<input type="submit" value="바꾸기">
</form:form>
</body>
</html>