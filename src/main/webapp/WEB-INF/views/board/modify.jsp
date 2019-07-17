<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/bootstrap.jsp"></jsp:include>
<title>게시판 리스트</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
<form action="<%=request.getContextPath()%>/board/modify" method="post">
	<div class="container" style="margin-top:20px;">
	    <input type="hidden" class="form-control" name="num" value="${board.num}">	        
	    <div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="title" value="">
	    </div>
	    <div class="form-group">
		  <label>작성자</label>
		  <input type="text" class="form-control" name="writer" value="${user.id}" readonly>
	    </div>
	    <div class="form-group">
		  <label>작성일</label>
		  <input type="text" class="form-control" name="" value="" readonly>
	    </div>
	    <div class="form-group">
		  <label>조회수</label>
		  <input type="text" class="form-control" name="" value="" readonly>
	    </div>
	    <div class="form-group">
		  <label>내용</label>
		  <textarea class="form-control" rows="5" name="contents"></textarea>
		</div>
	    <div class="form-group">
		  <label>파일첨부</label>
		  <input type="text" class="form-control" name="file" value="">
	    </div>	    		
		<button type="submit" class="btn btn-outline-primary">수정하기</button>
		<a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-primary">목록보기</button></a> 					
	</div>	
</form>
</body>
</html>