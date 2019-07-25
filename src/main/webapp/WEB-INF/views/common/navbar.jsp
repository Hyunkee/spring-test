<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	.navbar{
		margin-bottom: 40px;
	}
</style>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <a class="navbar-brand" style="color:white">ID ${user.id}</a> 
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
	    <c:if test="${user eq null}">	   	
	      <li class="nav-item">
	        <a class="nav-link" href="<%=request.getContextPath()%>/login">로그인</a>
	      </li>
	    </c:if>
	    <c:if test="${user eq null}">	   	
	      <li class="nav-item">
	        <a class="nav-link" href="<%=request.getContextPath()%>/member">회원가입</a>
	      </li>
	    </c:if>
	   	<c:if test="${user ne null}">	   	
	      <li class="nav-item">
	        <a class="nav-link" href="<%=request.getContextPath()%>/logout">로그아웃</a>
	      </li>
	     </c:if>
	     <c:if test="${user ne null}">
	      <li class="nav-item">
	        <a class="nav-link" href="<%=request.getContextPath()%>/member/modify"">회원정보 수정</a>
	      </li>
    	</c:if>
	    <li class="nav-item">
	    	<a class="nav-link" href="<%=request.getContextPath()%>/">홈</a>
	    </li>
	    <li class="nav-item">
	      	<a class="nav-link" href="<%=request.getContextPath()%>/board/list">게시판</a>
	    </li>                
    </ul>
  </div>  
</nav>
