<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	Member loginUser = (Member)session.getAttribute("loginUser");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
$(function(){
	$("header").load("/hotel/view/common/header.jsp");
	$("footer").load("/hotel/view/common/footer.html");
});

</script>
<style type="text/css">
.gong{
height:20px;
}
.susno{
color:black;

}
.desc{
height:0px;
position: relative;
top:-280px;
left:250px;
color:white;
font-size:35px;
font-weight: bold;
}
.mainingi+.desc{display:none;
}
.mainingi:hover+.desc{display:block;
}

.desc{display:none;
}
.desc:hover{display:block;
}
</style>
</head>
<body>
	<header></header>
		<div class="gong"></div>
	<section>

	<div class="susno">
	
	<h2 style="color:#2C4162;"><%=loginUser.getUser_id() %>님 호텔 예약에 성공 했습니다.</h2>
	
	<a href="/hotel/mreverve?user_id=<%=loginUser.getUser_id()%>"><img class="mainingi" style="width:959px; height:500px;" src="/hotel/view/reservation/image/successs.jpg">
	<span class="desc">내 예약 정보 확인 하러가기</span></a>
	
	</div>
	</section>
       <div class="gong"></div>
	<footer></footer>

</body>
</html>