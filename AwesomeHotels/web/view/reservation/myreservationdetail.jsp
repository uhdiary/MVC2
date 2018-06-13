<%@page import="reservation.model.vo.MyReservationDetail"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ page import="member.model.vo.Member" %>
	<%
	MyReservationDetail list = (MyReservationDetail)request.getAttribute("list");
	String juso[] = list.getHotel_address().split("/");
	Member loginUser = (Member)session.getAttribute("loginUser");
%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="/resources/demos/style.css">
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<script>
	$(function() {
		$("header").load("/hotel/view/common/header.jsp");
		$("footer").load("/hotel/view/common/footer.html");
	
		
		
	
	});
	

</script>
<style type="text/css">
.top{
height:30px;
}
.revervet {
	position:relative;
	left:-50px;
	font-weight: bold;
	width: 900px;
	height: 500px;
	border: 3px solid #00AEF0;
	text-align: center;
	border-radius: 5px;
	color:#464543;
	padding: 5px;
}

#checkin, #checkout {
	font-size: 17px;
	height: 25px;
	width:150px;
	text-align: center;
	border: 3px solid #00AEF0;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	
}

#button1 {
	background: #00AEF0;
	width: 100px;
	height: 50px;
	color: white;
	border: 0px;
	border-radius: 5px;
}


table{
	border: 3px solid #00AEF0;
}
.chetext {
	color:white;
	font-weight: bold;
	
}
.footgong{
height:30px;
}
.footta{
border:none;
}

.scenter{
position: relative;
left:80px;
}
.imgho{
width:375px;
height:250px;
border-radius: 5px;
border: 5px solid yellow;

}
.topsolid{
border-radius: 7px;
width:400px;
}

.day1{
position: relative;
left:50px;
background: white;
width: 100px;
height: 50px;
border-radius: 5px;
color:#00AEF0;
font-weight: bold;
border:0px;
font-size: 12px;
}
.name23{
color:#00AEF0;
font-size:30px;

}
.not1{
padding: 20px;
position: relative;
top:-20px;
}
.topon{
	position:relative;
	left:-50px;
	font-weight: bold;
	width: 900px;
	border: 3px solid #00AEF0;
	text-align: center;
	border-radius: 5px;
	color:#464543;
	padding: 5px;

}
.padd{
height:8px;

}
.day2{
position: relative;
top:-10px;
left:50px;
color: white;

}
.day5{
	position:relative;
	left:-50px;
	height:180px;
	font-weight: bold;
	width: 900px;
	text-align: center;
	font-color:white;
	padding: 5px;
	border:none;
	background: #00AEF0;
	border-radius: 5px;

}
.day11{
position: relative;
top:9px;
left:50px;
width:50px;
height: 25px;
text-align: center;
border: 3px solid #00AEF0;
border-radius: 7px;
font-size: 20px;

}




#price{
background:#00AEF0;
color:white;
border:none;
text-align:right;
font-size:20px;

}
.p123{
position: relative;
left:150px;
}
.p56{
position: relative;
left:207px;
}
.p57{
position: relative;
left:200px;
}
.p124{
position: relative;
left:70px;
}
#button1{
position: relative;
left:190px;
}

#msg1{
font-weight: bold;
size: 15px;


}
div #p1{
vertical-align:middle;
}
.nnn1{
color:#00AEF0;
font-size: 18px;
}
.aone{

color:#00AEF0;
}
</style>
</head>
<body>

		<header></header>
		<div id = "msg1" align="center" style = "display: none; margin:auto;"><p id="p5"></p></div>
				<div class="scenter">
				
		<section>
			<div class="reverse1">
			
					<div class="footgong"><input type="hidden" class="hotel_no" value="<%=list.getHotel_no() %>"></div>
				<h2 class="aone"><%=loginUser.getUser_name() %>님 <%=list.getRev_date() %> 예약 상황</h2>
				<table class="topon">
					<tr style="height: 120px;">
						<td><img class="imgho" src="<%= list.getHotel_link()%>1.jpg"></td>
						<td class="topsolid" align="left" colspan="2"><div class="not1">
						<span class="name23"><%=list.getHotel_name() %></span><br><br>
						주소 : <%=juso[0] %><br><br>
						여행지 : <%=list.getHotel_travel() %></div>
						</td>
					</tr>
					</table>
					<div class="padd"></div>
					<form action="/hotel/mrcancle?rev_no=<%=list.getRev_no()%>&user_id=<%=loginUser.getUser_id() %>" method="post">
					<table class="day5">
					<tr>
						<td class="inertd2">
							<div>
								<label class="chetext">체 크 인</label><br>
								<br> <input type="text" id="checkin" name="checkin" readonly value="<%=list.getRev_checkin()%>">
							</div>

						</td>
						<td class="inertd2">
							<div>
								<label class="chetext">체 크 아 웃</label><br>
								<br> <input type="text" id="checkout" name="checkout" readonly value="<%=list.getRev_checkout()%>">
							</div>
						</td>
						<td><span class="day2">명 수</span><br>
						<input type="text" class="day11" readonly value="<%=list.getRev_person_count()%>"></td>
						<td class="inertd2" style="width:300px; heigth:100px;"><label class="chetext"><input type="submit" class="day1" value="예약 취소"></label></td>
					</tr>
					</table>
					</form>
					<div class="padd"></div>
					<form action="/hotel/res?hotel_no=<%=list.getHotel_no()%>" method="post" name="f2" >
					<table class="revervet">
					<tr>
						<td align="left" colspan="3"><span class="nnn1">체크인 시간</span> <br><br> <%=list.getHotel_start_time() %><br><br>
						<span class="nnn1">체크아웃 시간</span><br><br> <%=list.getHotel_end_time()%><br><br>
						<span class="nnn1">서비스</span><br><br> <%=list.getHotel_fac2() %></td>
					</tr>

					
					<tr>
						<td colspan="2"
							style="text-align: center; background: #00AEF0; color: white; border-radius: 5px;">예약 금액(KRW)</td>
						<td style="background: #00AEF0; color: white; border-radius: 5px;"><input type="text" id="price" class="p123" readonly name="price" value="<%= list.getRev_price()%>"> <span class="p123">원</span></td>
					</tr>
				</table>
				</form>
				
			</div>
		</section>
		</div>
		
		<div class="footgong"></div>
		
		<footer></footer>

</body>
</html>