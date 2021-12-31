<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>${profile.gitAdd}</h1>
	<img alt="프로필 사진" src="<c:url value='/resources/image/${profile.imgName}'/>" width="200" height="300"/>
	
	<form:form commandName="newProfile" method="POST" enctype="multipart/form-data">
	<input type="hidden" name ="oldGitAdd"value="${profile.gitAdd}">
	<input type="hidden" name ="oldImgName"value="${profile.imgName}">
	<form:hidden path="userId" value="${sessionScope.user.userId}"/>	

		<table border="1">
				<tr>
					<th><form:label path="gitAdd">깃 주소</form:label></th>
					<td><form:input path="gitAdd" placeholder="${profile.gitAdd}"/><form:errors path="gitAdd"/></td>		
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