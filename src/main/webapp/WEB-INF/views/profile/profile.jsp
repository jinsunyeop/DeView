<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resources/layout/header.jsp"%>
<body>
	<div class="container">	
		<div class="mt-5">
			<h2 class="font-weight-bold"><strong>내 프로필</strong></h2>
			<hr>
		</div>
		<div class="mt-4">
			<h1 class="font-weight-bold">${sessionScope.user.nickname} 님 <img src="../resources/logo/logo3.png" width="20" height="20" alt="profile" class="mx-2"></h1>
			<ul class="list-group list-group-flush mt-2">
 				<li class="list-group-item"><img src="../resources/logo/logo4.png" width="20" height="20" alt="name" class="mx-1" >
 				${sessionScope.user.name}</li>
				 <li class="list-group-item"> <img src="../resources/logo/logo1.png" width="20" height="20" alt="gender" class="mx-1" >
				 ${sessionScope.user.gender}</li>
				 <li class="list-group-item"> <img src="../resources/logo/logo2.png" width="20" height="20" alt="email" class="mx-1" >
				 ${sessionScope.user.email}</li>
			</ul>
			<hr>

		</div>
		<div class="mt-4">
		<h3>프로필 사진 및 Github 저장소
 		<c:if test="${profile == null}">
			<a href="javascript:popup();"><img src="../resources/logo/write.png" width="20" height="20" alt="edit" class="mx-2"></a>
		</c:if>
		 <c:if test="${profile != null}">
			<a href="<c:url value='/profile/edit'/>"><img src="../resources/logo/write.png" width="20" height="20" alt="edit" class="mx-2"></a>
		</c:if>
		</h3>
 			<img src="<c:url value='../resources/image/${profile.imgName}'/>" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
 			
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>Github 저장소</h4></li>
 				<li class="list-group-item"><img src="../resources/logo/git.png" width="20" height="20" alt="git" class="mx-1" >
 				<a href="${profile.gitAdd}">${profile.gitAdd}</a></li>
			</ul>
			<hr>
		</div>
		
		
		
		
		
	
	</div>


<script>
function popup(){
	var ctx = getContextPath();
	  function getContextPath() {
	  return sessionStorage.getItem("contextpath");
	}
	  var name = "popup";
	  var url = ctx+"/profile/insert";
	  
	window.open(url,name,"width=500,height=500,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=50,right=50");
}
</script>




<%@ include file="/resources/layout/footer.jsp"%>
</html>