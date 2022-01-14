<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ include file="/resources/layout/header.jsp"%>
<body>

<!-- Carousel -->
<div id="demo" class="carousel slide" data-bs-ride="carousel">

  <!-- Indicators/dots -->
  <div class="carousel-indicators">
    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
  </div>

  <!-- The slideshow/carousel -->
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="${pageContext.request.contextPath}/resources/logo/배너1.png" alt="배너1" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath}/resources/logo/배너2.png" alt="배너2" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="${pageContext.request.contextPath}/resources/logo/배너3.png" alt="배너3" class="d-block w-100">
    </div>
  </div>
  
</div>

<!-- 카드형 리스트 -->
<c:if test=	"${deviewList.size()==0}"	> 
<h1>DEVIEW가 없습니다</h1>
</c:if>
<div class="row m-5" style="text-align:center;">
	<c:forEach var="deview" items="${deviewList}" varStatus="Loop">
		 <c:forEach var="profile" items="${profileList}" varStatus="Loop">
			<c:if test=	"${deview.userId==profile.userId}"	> 
			  <div class="col-sm-5 col-md-3 border border-2 mx-5 mt-5">
			    <div class="thumbnail mx-auto">
				<img src="${pageContext.request.contextPath}/resources/image/${profile.profileImg}" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
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
    
      <nav aria-label="Page navigation example">
	  <ul class="pagination nav justify-content-center mt-5">
	    <li class="page-item">
	      <a class="page-link" href="<c:url value="/main?page=${1}"/>" aria-label="Previous">
	        <span aria-hidden="true">&laquo;</span>
	      </a>
	    </li>
	    <c:forEach var = "i" begin="1" end="${allPage}">
	    <li class="page-item"><a class="page-link" href="<c:url value="/main?page=${i}"/>">${i}</a></li>
	    </c:forEach>
	    <li class="page-item">
	      <a class="page-link" href="<c:url value="/main?page=${allPage}"/>" aria-label="Next">
	        <span aria-hidden="true">&raquo;</span>
	      </a>
	    </li>
	  </ul>
	</nav>
  
</div>   

    
 
<%@ include file="/resources/layout/footer.jsp"%>
</html>