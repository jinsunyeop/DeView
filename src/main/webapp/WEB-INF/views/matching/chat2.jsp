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
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet">
<link href="https://use.fontawesome.com/releases/v5.7.2/css/all.css" rel="stylesheet">
<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.bundle.min.j" rel="stylesheet">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/chat.css">
<script type="text/javascript">
	function submitFunction(){
		var chatId = '${chatId}';
		var fromId = '${fromId}';
		var toId = '${sessionScope.user.userId}';
		var chatContent = $('#chatContent').val();
		$.ajax({
			type : "POST",
			url : "${pageContext.request.contextPath}/matching/chatFromId",
			data : {
				chatId : encodeURIComponent(chatId),
				fromId : encodeURIComponent(fromId),
				toId : encodeURIComponent(toId),
				chatContent : encodeURIComponent(chatContent),
			},
		  error:function(request,status,error){
            alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
         }

		});
		$('#chatContent').val('');

	}
	
	$(document).ready(function(){
		$("#chat-content").scrollTop($("#chat-content")[0].scrollHeight);
	});
	
	function popupClose() {
	    self.close();
	}
</script>



<title>채팅방</title>
</head>
<body>
<div class="page-content page-container" id="page-content">
    <div class="padding">
        <div class="row container d-flex justify-content-center  mx-auto">
            <div class="col-md-6">
                <div class="card card-bordered">
                    <div class="card-header">
                        <h3 class="card-title"><strong>${profile1.profileNick}님과의 대화</strong></h3> <a class="btn btn-xs btn-secondary" href="${pageContext.request.contextPath}/matching/chatToId/${toId}" data-abc="true"> <img class="avatar" src="${pageContext.request.contextPath}/resources/logo/refresh.png" width="80" height="80" alt="..."></a>
                    </div>
                    <div class="ps-container ps-theme-default ps-active-y" id="chat-content" style="overflow-y: scroll !important; height:400px !important;">
						<c:forEach var="chat" items="${chatting}" varStatus="Loop">
						<c:if test="${chat.toId != fromId}">
                        <div class="media media-chat"> <img class="avatar" src="${pageContext.request.contextPath}/resources/image/${profile1.profileImg}" width="80" height="80" alt="...">
                            <div class="media-body">
                                <p>${chat.chatContent }</p>
                            </div>
                        </div>
                        </c:if>
                       	<c:if test="${chat.toId == fromId}">
        
                         <div class="media media-chat media-chat-reverse">
                            <div class="media-body">
                                <p>${chat.chatContent }</p>
                            </div>
                        </div>
                        </c:if>
                        </c:forEach>                        


                        <div class="ps-scrollbar-x-rail" style="left: 0px; bottom: 0px;">
                            <div class="ps-scrollbar-x" tabindex="0" style="left: 0px; width: 0px;"></div>
                        </div>
                        <div class="ps-scrollbar-y-rail" style="top: 0px; height: 0px; right: 2px;">
                            <div class="ps-scrollbar-y" tabindex="0" style="top: 0px; height: 2px;"></div>
                        </div>
                    </div>
                    <div class="publisher bt-1 border-light">
 							<img class="avatar" src="${pageContext.request.contextPath}/resources/image/${profile2.profileImg}" width="80" height="80" alt="...">                   
 					 	 	<input class="publisher-input" type="text" placeholder="Write something"  id="chatContent">
                    	 <a href="${pageContext.request.contextPath}/matching/chatToId/${fromId}" type="button" class="publisher-btn text-info"  data-abc="true" onclick="submitFunction()"><i class="fa fa-paper-plane"></i></a> 
                    </div>
                </div>
            </div>
            <button type="button" class="btn btn-outline-primary" onclick="popupClose()">닫기</button>
        </div>
    </div>
</div>

</body>
</html>