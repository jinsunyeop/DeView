<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resources/layout/header.jsp"%>
<body>
<div class="container p-5 my-5 bg-dark text-white rounded-top ">
	<form:form commandName="login" method="POST">
	  <div class="mb-3 mt-3">
		<h2>${msg1}</h2>
		<h2>${msg2}</h2>
			<form:label path="email" class="form-label">이메일</form:label>
			<form:input path="email" class="form-control" placeholder="Enter email"/><form:errors path="email"/>
      </div>
      <div class="mb-3">
			<form:label path="password" class="form-label">비밀번호</form:label>
			<form:password path="password" class="form-control" placeholder="Enter password"/><form:errors path="password"/>		
	  </div>
		<div class="form-check mb-3">
		    <label class="form-check-label">
					<form:checkbox path="rememberEmail" class="form-check-input"/> 이메일 기억하기
			</label>
		</div>
		<button type="submit" class="btn btn-outline-secondary">Submit</button> 

	</form:form>
</div>

<%@ include file="/resources/layout/footer.jsp"%>
</html>