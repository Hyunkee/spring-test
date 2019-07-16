<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/WEB-INF/views/common/bootstrap.jsp"></jsp:include>
<title>게시판 화면</title>
</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	${board.title } <br>
	${board.writer } <br>
	${board.registered } <br>
	${board.views } <br>
	${board.contents } <br>
</body>
</html>