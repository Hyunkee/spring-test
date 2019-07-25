<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">	
	<jsp:include page="/WEB-INF/views/common/bootstrap.jsp"></jsp:include>
	<script type="text/javascript">
		$(document).ready(function(){
			$('#pwFind').click(function(){
				var id = $('input[name=id]').val();
				var email = $('input[name=email]').val();
				if(id.length == 0 || email.length == 0){ 
					alert('아이디와 이메일을 입력해주세요');
					return false;
				}
				var send = false;
				$.ajax({
			        async:false,
			        type:'POST',
			        data:{'id':id,'email':email},
			        url:"<%=request.getContextPath()%>/checkemail",
			        dataType:"json",
			        contentType:"application/json; charset=UTF-8",
			        success : function(data){
			        	send = data.isMember;
			            if(!data.isMember){
			            	alert('회원정보가 일치하지 않습니다.');			            	
			            }else{
			            	alert('새비밀번호를 해당 메일로 전송했습니다.');			            	
			            }			            
			        }
			    });			
				return send;
			});
		});
	</script>
	<title>로그인</title>
	<style>
	*{
		margin: 0;
		padding : 0;
	}
	.main{
		margin-top:50px;
	}
	.row{
		margin: 5px 0px;
	}
	.fab.fa-amazon{
		font-size: 100px;
		color: red;
	}
	</style>

</head>
<body>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<jsp:include page="/WEB-INF/views/common/navbar.jsp"></jsp:include>
	<div class="offset-4 col-4 border border-dark mt-5">
		<h1 class="text-center">비밀번호 찾기</h1>
		<form action="<%=request.getContextPath()%>/password/send" method="post" >
			<div class="row">
				<label class="col-4">아이디</label>
				<input type="text"class="form-control col-7" placeholder="아이디" name="id">
			</div>
			<div class="row">
				<label class="col-4">이메일</label>
				<input type="text"class="form-control col-7" placeholder="이메일" name="email">
			</div>
			<div class="offset-8 col-3 clearfix p-0">
				<button class="btn btn-primary float-right" id="pwFind">비밀번호 찾기</button>
			</div>
		</form>	
	</div>
</body>
</html>