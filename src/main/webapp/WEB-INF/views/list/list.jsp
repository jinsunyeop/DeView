<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resources/layout/header.jsp"%>
<body>

<div class="row m-5" style="text-align:center;">
	<c:if test=	"${deviewList.size()==0}"	> 
	<h1>DEVIEW가 없습니다</h1>
	</c:if>
	<c:forEach var="deview" items="${deviewList}" varStatus="Loop">
		 <c:forEach var="profile" items="${profileList}" varStatus="Loop">
			<c:if test=	"${deview.userId==profile.userId}"	> 
			  <div class="col-sm-5 col-md-3 border border-2 mx-5 mt-5">
			    <div class="thumbnail mx-auto">
				<img src="<c:url value='../resources/image/${profile.profileImg}'/>" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
			      <div class="caption">
			      	<span>${profile.profileNick}</span>
			        <h3>${deview.devTitle}</h3>
			        <p>${deview.devBigcate}/${deview.devSmallcate}</p>
			        <p><a href="<c:url value='/deview/read/${deview.userId}'/>"class="btn btn-primary" role="button">보러가기</a></p>
			      </div>
			    </div>
			  </div>
 		  </c:if>  
	  </c:forEach> 
    </c:forEach>
    
 </div>






<%@ include file="/resources/layout/footer.jsp"%>
</html>