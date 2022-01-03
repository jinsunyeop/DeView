<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>

	<h1 class="text-center mt-1">Start Deview</h1>
	<img alt="프로필 사진" src="<c:url value='/resources/image/${profile.imgName}'/>" width="100" height="100"  class="rounded-circle mx-auto d-block " onerror="this.src='../resources/logo/default.png'"/>
	<div class="container p-5 my-3 bg-dark text-white rounded-top ">
		<form:form commandName="command" method="POST">
		<form:errors/>
	 	<form:hidden path="userId" value="${user.userId}"/> <!-- 외래키로 가져가야하므로 필수 -->
			 <div class="mb-3 mt-3">
					<form:label path="title" class="form-label">Title</form:label> 
					<form:input path="title" class="form-control" placeholder="환영합니다 ${user.name}님."/>	
			</div>
		 	 <div class="mb-3 mt-3">
					<form:label path="career" class="form-label">career</form:label>
	 				<form:textarea path="career" class="form-control" placeholder="환영합니다 ${user.name}님의 경력 사항을 적어주세요"/>	
	 				
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="contact" class="form-label">contact</form:label>
	 				<form:input path="contact" class="form-control" placeholder="${user.name}님의 contact mail을 적어주세요"/>		
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="number" class="form-label">number</form:label>
	 				<form:input path="number" class="form-control" placeholder="${user.name}님의 전화번호를 적어주세요"/>		
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="price" class="form-label">price</form:label>
	 				<form:input path="price" class="form-control"/>		
			</div>
			
			<button type="submit" class="btn btn-outline-secondary">Start</button> 
		</form:form>
	</div>




<%@ include file="/resources/layout/footer.jsp"%>
</html>