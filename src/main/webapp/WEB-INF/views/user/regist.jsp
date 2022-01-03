<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
<div class="container p-5 my-5 bg-dark text-white rounded-top">
<h2>회원 가입</h2>
<form:form action="success" commandName="user">
<form:errors/>
 <div class="mt-3 mb-3">
	<form:label path="email" class="form-label ">이메일</form:label>	<form:errors path="email" class="mx-3"/>
	<form:input path="email" class="form-control" placeholder="name@example.com"/>
</div>
<div class="mb-3">
	<form:label path="name" class="form-label">이름</form:label>	 <form:errors path="name" class="mx-3"/>
	<form:input path="name" class="form-control" placeholder="홍길동"/>
</div>
<div class="mb-3">
	<form:label path="birth" class="form-label">생년월일</form:label>
	<input type="date" name="birth" class="form-control" required/>
</div>
<div class="mb-3">
	<form:label path="nickname" class="form-label">닉네임</form:label> <form:errors path="nickname" class="mx-3"/>
	<form:input path="nickname"  class="form-control" placeholder="devGildong"/>
</div>
<div class="mb-1">
	<form:label path="gender" class="form-label">성별</form:label>	<form:errors path="gender" class="mx-3"/>
</div>
<div class="mb-3">
	<input type="radio"  value="남자" name="gender"  class="form-check-input"/> 남자    
	<input type="radio"  value="여자" name="gender"  class="form-check-input" /> 여자
</div>
<div class="mb-3">
	<form:label path="password" class="form-label">비밀번호</form:label>	<form:errors path="password" class="mx-3"/>
	<form:password path="password" class="form-control" placeholder="password"/>
</div>
<div class="mb-5">
	<label class="form-label">비밀번호 확인</label>
	<input type="password" name="confirmPw" class="form-control" placeholder="password">
</div>
		<button type="submit" class="btn btn-outline-secondary">회원가입</button> 
</form:form>
</div>


<%@ include file="/resources/layout/footer.jsp"%>
</html>