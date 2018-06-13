<%@page import="hotel.model.vo.Hotel"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="member.model.vo.Member" %>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	Hotel list = (Hotel) request.getAttribute("list");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script type="text/javascript">

$(function(){
	
$(".day500").click(function(){
	var user = $(".user").val();
	
	if(user == "1"){
		$("#p5").html("로그인 되어 있지 않습니다.");
		$("#msg1").dialog({
				title:"로그인후 진행하여 주세요", width:500,
				height:130, modal:true, resizable:false,
				show:true, hide:true, draggable:false
			});
		return false;
	}
	
	
});	
});

function openNewWindow(window){
	open("/hotel/view/member/login.jsp", "login",  "left="+(screen.availWidth-400)/2+", top="+(screen.availHeight-270)/2+", width=400px,height=270px");	
}

</script>



<style type="text/css">

#main_header {
	position: relative;
	height: 75px;
	background-color: #00AEF0;
	color: white;
	font-size: 24px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}
#main_header>h1.logo {
	position: absolute;
	margin-left: 15px;
	font-family: 'Abril Fatface', cursive;
	top: 0px;
}

#main_gnb {
	overflow: hidden;
	font-family: 'Nanum Gothic', sans-serif;
	background-color: #464543;
	border-bottom-left-radius: 5px;
	border-bottom-right-radius: 5px;
}



a {
	text-decoration: none;
}

ul {
	list-style: none;
}

#main_gnb>ul.left {
	overflow: hidden;
	float: left;
}

#main_gnb>ul.right {
	overflow: hidden;
	float: right;
}

#main_gnb>ul.left {
	float: left;
}

#main_gnb>ul.right {
	float: left;
}



#main_gnb>ul.left {
	overflow: hidden;
	float: left;
}

#main_gnb>ul.right {
	overflow: hidden;
	float: right;
}

#main_gnb>ul.left>li {
	float: left;
}

#main_gnb>ul.right>li {
	float: left;
}

#main_gnb a {
	display: black;
	padding: 10px 20px;
	color: white;
	font-weight:bold;
}

#main_gnb a:hover{
color:#00AEF0;
font-weight:bold;
}



.logo a{
color: white;
}


</style>
</head>
<body>
	<header id="main_header">
		<h1 class="logo"><a href="/hotel/view/main/main.html">Awesome Hotels</a></h1>
	</header>
	<% if(loginUser!= null){%>
	<input type="hidden" class="user" value="<%=loginUser.getUser_id() %>"> 
	<%}else{%>
	<input type="hidden" class="user"value="1"> 
	<% }%>
	<div id = "msg1" align="center" style = "display: none; margin:auto;"><p id="p5"></p></div>
	<nav>
		<div id="main_gnb">
			<ul class="left">
				<li><a href="/hotel/view/search/search.jsp">호텔검색</a></li>
				
				<%if(loginUser!=null){ %>
				<%if(loginUser.getUser_code().trim().equals("1")){ %>
				<li><a class="day500" href="/hotel/mreverve?user_id=<%=loginUser.getUser_id()%>">내 예약 정보</a></li>
				<%}}else{ %>
				<li><a class="day500">내 예약 정보</a></li>
				
				<%} %>
				<li><a href="/hotel/blist">문의사항</a></li>
			</ul>
			<div id="mask"></div>
			<ul class="right">
					<% if(loginUser == null){ %>
					<li><a id="popup" class='login' OnClick="openNewWindow()">로그인</a></li>
					<li><a href="/hotel/view/member/enrollForm.html">회원가입</a></li>
					<% }else if(loginUser.getUser_code().trim().equals("3") ){  %>
					
					<li><a href="/hotel/revhmg?hotel_name=<%=loginUser.getHotel_name() %>"><%= loginUser.getHotel_name() %></a></li>
					<li><a href="/hotel/logout">로그아웃</a></li>
					<% }else if(loginUser.getUser_code().trim().equals("1")) { %>
					<li><a href="/hotel/myinfo?user_id=<%= loginUser.getUser_id() %> "><%= loginUser.getUser_name() %>님 환영합니다.</a></li>
					<li><a href="/hotel/logout">로그아웃</a></li>
					<% }else{%>
					<li><a href="/hotel/mglist">사이트 관리자</a></li>
					<li><a href="/hotel/logout">로그아웃</a></li>
					
					<% }%>
			</ul>
		</div>
	</nav>

</body>
</html>