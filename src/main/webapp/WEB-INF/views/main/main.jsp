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
      <img src="https://picsum.photos/1200/300" alt="배너1" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="https://picsum.photos/1210/300" alt="배너2" class="d-block w-100">
    </div>
    <div class="carousel-item">
      <img src="https://picsum.photos/1220/300" alt="배너3" class="d-block w-100">
    </div>
  </div>
  
</div>

<!-- 카드형 리스트 -->

<div class="row m-5" style="text-align:center;">
	<c:forEach var="deview" items="${deviewList}" varStatus="Loop">
		 <c:forEach var="profile" items="${profileList}" varStatus="Loop">
			<c:if test=	"${deview.userId==profile.userId}"	> 
			  <div class="col-sm-5 col-md-3 border border-2 mx-auto">
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
< 		  </c:if>  
	  </c:forEach> 
    </c:forEach>
<%--   <div class="col-sm-6 col-md-3 border border-2 mx-auto">
    <div class="thumbnail mx-auto">
	<img src="<c:url value='../resources/image/${profile.profileImg}'/>" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>나는 가끔씩 이를테면 계절같은것에 취해 나를 속이며</p>
        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      </div>
    </div>
  </div>

  <div class="col-sm-5 col-md-3 border border-2 mx-auto">
    <div class="thumbnail mx-auto">
	<img src="<c:url value='../resources/image/${profile.profileImg}'/>" width="80" height="80" alt="img" class="rounded-circle m-2 " onerror="this.src='../resources/logo/default.png'" >
      <div class="caption">
        <h3>Thumbnail label</h3>
        <p>나는 가끔씩 이를테면 계절같은것에 취해 나를 속이며</p>
        <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
      </div>
    </div>
  </div>
   --%>

  
</div>   
  
    
 
<%@ include file="/resources/layout/footer.jsp"%>
</html>