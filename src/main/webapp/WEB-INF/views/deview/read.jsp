<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
<div class="container-fluid" >
    <div class="row flex-nowrap">
        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark" >
            <div class="d-flex flex-column  px-2 pt-4 text-white  min-vh-100">
                <h3 class="text-center ">DeViewer 소개</h3>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0" id="menu">
                    <li class="nav-item text-center pb-3">
 						<img src="${pageContext.request.contextPath}/resources/image/${profile.profileImg}" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='${pageContext.request.contextPath}/resources/logo/default.png'" >
                    </li>
                    <li class="nav-item px-1 pb-3">
                    	<span> <img src="${pageContext.request.contextPath}/resources/logo/nick2.png" width="20" height="20" alt="nick" class="mx-1" >${profile.profileNick}</span>
                    </li>
                    <li class="nav-item px-1 pb-3">
                    	<span> <img src="${pageContext.request.contextPath}/resources/logo/git2.png" width="20" height="20" alt="git"  >
                    	<a href="${profile.profileGit}">${profile.profileGit}</a>
                    	</span>
                    </li>
                	 <li class="nav-item px-1 pb-3">
                    	<span> <img src="${pageContext.request.contextPath}/resources/logo/job2.png" width="20" height="20" alt="git" class="mx-1" >${profile.profileJob}</span>
                    </li>

                </ul>
                	  <div class="btn-group" role="group">
                	  	<c:if test=	"${myProfile==0}">                       	  
	                	  	<h4 class="text-center">프로필 작성 필수</h4>
<%-- 	                	  	<a href="<c:url value='/profile/profile'/>">프로필 가기</a>
 --%>					</c:if>
                	  	<c:if test=	"${matchingStatus==null && myProfile==1}">                       	  
	                	  	<form:form commandName="matching" method="POST">
		                		<input type="hidden" name ="matchingRequest" value="${myUserId}">
		                        <input type="hidden" name ="matchingApply" value="${profile.userId}">
							    <button type="submit" class="btn btn-primary">매칭하기</button>
						    </form:form>
					    </c:if>
					    <c:if test=	"${matchingStatus==false}">                       	  
					    	<h2>매칭중</h2>
					    </c:if>
					    <c:if test=	"${matchingStatus==true}">                       	  
					    	<h5>매칭 완료!</h5>
					    	<a href="<c:url value='/profile/profile'/>">프로필 가기</a>
					    	
					    </c:if>
					    </div>
			
                <hr>
            </div>
        </div>
        <div class="border border-5 col py-3 m-4 ">
        <div class="px-5 pt-3">
		  <h1 class="text-dark"><strong>${deview.devTitle}</strong></h1>
		  <h4 class="text-muted">${user.userName}</h4>
		</div>
		 <hr>
		<ul class="list-group list-group-flush px-4 pt-3">
		  <li class="list-group-item">
		   	<img src="${pageContext.request.contextPath}/resources/logo/logo1.png" width="30" height="30" alt="gender" class="rounded-circle mx-2 " onerror="this.src='${pageContext.request.contextPath}/resources/logo/default.png'" >
		 	저의 성별은 ${user.userGender } 입니다! 
		  </li>
		  <li class="list-group-item">
		   	<img src="${pageContext.request.contextPath}/resources/logo/logo4.png" width="30" height="30" alt="email" class="rounded-circle mx-2 " onerror="this.src='${pageContext.request.contextPath}/resources/logo/default.png'" >
		 	저의 이메일은 ${user.userEmail } 이구요.
		  </li>	
		  <li class="list-group-item">
		   	<img src="${pageContext.request.contextPath}/resources/logo/launage.png" width="30" height="30" alt="launage" class="rounded-circle mx-2 " onerror="this.src='${pageContext.request.contextPath}/resources/logo/default.png'" >
		 	저의 개발언어는 주로 ${deview.devBigcate } 사용하고 있습니다! 
		  </li>			
		  <li class="list-group-item">
		   	<img src="${pageContext.request.contextPath}/resources/logo/programing.png" width="30" height="30" alt="programing" class="rounded-circle mx-2 " onerror="this.src='${pageContext.request.contextPath}/resources/logo/default.png'" >
		 	 제가 리뷰하고자 하는 직무는 ${deview.devSmallcate } 사용하고 있습니다! 
		  </li>			
		  
		</ul>
		 <hr>
		<div class="px-5 pt-3">
		  <h4 class="text-muted">${deview.devContent}</h4>
		</div>
		
    </div>
</div>


<%@ include file="/resources/layout/footer.jsp"%>
</html>