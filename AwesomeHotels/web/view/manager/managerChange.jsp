<%@page import="manager.model.vo.Manager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
	Manager manager = (Manager)request.getAttribute("manager");
	String a[] = manager.getHotel_address().split("/");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset=UTF-8">
<title>hotel change</title>
<link rel="stylesheet" type="text/css" href="/hotel/css/common.css">
<script src="/hotel/js/jquery-3.1.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("header").load("/hotel/view/common/mgheader.html");
		$("footer").load("/hotel/view/common/footer.html");

	});
</script>
<style type="text/css">
.write {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 10px;
	text-align: center;
	vertical-align: right;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 37px;
	padding: 13px;
	position: relative;
	left: 680px;
}

.write1 {
	background-color: #00AEF0;
	text-decoration: none;
	font-family: Arial;
	line-height: 10px;
	-moz-border-radius: 7px;
	-webkit-border-radius: 7px;
	border-radius: 10px;
	text-align: center;
	vertical-align: right;
	display: inline-block;
	font-size: 15px;
	color: #ffffff;
	width: 70px;
	height: 36px;
	padding: 13px;
	bgcolor: #9f9f9f;
	position:relative;
	left:79%;
	top:-37px;
}

.foot1{
height:30px;
}

.c_header{
position: relative;
left:130px;
}

</style>
</head>
<body>
	
		<header></header>
		<form action="/hotel/mgupdate?hotel_no=<%= manager.getHotel_no() %>" method="post">
		
			
				<div class="c_header">
					<h2 style="margin-right:550px; color:#1e94cc; font-weight:bold;">호텔 정보 수정</h2>
				</div>
				
				<table width="700" height=1000 class="tbl_model" align="center"
					cellspacing=0; style='table-layout:fixed; border-bottom :solid 1px #00AEF0;'>
					<colgroup>
						<col style="width: 22%">
						<col>
					</colgroup>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">호텔명
						</th>
						<td
							style='border-bottom: solid 1px #00AEF0; border-top: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_name" value="<%= manager.getHotel_name() %>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20">
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">호텔주소
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<input type="text" name="hotel_address" value="<%= a[0] %>"
									style='border: 0; padding: 0; width: 500px; height: 50px; align: center; border-width: 0; font-size: 12pt;'
									size="100">
							</div>
						</td>
					</tr>

					

					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">사진링크
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<input type="text" name="hotel_link" value="<%= manager.getHotel_link()%>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">일반사항
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<textarea cols="40" name="hotel_fac1" style='border: 0; padding: 0; width: 500px; height: 72px; align: center; font-size: 12pt; resize: none;'><%= manager.getHotel_fac1() %></textarea></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">서비스
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<textarea cols="40" name="hotel_fac2" style='border: 0; padding: 0; width: 500px; height: 72px; align: center; font-size: 12pt; resize: none;'><%= manager.getHotel_fac2() %></textarea></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">호텔정보
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
								<textarea cols="40" name="hotel_info" autofocus style='border: 0; padding: 0; width: 500px; height: 72px; align: center; font-size: 12pt; resize: none;'><%= manager.getHotel_info() %></textarea>
							</div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">인터넷
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<input type="text" name="hotel_fac3" value="<%= manager.getHotel_fac3()%>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">주차
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<input type="text" name="hotel_fac4" value="<%= manager.getHotel_fac4()%>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">체크인
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<input type="text" name="hotel_start_time" value="<%= manager.getHotel_start_time()%>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">체크아웃
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<input type="text" name="hotel_end_time" value="<%= manager.getHotel_end_time()%>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20"></div>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">주변관광지
						</th>
						<td style='border-bottom: solid 1px #00AEF0;'>
							<div class="tdcell" align="center">
		<textarea cols="40" name="hotel_travel" style="border: 0; padding: 0; width: 500px; height: 40px; align: center; font-size: 12pt; resize: none;"><%= manager.getHotel_travel() %></textarea>
						</td>
					</tr>
					<tr>
						<th scope="row"
							style="background: #00AEF0; border-right: solid 1px #00AEF0; border-bottom: solid 1px white; border-radius: 7px;">
							<div class="thcell" style="color: white;">가격
						</th>
						<td>
							<div class="tdcell" align="center">
		<input type="text" name="hotel_price" value="<%= manager.getHotel_price()%>"
									style='border: 0; padding: 0; width: 500px; height: 40px; align: center; border-width: 0; font-size: 12pt;'
									size="20">
						</td>
					</tr>
				</table>
				<br>
				<table width=604 class="write_m">
					<input type="submit" bgcolor="#00AEF0" value="수정" class="write" >
				</table>
				</form>
				<form action="/hotel/mgdel?hotel_no=<%= manager.getHotel_no() %>" method="post">
				<input type="submit" class="write1" value="삭제">
				</form>
				<div class="foot1"></div>
				<footer></footer>
	
</body>
</html>