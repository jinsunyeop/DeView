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
    
    
    
    
 
<%@ include file="/resources/layout/footer.jsp"%>
</html>