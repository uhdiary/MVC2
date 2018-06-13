<%@page import="reservation.model.vo.MReservation"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page import="java.util.*, member.model.vo.Member" %>
<%
	ArrayList<MReservation> list = (ArrayList<MReservation>)request.getAttribute("list");
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
	$(document).ready(function() {
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");
		
		
		
		$("table#search tr:eq(0)");
	  	$("table#search tr:gt(0)").hover(
				function(){
					$(this).addClass("bg");
				},
				function(){
					$(this).removeClass("bg");
				}
	  	);
		

	
	
	$("table#search1 tr:eq(0)");
  	$("table#search1 tr:gt(0)").hover(
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
.name{
color:#464543;
font-size: 25px;
font-weight: bold;
}

.line1 {

	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line2 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line3 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line4 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}

.line5 {
	color:white;
	background:#00AEF0;
	border-radius: 3px;
}



.line22 {
 	border-top: 1px solid #464543; 
	border-bottom: 1px solid #464543;
	height:55px;
}




.bg{
background:#FFF798; opacity:0.7;
}

.sel {
	-moz-border-radius: 5px;
	-webkit-border-radius: 5px;
	margin-left : 575px;
	position: relative;
	left:40px;
	top:3px;
    width: 100px;
    height: 30px;
   }
   
.top{
width:959px;
height:50px;
}


.bottom{
width:959px;
height:100px;
}

#button1 {
	background: #00AEF0;
	width: 100px;
	height: 35px;
	color: white;
	border: 0px;
	border-radius: 5px;
	position: relative;
	left:850px;
	top:20px;
}

.img5{
width:170px;
height:120px;
position: relative;
border-radius: 5px;
}

.hotel_a{


text-align: center;
padding-left: 15px;

}
.nonono{
color:black;
text-decoration: none;
}

.nonono:hover{
color:#00AEF0;
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
</style>
</head>
<body>
		<header></header>
		<div class="top"></div>
		<section>
		<h3 class="name">진행중인 호텔예약 내역</h3>
		<table id="search"  style="width:959; height:15; align:center;">
			<tr>
				
				<td width="600" class="line2"><p align=center>예약 호텔 정보</p></td>
				<td width=180 class="line4"><p align=center>체크인</p></td>
				<td width=180  class="line4"><p align=center>체크아웃 날짜</p></td>
				<td width=180  class="line5"><p align=center>인원수</p></td>
				<td width=180  class="line5"><p align=center>결제금액</p></td>
				<td width=180  class="line5"><p align=center>예약날짜</p></td>
			
				
			</tr>
			
			<%
			
			 Date today = new Date(); 
			 
			SimpleDateFormat date = new SimpleDateFormat("yyyyMMdd");
			
			int a = Integer.parseInt(date.format(today));
			
			
			for(MReservation n :list){ 
				if((a < n.getRev_checkout())) {	
			%>
			<tr class="line222">
				<td width="600" class="line22"><a class="nonono" href="/hotel/mrdetail?rev_no=<%=n.getRev_no()%>"><img align=center class="img5" src="<%= n.getHotel_link()%>1.jpg"><span align="center" class="hotel_a"><%=n.getHotel_name()%></span></a></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_checkin() %></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_checkout() %></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_person_count()%></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_price() %></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_date() %></p></td>
			</tr>
			
			<% } } %>
		</table>
		
		<div class="top"></div>
		
		<span class="name">지난 호텔예약 내역 (최근 3개월 내역)</span>
		<div style="height:25px;"></div>
		<table id="search1" style="width:959; height:15; align:center" >
			<tr >
				
				<td width="600" class="line2"><p align=center>예약 호텔 정보</p></td>
				<td width=180 class="line4"><p align=center>체크인</p></td>
				<td width=180  class="line4"><p align=center>체크아웃 날짜</p></td>
				<td width=180  class="line5"><p align=center>인원수</p></td>
				<td width=180  class="line5"><p align=center>결제금액</p></td>
				<td width=180  class="line5"><p align=center>예약날짜</p></td>
			
				
			</tr>
			
			
		<%
			
			for(MReservation n: list){ 
				if((a > n.getRev_checkout())) {	
			%>
		<tr class="line222">
				<td width="600" class="line22"><a class="nonono" href="/hotel/mrdetail?rev_no=<%=n.getRev_no()%>"><img align=center class="img5" src="<%= n.getHotel_link()%>1.jpg"><span align="center" class="hotel_a"><%=n.getHotel_name()%></span></a></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_checkin() %></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_checkout() %></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_person_count()%></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_price() %></p></td>
				<td width=180 class="line22"><p align=center><%=n.getRev_date() %></p></td>
			</tr>
			
			<% }} 
			%>
		
		</table>
		</section>
		<div class="bottom"></div>
		<footer></footer>
</body>
</html>