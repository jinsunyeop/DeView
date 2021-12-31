<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<script type="text/javascript"> <!--이미지 미리보기 자바스크립트-->

</script>
<meta charset="UTF-8">
<title>프로필 작성</title>
</head>
<body>
	<h2>${sessionScope.user.name} 님의 프로필을 작성한다.</h2>
	<form:errors/>
	
	<form:form commandName="profile" method="POST" enctype="multipart/form-data">
	<form:hidden path="userId" value="${sessionScope.user.userId}"/>	
		<table border="1">
				<tr>
					<th><form:label path="gitAdd">깃 주소</form:label></th>
					<td><form:input path="gitAdd"/><form:errors path="gitAdd"/></td>		
				</tr>
				<tr>
					<th>이미지 사진</th>
					<td><input type="file" name="img" accept="image/jpg,image/jpeg,image/png"></td>
					<!-- accept="image/jpg,image/jpeg,image/png"을 통해 이미지만 첨부할수 있도록 처리 -->
<!-- 					<td> <div id="imagePreview"></div></td>
 -->				</tr>	
		</table>
		<div>
			<input type="submit" value="등록">
		</div>
	</form:form>
</body>
</html>