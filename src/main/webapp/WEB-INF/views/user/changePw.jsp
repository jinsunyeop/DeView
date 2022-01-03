<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>
<body>
	<h1 class="text-center mt-1"> 비밀번호 변경</h1>
	<div class="container p-5 my-3 bg-dark text-white rounded-top ">
		<form:form commandName="changePw" method="POST">
		<form:errors/>
			 <div class="mb-3 mt-3">
					<form:label path="currentPassword" class="form-label">현재 비밀번호</form:label> <form:errors path="currentPassword"/>
					<form:password path="currentPassword" class="form-control"/>	
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="newPassword" class="form-label">새 비밀번호</form:label> <form:errors path="newPassword"/>
					<form:password path="newPassword" class="form-control"/>	
			</div>
			<button type="submit" class="btn btn-outline-secondary">변경</button> 
		</form:form>	
	</div>
<%@ include file="/resources/layout/footer.jsp"%>
</html>