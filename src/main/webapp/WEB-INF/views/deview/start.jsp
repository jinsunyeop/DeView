<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>

	<h1 class="text-center mt-1">Start Deview</h1>
	<img alt="프로필 사진" src="<c:url value='/resources/image/${profile.profileImg}'/>" width="100" height="100"  class="rounded-circle mx-auto d-block " onerror="this.src='../resources/logo/default.png'"/>
	<div class="container p-5 my-3 bg-dark text-white rounded-top ">
		<form:form commandName="command" method="POST">
		<form:errors/>
	 	<form:hidden path="userId" value="${user.userId}"/> <!-- 외래키로 가져가야하므로 필수 -->
			 <div class="mb-3 mt-3">
					<form:label path="devTitle" class="form-label">Title</form:label><br> <form:errors path="devTitle"/>
					<form:input path="devTitle" class="form-control" placeholder="환영합니다 ${user.userName}님."/>	
			</div>
			
			<form:label path="devBigcate" class="form-label">주요 개발 언어</form:label><br><form:errors path="devBigcate"/>
			<div class="input-group mb-3 mt-3">
			  	<label class="input-group-text" for="inputGroupSelect01">Options</label>
				  <form:select path="devBigcate" class="form-select" id="inputGroupSelect01">
				    <option value="C">C</option>
				    <option value="C#">C#</option>
				    <option value="C++">C++</option>
				    <option value="JAVA">JAVA</option>
				    <option value="PYTHON">PYTHON</option>
				    <option value="KOTLIN">KOTLIN</option>
				  </form:select>
			</div>
			<form:label path="devSmallcate" class="form-label">직무</form:label><br><form:errors path="devSmallcate"/>
			<div class="input-group mb-3 mt-3">
			  <label class="input-group-text" for="inputGroupSelect01">Options</label>
			
				  <form:select path="devSmallcate" class="form-select" id="inputGroupSelect01">
				    <option value="서버/백엔드">서버/백엔드</option>
				    <option value="프론트엔드">프론트엔드</option>
				    <option value="웹 풀스택">웹 풀스택</option>
				    <option value="안드로이드 앱">안드로이드 앱</option>
				       <option value="아이폰 앱">아이폰 앱</option>
				  </form:select>
			</div>
			
		 	 <div class="mb-3 mt-3">
					<form:label path="devContent" class="form-label">content</form:label><br><form:errors path="devContent"/>
	 				<form:textarea path="devContent" class="form-control h-25" rows="10" placeholder="환영합니다 ${user.userName}님의 경력 사항을 적어주세요 															 - 경력 : SI업체 경력 2년 현재 판교 xx회사에서 백엔드 관련하여 취업 중입니다. 														 - 경험 : 비전공자로 시작하여 현재까지의 경험을 통해 좋은 조언을 해줄 수 있습니다. "/>	
	 				
			</div>
			
			 <div class="mb-3 mt-3">
					<form:label path="devResp" class="form-label">평균 답변 시간</form:label><br><form:errors path="devResp"/>
	 				<form:select path="devResp" class="form-select" id="inputGroupSelect01">
					    <option value="1시간 이내">1시간 이내</option>
					    <option value="3시간 이내">3시간 이내</option>
					    <option value="6시간 이내">6시간 이내</option>
					    <option value="12시간 이내">12시간 이내</option>
					     <option value="1일 이내">1일 이내</option>
				    </form:select>
			</div>

			
			<button type="submit" class="btn btn-outline-secondary">Start</button> 
		</form:form>
	</div>



<%@ include file="/resources/layout/footer.jsp"%>
</html>