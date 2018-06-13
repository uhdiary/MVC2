<%@page import="hotel.model.vo.Hotel"%>
<%@page import="member.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	Member loginUser = (Member)session.getAttribute("loginUser");
	Hotel list = (Hotel) request.getAttribute("list");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<style type="text/css">

#main_header {
	position: relative;
	height: 75px;
	background-color: #464543;
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
	font-family: 'Nanum Gothic', sans-serif;
	overflow: hidden;
	border: 11px solid #00AEF0;
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
	color: #00AEF0;
	font-weight: bold;
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

	<nav>
		<div id="main_gnb">
			<ul class="left">
				<li><a href="/hotel/revhmg?hotel_name=<%=loginUser.getHotel_name() %>">호텔 예약 관리</a></li>
				
			</ul>
			<ul class="right">
				<li><a>호텔 관리자 계정</a></li>
				
			</ul>
		</div>
	</nav>
	
</body>
</html>