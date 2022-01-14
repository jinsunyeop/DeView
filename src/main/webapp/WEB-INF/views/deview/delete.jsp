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
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
 <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<title>DeView</title>
</head>
		<form:form method="POST"  onsubmit="popupSubmit()" name="popupForm">
			<input type="hidden" name ="devId"value="${deview.devId}">
			<h2 class="text-center"><strong>등록한 DeViewer</strong></h2>
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
			      <td colspan="6" class="text-right">
			    	<button type="submit" class="btn btn-outline-secondary">삭제</button> 
			      </td>
			      
			  </tbody>
			</table>
		</form:form>
		

<script>
function popupSubmit() {
    window.opener.name = "parentPage"; // 부모창의 이름 설정
    document.popupForm.target = "parentPage"; // 타켓을 부모창으로 설정
    document.popupForm.submit();
    self.close();
}
</script>
</body>
</html>