<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<!-- 합쳐지고 최소화된 최신 CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <script type="text/javascript" charset="utf-8">
	sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
</script>
<title>DeView</title>
</head>
	<header>
		 <nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
		  <a class="navbar-brand m-3 " href="<c:url value="/main/main"/>">DeView</a>
		  <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		    <div class="navbar-nav">
		      <a class="nav-item nav-link active" href="<c:url value="/main/main"/>">Home</a>
		    <c:if test="${empty sessionScope.user}">
		      	<a class="nav-item nav-link" href="<c:url value='/user/login'/>">Start DeView</a>
			</c:if>
			<c:if test="${not empty sessionScope.user}">
	 	  		 <a class="nav-item nav-link text-light" href="<c:url value='/start/deview'/>">Start DeView</a>
	 	   </c:if>
		    </div>
		  </div>
	 	   <nav class="navbar navbar-dark" >
	 	  	 <c:if test="${empty sessionScope.user}">
	 	   	   <a class="nav-item nav-link text-light" href="<c:url value='/user/regist'/>">register</a>
	 		   <a class="nav-item nav-link text-light" href="<c:url value='/user/login'/>">login</a>
	 	   		<a class="nav-item nav-link" href="<c:url value='/user/login'/>">
	 	 	</c:if>
	 	   <c:if test="${not empty sessionScope.user}">
	 	  		 <a class="nav-item nav-link text-light" href="<c:url value='/user/logout'/>">logout</a>
	 	   		<a class="nav-item nav-link" href="<c:url value='/profile/profile'/>">
	 	   </c:if>
				   	<img src="../resources/logo/profile.png" width="35" height="35" alt="프로필" >
				</a>
	 		<a class="navbar-brand" href="#">
				<img src="../resources/logo/cart.png" width="35" height="35" alt="장바구니"  class="mx-2">
			</a>

			</nav>			
			  
		</nav>	      
		
	</header>
