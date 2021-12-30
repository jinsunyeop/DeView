<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<h1>로그인</h1>
	<form:form commandName="login" method="POST">	
		<h1>${msg1}</h1>
		<h1>${msg2}</h1>
		<table border="1">
				<tr>
					<th><form:label path="email">이메일</form:label></th>
					<td><form:input path="email"/><form:errors path="email"/></td>
					<th rowspan ="2"><form:label path="rememberEmail">이메일 기억하기</form:label></th>
					<td rowspan ="2"><form:checkbox path="rememberEmail"/></td>
				</tr>
				<tr>
					<th><form:label path="password">비밀번호</form:label></th>
					<td><form:password path="password"/><form:errors path="password"/></td>
				</tr>		

		</table>
		<div>
			<input type="submit" value="로그인">
			<button><a href="<c:url value="/books/list"/>">목록</a></button>
		</div>
	</form:form>

</body>
</html>