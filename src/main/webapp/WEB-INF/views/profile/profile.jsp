<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resources/layout/header.jsp"%>

<body>
	<div class="container">	
		<div class="mt-5">
			<h2 class="font-weight-bold"><strong>내 프로필</strong></h2>
			<hr>
		</div>
		<div class="mt-4">
			<strong><h1 class="font-weight-bold">${sessionScope.user.userName} 님 
				<a href="<c:url value='/user/changePw'/>"><img src="../resources/logo/logo3.png" width="20" height="20" alt="profile" class="mx-2"></a>
				<a href="<c:url value='/user/delete'/>"><img src="../resources/logo/delete.png" width="20" height="20" alt="profile"></a>
				</h1></strong>
			<ul class="list-group list-group-flush mt-2">
 				<li class="list-group-item"><img src="../resources/logo/logo4.png" width="20" height="20" alt="name" class="mx-1" >
 				${sessionScope.user.userName}</li>
				 <li class="list-group-item"> <img src="../resources/logo/logo1.png" width="20" height="20" alt="gender" class="mx-1" >
				 ${sessionScope.user.userGender}</li>
				 <li class="list-group-item"> <img src="../resources/logo/logo2.png" width="20" height="20" alt="email" class="mx-1" >
				 ${sessionScope.user.userEmail}</li>
			</ul>
			<hr>

		</div>
		<div class="mt-4">
		<h1 class="mx-1"><strong>프로필 
 		<c:if test="${profile == null}">
			<a onclick="popup(this)" id="insert"><img src="../resources/logo/write.png" width="20" height="20" alt="edit" class="mx-2"></a>
		</c:if>
		 <c:if test="${profile != null}">
			<a onclick="popup(this)" id="edit"><img src="../resources/logo/write.png" width="20" height="20" alt="edit" class="mx-2"></a>
		</c:if>
		</strong></h1>
 			<img src="<c:url value='../resources/image/${profile.profileImg}'/>" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
 			
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>Github 저장소</h4></li>
 				<li class="list-group-item"><img src="../resources/logo/git.png" width="20" height="20" alt="git" class="mx-1" >
 				<a href="${profile.profileGit}" style="text-decoration-line: none;">${profile.profileGit}</a></li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>닉네임</h4></li>
 				<li class="list-group-item"><img src="../resources/logo/nick.png" width="20" height="20" alt="git" class="mx-1" >
 				${profile.profileNick}</li>
			</ul>
			<hr>
			<ul class="list-group list-group-flush mt-2">
				<li class="list-group-item"><h4>직업</h4></li>
 				<li class="list-group-item"><img src="../resources/logo/job.png" width="20" height="20" alt="git" class="mx-1" >
 				${profile.profileJob}</li>
			</ul>
			<hr>
		</div>
		
		<div class="mt-4">
		<c:set var="deview" value="${deview}" />
		<c:choose>
			<c:when test="${empty deview}">
			<h2><strong>DeViewer 등록하기	</strong></h2>
			<a href="<c:url value='/deview/start'/>">
			<img src="<c:url value='../resources/logo/DeViewLogo.png'/>" width="200" height="100" alt="img"  onerror="this.src='../resources/logo/default.png'" >
			</a>
			</c:when>
			<c:otherwise>
			<h2><strong>등록한 DeViewer</strong></h2>
			<table class="table table-dark">
			  <thead>
			    <tr>
			      <th>deview 번호</th>
			      <th>deview 제목</th>
			      <th>주요 언어</th>
			      <th>주요 기술</th>
			      <th>전화 번호</th>
			      <th>가격</th>
			    </tr>
			  </thead>
			  <tbody>
			    <tr class="table-active">
			      	<td>${deview.devId}</td>
			      	<td>${deview.devTitle}</td>
			      	<td>${deview.devBigcate}</td>
			      	<td>${deview.devSmallcate}</td>
			      	<td>${deview.devNumber}</td>
			      	<td>${deview.devPrice} 원</td>
			    </tr>

			    <tr>
			      <td colspan="6" class="text-right">
			        <a href="<c:url value='/deview/edit'/>"><img src="../resources/logo/edit.png" width="20" height="20" alt="edit" class="mx-2"></a>
			      	<a onclick="popup2(this)" id="delete"><img src="../resources/logo/delete2.png" width="20" height="20" alt="update" class="mx-2"></a>
			      </td>
			    </tr>
			  </tbody>
			</table>
			</c:otherwise>
		</c:choose>
				<hr>
		</div>
		
		
		
		
	
	</div>

<script>
function popup(url){
	var pop = "/profile/"+$(url).attr("id");
	var ctx = getContextPath();
	  function getContextPath() {
	  return sessionStorage.getItem("contextpath");
	}
	  var name = "popup";
	  var url = ctx+pop;  
	window.open(url,name,"width=500,height=500,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=50,right=50");	
}
</script>
<script>
function popup2(url){
	var pop = "/deview/"+$(url).attr("id");
	var ctx = getContextPath();
	  function getContextPath() {
	  return sessionStorage.getItem("contextpath");
	}
	  var name = "popup";
	  var url = ctx+pop;  
	window.open(url,name,"width=700,height=500,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=70,right=70");	
}
</script>



<%@ include file="/resources/layout/footer.jsp"%>
</html>