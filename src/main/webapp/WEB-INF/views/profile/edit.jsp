<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
	<h1 class="text-center mt-1">Profile Edit</h1>
	<div class="container p-5 my-3 bg-dark text-white rounded-top ">
		<img alt="프로필 사진" src="<c:url value='/resources/image/${profile.imgName}'/>" width="100" height="100"  class="rounded-circle mx-auto d-block " onerror="this.src='../resources/logo/default.png'" id="preview"/>
		<h2 class="text-center">${profile.gitAdd}</h2>
		<form:form commandName="newProfile" method="POST" enctype="multipart/form-data" onsubmit="popupSubmit()" name="popupForm">
	<%-- 	<input type="hidden" name ="oldGitAdd"value="${profile.gitAdd}">
	 --%> 	<input type="hidden" name ="oldImgName"value="${profile.imgName}">
			<form:hidden path="userId" value="${sessionScope.user.userId}"/>	
			 <div class="mb-3 mt-3">
					<form:label path="gitAdd" class="form-label">Git address</form:label> <form:errors path="gitAdd"/>
					<form:input path="gitAdd" class="form-control" placeholder="${profile.gitAdd}"/>	
			</div>
		 	 <div class="mb-3 mt-3">
					<label class="form-label">Profile Img</label>
						<input type="file" name="img" accept="image/jpg,image/jpeg,image/png" class="form-control" id="imgSelector">
						<!-- accept="image/jpg,image/jpeg,image/png"을 통해 이미지만 첨부할수 있도록 처리 -->
	 				
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