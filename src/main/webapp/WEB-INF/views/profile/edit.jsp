<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
	<h1 class="text-center mt-1">Profile Edit</h1>
	<div class="container p-5 my-3 bg-dark text-white rounded-top ">
		<img alt="프로필 사진" src="<c:url value='/resources/image/${profile.profileImg}'/>" width="100" height="100"  class="rounded-circle mx-auto d-block " onerror="this.src='../resources/logo/default.png'" id="preview"/>
		<form:form commandName="newProfile" method="POST" enctype="multipart/form-data" onsubmit="popupSubmit()" name="popupForm">
			<input type="hidden" name ="oldImgName"value="${profile.profileImg}">
			<form:hidden path="userId" value="${sessionScope.user.userId}"/>	
			 <div class="mb-3 mt-3">
					<label class="form-label">Profile Img</label>
					<input type="file" name="img" accept="image/jpg,image/jpeg,image/png" class="form-control" id="imgSelector">
			</div>
			<form:label path="profileGit" for="basic-url" class="form-label">Git address</form:label> <form:errors path="profileGit"/>
			 <div class="input-group mb-3 mt-3">
					  <span class="input-group-text" id="basic-addon3">https://github.com/..</span>
					<form:input path="profileGit" class="form-control" placeholder="${profile.profileGit}" id="basic-url" aria-describedby="basic-addon3"/>	
			</div>
			 <div class="mb-3 mt-3">
					<form:label path="profileNick" class="form-label">NickName</form:label> <form:errors path="profileNick"/>
					<form:input path="profileNick" class="form-control" placeholder="${profile.profileNick}"/>	
			</div>
			<span>JOB</span>
			<div class="input-group mb-3 mt-3">
				  <form:select path="profileJob" class="form-select" id="inputGroupSelect01">
				    <option value="무직">무직</option>
				    <option value="대학생">대학생</option>
				    <option value="대학원생">대학원생</option>
				    <option value="개발자">개발자</option>
				    <option value="다른 직무자">다른 직무자</option>
				    <option value="CEO">CEO</option>
				  </form:select>
			</div>
			<button type="submit" class="btn btn-outline-secondary">설정</button> 
		</form:form>	
	</div>
	
<script type="text/javascript">
$('#imgSelector').change(function(){
    setImageFromFile(this, '#preview');
});

function setImageFromFile(input, expression) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
        reader.onload = function (e) {
            $(expression).attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}

function popupSubmit() {
    window.opener.name = "parentPage"; // 부모창의 이름 설정
    document.popupForm.target = "parentPage"; // 타켓을 부모창으로 설정
    document.popupForm.submit();
    self.close();
}

</script>
<%@ include file="/resources/layout/footer.jsp"%>
</html>