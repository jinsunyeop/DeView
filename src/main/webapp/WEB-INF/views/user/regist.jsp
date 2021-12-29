<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<!-- <script type="text/javascript">
let reg_pw= /(?=.*[a-zA-ZS])(?=.*?[#?!@$%^&*-]).{6,24}/;
if(!reg_pw.test(pw)){
	alert('error!');
}
</script> -->
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
<h2>회원 가입</h2>
<form:form action="success" commandName="user">
<form:errors/>
<p>
	<label>이메일<br>
	<form:input path="email"/>
	<form:errors path="email"/>
	</label>
</p>
<p>
	<label>이름 <br>
	<form:input path="name"/>
	<form:errors path="name"/>
	</label>
</p>
<p> 
	<label>생년월일<br>
	<input type="date" name="birth">
	</label>
</p>
<p>
	<label>닉네임<br>
	<form:input path="nickname"/>
	<form:errors path="nickname"/>
	</label>
</p>
<p>
	<label>성별<br>
	<form:checkbox path="gender" value="남자" label="남자" />
	<form:checkbox path="gender" value="여자" label="여자" />
	<form:errors path="gender"/>
	</label>
</p>

<p>
	<label>비밀번호 <br>
	<form:password path="password"/>
	<form:errors path="password"/>
	</label>
</p>
<p>
	<label>비밀번호 확인<br>
	<input type="password" name ="confirmPw"/>
	</label>
</p>
<input type="submit" value="회원가입">
</form:form>
</body>
</html>