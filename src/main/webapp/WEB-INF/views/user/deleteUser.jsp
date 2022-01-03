<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>
<body>
	<h1 class="text-center mt-1"> 회원 삭제</h1>
	<div class="container p-5 my-3 bg-dark text-white rounded-top ">
		<form:form commandName="delete" method="POST">
		<form:errors/>
			 <div class="mb-3 mt-3">
					<form:label path="agree" class="form-label">모든 불이익에 대해 동의합니까</form:label>
					<form:checkbox path="agree" value ="true"/>	
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="email" class="form-label">이메일</form:label> <form:errors path="email"/>
					<form:input path="email" class="form-control"/>	
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="password" class="form-label">비밀번호</form:label> <form:errors path="password"/>
					<form:password path="password" class="form-control"/>	
			</div>
			<button type="submit" class="btn btn-outline-secondary">탈퇴</button> 
		</form:form>	
	</div>
<%@ include file="/resources/layout/footer.jsp"%>
</html>