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
<div class="container">
	<table class="table">
		<tr>
			<th width="10%">번호</th>
			<th width="50%">제목</th>
			<th width="10%">작성자</th>
			<th width="20%">등록일</th>
			<th width="10%">조회수</th>
		</tr>
		<c:forEach var="board" items="${list}">
		<tr>
			<th>${board.num}</th>
			<th><a href="<%=request.getContextPath()%>/board/display?num=${board.num}">${board.title}</a></th>
			<th>${board.writer}</th>
			<th>${board.registered}</th>
			<th>${board.views}</th>
		</tr>
		</c:forEach>		
	</table>
	<a href="<%=request.getContextPath()%>/board/insert"><button type="button" class="btn btn-outline-primary">등록하기</button></a>
</div>
</body>
</html>