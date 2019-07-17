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
	<div class="container" style="margin-top:20px;">	              
	    <div class="form-group">
		  <label>제목</label>
		  <input type="text" class="form-control" name="title" value="${board.title}" readonly>
	    </div>
	    <div class="form-group">
		  <label>작성자</label>
		  <input type="text" class="form-control" name="writer" value="${board.writer}" readonly>
	    </div>
	    <div class="form-group">
		  <label>작성일</label>
		  <input type="text" class="form-control" name="registered" value="${board.registered}" readonly>
	    </div>
	    <div class="form-group">
		  <label>조회수</label>
		  <input type="text" class="form-control" name="views" value="${board.views }" readonly>
	    </div>
	    <div class="form-group">
		  <label>내용</label>
		  <textarea class="form-control" rows="5" name="contents" readonly>${board.contents }</textarea>
		</div>
	    <div class="form-group">
		  <label>파일첨부</label>
		  <input type="text" class="form-control" name="file" value="${board.file }" readonly>
	    </div>
	    <a href="<%=request.getContextPath()%>/board/list"><button type="button" class="btn btn-outline-primary">목록보기</button></a>	
	
		<c:if test="${user.id eq board.writer && user ne null}">
			<a href="<%=request.getContextPath()%>/board/modify?num=${board.num}"><button type="button" class="btn btn-outline-primary">수정하기</button></a>
		</c:if>
		
		<c:if test="${user.id eq board.writer && user ne null}">
			<a href="<%=request.getContextPath()%>/board/delete?num=${board.num}"><button type="button" class="btn btn-outline-primary">삭제하기</button></a>
		</c:if>	
		
		<a href="<%=request.getContextPath()%>/board/insert"><button type="button" class="btn btn-outline-primary">등록하기</button></a>	  		
	</div>
	
</body>
</html>