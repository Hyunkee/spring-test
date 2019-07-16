<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" style="color:white">ID ${user.id}</a> 
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="<%=request.getContextPath()%>/logout">로그아웃</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">회원정보 수정</a>
      </li>        
    </ul>
  </div>  
</nav>
