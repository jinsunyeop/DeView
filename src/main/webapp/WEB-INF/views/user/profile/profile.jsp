<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>프로필</title>
</head>
<body>

 	<c:if test="${profile.gitAdd == null && profile.imgName == null}">
	<h1>꾸미러가기</h1>
	<button><a href="${pageContext.request.contextPath}/user/profile/insert">꾸미러가기</a></button>
	</c:if>
	 <c:if test="${profile.gitAdd != null || profile.imgName != null}">
	<h1>profile.gitAdd</h1>
	<h1>profile.imgName</h1>
	</c:if>


</body>
</html>