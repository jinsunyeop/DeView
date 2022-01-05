<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/resources/layout/header.jsp"%>

<body>
<div class="container-fluid" >
    <div class="row flex-nowrap">
        <div class="col-auto col-md-3 col-xl-2 px-sm-2 px-0 bg-dark" >
            <div class="d-flex flex-column  px-3 pt-4 text-white  min-vh-100">
                <h3 class="text-center ">DeViewer 소개</h3>
                <ul class="nav nav-pills flex-column mb-sm-auto mb-0" id="menu">
                    <li class="nav-item text-center pb-3">
 						<img src="<c:url value="${pageContext.request.contextPath}/resources/image/${profile.profileImg}"/>" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='${pageContext.request.contextPath}/resources/logo/default.png'" >
                    </li>
                    <li class="nav-item px-3 pb-3">
                    	<span> <img src="${pageContext.request.contextPath}/resources/logo/nick.png" width="20" height="20" alt="nick" class="mx-1" >${profile.profileNick}</span>
                    </li>
                    <li class="nav-item px-3 pb-3">
                    	<span> <img src="${pageContext.request.contextPath}/resources/logo/git.png" width="20" height="20" alt="git" class="mx-1" >${profile.profileGit}</span>
                    </li>
                	 <li class="nav-item px-3 pb-3">
                    	<span> <img src="${pageContext.request.contextPath}/resources/logo/job.png" width="20" height="20" alt="git" class="mx-1" >${profile.profileJob}</span>
                    </li>
                </ul>
                <hr>
                <div class="pb-4">
                      <h4 class="pb-3">Price: ${deview.devPrice} 원</h4>
                     <p><a href="<c:url value='/deview/read/${deview.userId}'/>"class="btn btn-primary" style="float:right;" role="button">결제하기</a></p>
                    
                </div>
            </div>
        </div>
        <div class="border border-5 col py-3 m-4 ">
        <div class="px-5 pt-3">
		  <h1 class="text-dark"><strong>${deview.devTitle}</strong></h1>
		  <h4 class="text-muted">${user.userName}</h4>
		</div>
		 <hr>
		
		</div>
    </div>
</div>


<%@ include file="/resources/layout/footer.jsp"%>
</html>