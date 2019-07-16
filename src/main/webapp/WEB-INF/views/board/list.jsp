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
<table>
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>조회수</th>
	</tr>
	<c:forEach var="tmp" items="${list}">
	<tr>
		<th>${tmp.num }</th>
		<th><a href="<%=request.getContextPath()%>/board/display?num=${tmp.num}">${tmp.title }</a></th>
		<th>${tmp.writer }</th>
		<th>${tmp.registered }</th>
		<th>${tmp.views }</th>
	</tr>
	</c:forEach>
</table>
</body>
</html>