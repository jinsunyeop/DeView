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
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
 <script type="text/javascript" charset="utf-8">
	sessionStorage.setItem("contextpath", "${pageContext.request.contextPath}");
	
	var loopSearch=true;
	function keywordSearch(){
		if(loopSearch==false)
			return;
	 var value=document.form.search.value;
		$.ajax({
			type : "get",
			async : true, //false인 경우 동기식으로 처리한다.
			url : "${contextPath}/DeView/keywordSearch.do",
			data : {keyword:value},
			success : function(data, textStatus) {
			    var jsonInfo = JSON.parse(data);
				displayResult(jsonInfo);
			},
			error : function(data, textStatus) {
				alert("에러가 발생했습니다."+data);
			},
			complete : function(data, textStatus) {
				//alert("작업을완료 했습니다");
				
			}
		}); //end ajax	
	}
	
	function displayResult(jsonInfo){
		var count = jsonInfo.keyword.length;
		if(count > 0) {
		    var html = '';
		    for(var i in jsonInfo.keyword){
			   html += "<a href=\"javascript:select('"+jsonInfo.keyword[i]+"')\">"+jsonInfo.keyword[i]+"</a><br/>";
		    }
		    var listView = document.getElementById("suggestList");
		    listView.innerHTML = html;
		    show('suggest');
		}else{
		    hide('suggest');
		} 
	}
	
	
	function select(selectedKeyword) {
		 document.form.search.value=selectedKeyword;
		 loopSearch = false;
		 hide('suggest');
	}
/* 		
	function show(elementId) {
		 var element = document.getElementById(elementId);
		 if(element) {
		  element.style.display = 'block';
		 }
		}
	
	function hide(elementId){
	   var element = document.getElementById(elementId);
	   if(element){
		  element.style.display = 'none';
	   }
	} */
</script>
<title>DeView</title>
</head>
	<header>
		 <nav class="navbar navbar-expand-lg  navbar-dark bg-dark">
			  <a class="navbar-brand m-3 " href="<c:url value="/main"/>">
			  	<img src="${pageContext.request.contextPath}/resources/logo/DeviewLogo.png" width="200" height="100" alt="메인로고"  class="mx-2">
			  </a>
			<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
			    <div class="navbar-nav">
				      <h3><a class="nav-item nav-link active" href="<c:url value="/main"/>">Home</a></h3>
			 	  	 <h3> <a class="nav-item nav-link text-light" href="<c:url value='/deview/start'/>">Start DeView</a></h3>
			    </div>
		   </div>
		 	   <nav class="navbar navbar-dark">
		 	   	<c:set var="session" value="${sessionScope.user}" />
		 	   		<c:choose>
					<c:when test="${empty session}">
			 	   	   	<a class="nav-item nav-link text-light" href="<c:url value='/user/regist'/>">register</a>
			 		  	<a class="nav-item nav-link text-light" href="<c:url value='/user/login'/>">login</a>
			 	   		<a class="nav-item nav-link" href="<c:url value='/user/login'/>">
		 	 		</c:when>
					<c:otherwise>
		 	  			<a class="nav-item nav-link text-light" href="<c:url value='/user/logout'/>">logout</a>
		 	   			<a class="nav-item nav-link" href="<c:url value='/profile/profile'/>">
		 	   		</c:otherwise>
		    		</c:choose>
					   	<img src="${pageContext.request.contextPath}/resources/logo/profile.png" width="35" height="35" alt="프로필" >
						</a>
			   </nav>			
		</nav>
		<nav class="navbar navbar-light bg-light p-2">
				      <a class="nav-item nav-link active" style="margin-left:3rem;" href="<c:url value="/list/list?lang=1"/>">C언어</a>
				      <a class="nav-item nav-link active" style="margin-left:3rem;" href="<c:url value="/list/list?lang=2"/>">C#</a>
				      <a class="nav-item nav-link active" style="margin-left:3rem;" href="<c:url value="/list/list?lang=3"/>">C++</a>
				      <a class="nav-item nav-link active" style="margin-left:3rem;" href="<c:url value="/list/list?lang=4"/>">JAVA</a>
				      <a class="nav-item nav-link active" style="margin-left:3rem;" href="<c:url value="/list/list?lang=5"/>">PYTHON</a>
				      <a class="nav-item nav-link active" style="margin-left:3rem;" href="<c:url value="/list/list?lang=6"/>">KOTLIN</a>
			     
		   <form class="form-inline" action="<c:url value="/main/search"/>" method="get" name="form">
		   
		    <select class="custom-select" style="width:100px;" name="keyword"> 
				  <option selected>Title/Viewer</option>
				  <option value="1">Title</option>
				  <option value="2">Viewer</option>
			</select>
			
		    <input class="mr-sm-2" type="search" name ="search" placeholder="Search" aria-label="Search"  onKeyUp="keywordSearch()">
	
		    <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		   
		   </form>
		   <div id="suggest" style="float:right">
       			 <div id="suggestList">
       		</div> 
		</nav>   
		 
			   
   </div>

	</header>
