<%@page import="reservation.model.vo.MReservation"%>
<%@page import="member.model.vo.Member"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	ArrayList<MReservation> list = (ArrayList<MReservation>)request.getAttribute("list");
	Member loginUser = (Member)session.getAttribute("loginUser");
	
	String keyword = (String)request.getAttribute("keyword");
	
	//총 목록수
		int listCount = ((Integer)request.getAttribute("listCount")).intValue();
		//현재 보여질 목록 페이지
		int currentPage = ((Integer)request.getAttribute("currentPage")).intValue();
		//현재 페이지(19)의 시작 페이지(11)
		int startPage = ((Integer)request.getAttribute("startPage")).intValue();
		//현재 페이지(19)의 마지막 페이지(20)
		int endPage = ((Integer)request.getAttribute("endPage")).intValue();
		//맨 마지막 페이지
		int maxPage = ((Integer)request.getAttribute("maxPage")).intValue();
		
		int a = 0;
		
		for(MReservation m: list){
		a = m.getHotel_no();
		}

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
	$(document).ready(function() {

		$("header").load("/hotel/view/common/mgrevheader.jsp");
		$("footer").load("/hotel/view/common/footer.html");	
	

	  	<%if (list.size()==0) {%>
	    $("#msg1").dialog({
	          title : "검색",
	          width : 430,
	          height : 165,
	          modal : true,
	          resizable : false,
	          draggable : false
	       });
	 <%}%>
		
		
	$("table#search tr:eq(0)");
  	$("table#search tr:gt(0)").hover(
			function(){
				$(this).addClass("bg");
			},
			function(){
				$(this).removeClass("bg");
			}
  	);
	
  	
	});
</script>
<style type="text/css">
.write111 {
	background: #00AEF0;
	border-radius: 5px;
	font-size: 20px;
	color: white;
	width: 100px;
	height: 50px;
	align: center;
	position: relative;
	left:850px;
	top:-120px;
	
}



/* background:linear-gradient(to bottom, white,#FFF798); */




 .bg{background:#FFF798; opacity:0.7;} 




.write1 {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	text-align: center;
	vertical-align: right;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 5px;
	padding: 13px;
	margin-left: 10px;
}

.write1:active {
	position: relative;
	top: 3px
}

.write2 {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	text-align: center;
	vertical-align: right;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 5px;
	padding: 13px;
	margin-left: 10px;
}

.write2:active {
	position: relative;
	top: 3px
}

.write_m {
	margin-left: 345px;
}

.bt {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	border-radius: 5px;
	text-align: center;
	vertical-align: right;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 5px;
	padding: 13px;
	margin-right: 180px;
	position: relative;
	left:700px;
	top:-5px;
}

.bt:active {
	position: relative;
	top: 3px
}

.text {
	border:0px;
	border-bottom: 3px solid #00AEF0;
	resize: none;
	display: inline;
	text-align: middle;
	font-size:15px;
	height:27px;
	position: relative;
	left:700px;
	top:-5px;
}

.line11 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line21 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line31 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line41 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line51 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}


.line1 {

	border-top: 1px solid #464543;
	border-bottom: 1px solid #464543;
}

.line2 {
	border-top: 1px solid #464543;
	border-bottom: 1px solid #464543;
}

.line3 {
	border-top: 1px solid #464543;
	border-bottom: 1px solid #464543;
}

.line4 {
	border-top: 1px solid #464543;
	border-bottom: 1px solid #464543;
}

.line5 {
	border-top: 1px solid #464543;
	border-bottom: 1px solid #464543;
}

.sel {
	margin-left : 575px;
	position: relative;
	left:35px;
	top:5px;
    width: 100px;
    height: 30px;
    font-size:15px;
    font-weight: bold;
   
}
.top{
width:959px;
height:50px;
}


.bottom{
width:959px;
height:100px;
}
#bd2{
color:#464543;
position: relative;
left:-25px;
}


.board {
	list-style: none;
	float: left;
	display: inline;
	margin-left: 260px;
}

.board li {
	float: left;
}


.aa{
position: relative;
left:35px;
color: black;
}
.bb{
color: black;
}
.bb:hover{
color:#00AEF0;
}

.aa:hover{
color:#00AEF0;
}
.search{
color:#464543;
}
.hotel_name{
color:#464543;
}


.line222{
   cursor: pointer;
    transition: box-shadow .2s, transform .2s, opacity;
	height:55px;
     
}
.line222:hover{
    box-shadow: 0 15px 20px rgba(0,0,0,0.2);
    transform: translate(0, -4px);
}
.paging{
position: relative;
left:400px;
top:-30px;
}
.page1{
background:#00AEF0;
color:white;
font-size:20px;
pading:10px;
border:1px solid white;
border-radius: 5px;
} 
.page1:HOVER{
background:yellow;
}

.page11{
background:yellow;

color:white;
font-size:20px;
pading:10px;
border:1px solid white;
border-radius: 5px;

}

.line222:hover{
    box-shadow: 0 15px 20px rgba(0,0,0,0.2);
    transform: translate(0, -4px);
}
</style>
</head>
<body>

	
		<header></header>
		<div id="msg1" style="display: none">
      <h3>검색값이 없습니다.</h3>
   </div>
		<div class="top"></div>
		
		<h2 class="hotel_name"><%=loginUser.getHotel_name() %></h2>
		<form action="/hotel/mrsearch?hotel_name=<%=loginUser.getHotel_name() %>" method="post">
		<table id="bd2" style="width:959; height:60; border:0;" >
			<tr>
				
				<td><input type="text" name="keyword" class="text" class="ta" id="userid" placeholder="아이디를 입력하세요.">
						</td>
						<td></td>
				<td><input type="submit" class='bt' id="day1" style="bgcolor:#9f9f9f;" value="검색"></td>
			</tr>
		</table>
		</form>
		<form action="/hotel/resmgjung?hotel_no=<%=a%>" method="post">
	
		<button class="write111">등록</button>
		</form>
		<table id="search" style="width:959; height:15; align:center;">
			<tr>
				<td width="200" class="line21"><p align=center>예약번호</p></td>
				<td width=200 class="line31"><p align=center>아이디</p></td>
				<td width=300 class="line41"><p align=center>체크인</p></td>
				<td width=300 class="line41"><p align=center>체크아웃 날짜</p></td>
				<td width=400 class="line51"><p align=center>인원수</p></td>
				<td width=400 class="line51"><p align=center>예약날짜</p></td>
			</tr>
			
			<%
			
			for(MReservation m: list) {
				 %>
			
			<tr class="line222">
				<td  width="200" class="line2"><a class="aa" align=center href="/hotel/ressu?rev_no=<%=m.getRev_no()%>"><%=m.getRev_no() %></a></td>
				<td width=200 class="line3"><a class="bb" href="/hotel/mruser?user_id=<%=m.getUser_id()%>"><p align=center><%=m.getUser_id() %></p></a></td>
				<td width=300 class="line4"><p align=center><%=m.getRev_checkin()%></p></td>
				<td width=300 class="line4"><p align=center><%=m.getRev_checkout() %></p></td>
				<td width=400 class="line5"><p align=center><%=m.getRev_person_count() %></p></td>
				<td width=400 class="line5"><p align=center><%=m.getRev_date() %></p></td>
			</tr>
			
			
			<%} %>
		</table>
		<div class="top"></div>
		
		
		
<%if(keyword == null){%>
	<div class="paging">
   <%if(currentPage <= 1){
%><span class="page1">&nbsp;이전&nbsp;</span> 
<%}else{ %>
   <a class="page1"  href="/hotel/revhmg?hotel_name=<%=loginUser.getHotel_name() %>&page=<%= currentPage - 1%>">&nbsp;이전&nbsp;</a>
<%} %>
<% for(int p = startPage; p <= endPage; p++){ 
   if(p == currentPage){
%><b class="page11">&nbsp;<%= p %>&nbsp;</b>
<% }else{ %>
<a class="page1"  href="/hotel/revhmg?hotel_name=<%=loginUser.getHotel_name() %>&page=<%=p %>">&nbsp;<%= p %>&nbsp;</a>
<%}} %>
<% if(currentPage >= maxPage){ %>
<span class="page1">&nbsp;다음&nbsp;</span>
<%}else{ %>
<a class="page1" href="/hotel/revhmg?hotel_name=<%=loginUser.getHotel_name() %>&page=<%= currentPage + 1%>">&nbsp;다음&nbsp;</a>
<%}%> 
</div>
<%}%>



<%if(keyword != null){%> 
<!-- 검색결과가있을때 -->
<div class="paging">
<%
   if(currentPage <= 1){
%><span class="page1">&nbsp;이전&nbsp;</span>
<%}else{ %>
   <a class="page1"  href="/hotel/mrsearch?hotel_name=<%=loginUser.getHotel_name() %>&page=<%= currentPage - 1%>&keyword=<%=keyword%>">&nbsp;이전&nbsp;</a>
<%} %>

<% for(int p = startPage; p <= endPage; p++){ 
   if(p == currentPage){
%><b class="page11">&nbsp;<%= p %>&nbsp;</b>
<% }else{ %>
<a class="page1" href="/hotel/mrsearch?hotel_name=<%=loginUser.getHotel_name() %>&page=<%=p %>&keyword=<%=keyword%>">&nbsp;<%= p %>&nbsp;</a>
<%}} %>
<% if(currentPage >= maxPage){ %>
<span class="page1">&nbsp;다음&nbsp;</span>
<%}else{ %>
<a class="page1"  href="/hotel/mrsearch?hotel_name=<%=loginUser.getHotel_name() %>&page=<%= currentPage + 1%>&keyword=<%=keyword%>">&nbsp;다음&nbsp;</a>

<%}%> 
</div>
<%}%> 		
<div class="bottom"></div>
		<footer></footer>

	
</body>
</html>