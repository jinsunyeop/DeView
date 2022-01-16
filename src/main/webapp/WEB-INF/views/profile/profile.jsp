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
			<h3 style="text-align:center;"><a href="<c:url value='/deview/start'/>" style="text-decoration-line : none;">
			DeView 시작하기
			</a></h3>
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
			    </tr>
			  </thead>
			  <tbody>
			    <tr class="table-active">
			      	<td>${deview.devId}</td>
			      	<td>${deview.devTitle}</td>
			      	<td>${deview.devBigcate}</td>
			      	<td>${deview.devSmallcate}</td>
			      	<td>${deview.devNumber}</td>
			    </tr>

			    <tr>
			      <td colspan="6" class="text-right">
			        <a href="<c:url value='/deview/edit'/>"><img src="../resources/logo/edit3.png" width="20" height="20" alt="edit" class="mx-2"></a>
			      	<a onclick="popup2(this)" id="delete"><img src="../resources/logo/delete3.png" width="20" height="20" alt="update" class="mx-2"></a>
			      </td>
			    </tr>
			  </tbody>
			</table>
			</c:otherwise>
		</c:choose>
				<hr>
		</div>
		
		<div class="mt-4">
				<h2 class="font-weight-bold"><strong>나의 DeView에 요청을 준 유저 </strong></h2>
				<div class="row m-5" style="text-align:center;" >
	 				<c:if test="${not empty profileList1}">
					<c:forEach var="reqProfile" items="${profileList1}" varStatus="Loop">
					  <div class="col-sm-5 col-md-3 border border-2 mx-5 mt-5">
					    <div class="thumbnail mx-auto">
					    <span>${reqProfile.profileNick}님으로부터 요청을 받았습니다.</span>
						<img src="${pageContext.request.contextPath}/resources/image/${reqProfile.profileImg}" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
					      <div class="caption" style="text-align:left;">
					      	<img src="${pageContext.request.contextPath}/resources/logo/git2.png" width="20" height="20" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >${reqProfile.profileGit}<br>
					      	<img src="${pageContext.request.contextPath}/resources/logo/job2.png" width="20" height="20" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >${reqProfile.profileJob}
					      </div>
						        <form class="d-grid gap-2 col-6 mx-auto" action="<c:url value="/matching/update"/>" method="get">
						       		  <input type="hidden" name="request" value="${reqProfile.userId}">
						       		 <button type="submit" class="btn btn-outline-primary " role="button">승인</button>
					    		</form>
						         <form class="d-grid gap-2 col-6 mx-auto" action="<c:url value="/matching/delete"/>" method="get">
						       		  <input type="hidden" name="request" value="${reqProfile.userId}">
						     		   <button type="submit" class="btn btn-outline-warning " role="button">취소</button>
					    		</form>
					    </div>
					  </div>
					</c:forEach>
					</c:if>
				   <c:if test="${empty profileList1}">
			 			<h5>현재 요청을 준 USER가 존재하지 않습니다.</h5>
				   </c:if>
			</div>
			<hr>
			
			<h2 class="font-weight-bold"><strong>내가 요청한 DeViewer</strong> </h2>
			<div class="row m-5" style="text-align:center;">
 			<c:if test="${not empty profileList2}">
				<c:forEach var="applyProfile" items="${profileList2}" varStatus="Loop">
				  <div class="col-sm-5 col-md-3 border border-2 mx-5 mt-5">
				    <div class="thumbnail mx-auto">
				    <span>${applyProfile.profileNick}님께 요청을 했습니다.</span>
					<img src="${pageContext.request.contextPath}/resources/image/${applyProfile.profileImg}" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
				      <div class="caption">
				      	<span>${applyProfile.profileNick}</span>
				        <p><a href="<c:url value='/deview/read/${applyProfile.userId}'/>"class="btn btn-primary" role="button">보러가기</a></p>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</c:if>
			 <c:if test="${empty profileList2}">
			 		<h5>현재 요청한 DeViewer가 존재하지 않습니다.</h5>
			</c:if>
			</div>
			<hr>
		
			<h2 class="font-weight-bold"><strong>나의 DeView에 요청을 준 유저와 채팅 하러 가기</strong> </h2>
			<div class="row m-5" style="text-align:center;">
 			<c:if test="${not empty completeList1}">
				<c:forEach var="complete1" items="${completeList1}" varStatus="Loop">
				  <div class="col-sm-5 col-md-3 border border-2 mx-5 mt-5">
				    <div class="thumbnail mx-auto">
					<img src="${pageContext.request.contextPath}/resources/image/${complete1.profileImg}" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
				      <div class="caption">
				      	<span>${complete1.profileNick}</span>
				        <p><a id= "${complete1.userId}"class="btn btn-primary" onclick="popup3(this)" role="button">채팅창</a></p>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</c:if>
			 <c:if test="${empty completeList1}">
			 		<h5>현재 매칭된 채팅이 존재하지 않습니다.</h5>
			</c:if>
			</div>
			<hr>
			
			<h2 class="font-weight-bold"><strong>내가 요청한 DeViewer와 채팅 하러 가기</strong> </h2>
			<div class="row m-5" style="text-align:center;">
 			<c:if test="${not empty completeList2}">
				<c:forEach var="complete2" items="${completeList2}" varStatus="Loop">
				  <div class="col-sm-5 col-md-3 border border-2 mx-5 mt-5">
				    <div class="thumbnail mx-auto">
					<img src="${pageContext.request.contextPath}/resources/image/${complete2.profileImg}" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
				      <div class="caption">
				      	<span>${complete2.profileNick}</span>
				        <p><a id= "${complete2.userId}"class="btn btn-primary" onclick="popup4(this)" role="button">채팅창</a></p>
				      </div>
				    </div>
				  </div>
				</c:forEach>
			</c:if>
			 <c:if test="${empty completeList2}">
			 		<h5>현재 매칭된 채팅이 존재하지 않습니다.</h5>
			</c:if>
			</div>
			<hr>

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

<script>
function popup3(url){
	var pop = "/matching/chatToId/"+$(url).attr("id");
	var ctx = getContextPath();
	  function getContextPath() {
	  return sessionStorage.getItem("contextpath");
	}
	  var name = "popup";
	  var url = ctx+pop;  
	window.open(url,name,"width=700,height=500,toolbar=no,status=no,location=no,scrollbars=yes,menubar=no,resizable=yes,left=70,right=70");	
}
</script>

<script>
function popup4(url){
	var pop = "/matching/chatToId/"+$(url).attr("id");
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